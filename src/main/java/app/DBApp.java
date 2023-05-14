package app;

import sql.parser.SQLParser;
import com.opencsv.exceptions.CsvValidationException;
import datamanipulation.CsvReader;
import datamanipulation.CsvWriter;
import constants.Constants;
import exceptions.DBAppException;
import sql.SQLTerm;
import storage.Table;
import storage.Tuple;
import util.TypeParser;
import util.filecontroller.Serializer;
import util.search.Selector;
import storage.*;
import storage.index.*;
import util.TypeParser;
import sql.SQLTerm;
import datamanipulation.CsvReader;
import datamanipulation.CsvWriter;
import util.validation.Validator;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

/**
 * The DBApp class represents a database management system. It implements the
 * IDatabase interface and provides methods for initializing the system,
 * creating tables, creating indices, inserting, updating and deleting records,
 * and selecting records using SQL terms.
 */
public class DBApp implements IDatabase {

	private HashSet<String> myTables;
	private CsvReader reader;
	private CsvWriter writer;
	private Object clusteringKey;
	private String clusteringKeyValue;


	public DBApp() {
		this.myTables = new HashSet<>();
		this.writer = new CsvWriter();
		this.reader = new CsvReader();
	}

	public HashSet<String> getMyTables() {
		return myTables;
	}

	public CsvReader getReader() {
		return reader;
	}

	public CsvWriter getWriter() {
		return writer;
	}

	/**
	 * Initializes the database management system by reading all the tables from CSV
	 * file
	 *
	 */
	@Override
	public void init() {

		this.myTables = reader.readAllTables();

	}

	/**
	 * Creates a new table in the system with the specified parameters.
	 *
	 * @param strTableName           The name of the table.
	 * @param strClusteringKeyColumn The name of the clustering key column.
	 * @param htblColNameType        A Hashtable containing the name and data type
	 *                               of each column in the table.
	 * @param htblColNameMin         A Hashtable containing the name and minimum
	 *                               value of each column in the table.
	 * @param htblColNameMax         A Hashtable containing the name and maximum
	 *                               value of each column in the table.
	 *
	 * @throws DBAppException If the table name is invalid or if the table already
	 *                        exists.
	 * @throws ParseException
	 * @throws IOException    If an error occurs while creating the table files.
	 */
	@Override
	public void createTable(String strTableName, String strClusteringKeyColumn,
							Hashtable<String, String> htblColNameType, Hashtable<String, String> htblColNameMin,
							Hashtable<String, String> htblColNameMax) throws DBAppException {

		Validator.validateTableCreation(myTables, strTableName, strClusteringKeyColumn, htblColNameType, htblColNameMin,
				htblColNameMax);

		Table table = new Table(strTableName, strClusteringKeyColumn, htblColNameType, htblColNameMin, htblColNameMax);
		myTables.add(strTableName);
		writer.write(table);

		table.createTableFiles();
		Serializer.serializeTable(table);

	}

	/**
	 * Inserts a new record into the specified table.
	 *
	 * @param strTableName     The name of the table.
	 * @param htblColNameValue A Hashtable containing the name and value of each
	 *                         column in the record.
	 *
	 * @throws DBAppException         If the table name is invalid, the record data
	 *                                is invalid or the record already exists.
	 * @throws CsvValidationException If the record fails CSV validation.
	 * @throws IOException            If an error occurs while inserting the record.
	 * @throws ClassNotFoundException If an error occurs while serializing or
	 *                                deserializing the table.
	 * @throws ParseException         If an error occurs while parsing the record
	 *                                data.
	 */
	@Override
	public void insertIntoTable(String strTableName, Hashtable<String, Object> htblColNameValue) throws DBAppException {

		takeAction(Action.INSERT, strTableName, htblColNameValue);

	}

	/**
	 * Updates a record in a table.
	 *
	 * @param strTableName          the name of the table to update a record in.
	 * @param strClusteringKeyValue the value of the clustering key for the record
	 *                              to be updated.
	 * @param htblColNameValue      the new values for the record.
	 *
	 * @throws DBAppException         if there is an error with the database
	 *                                operations.
	 * @throws CsvValidationException if there is an error with the CSV file.
	 * @throws IOException            if there is an error with file operations.
	 * @throws ClassNotFoundException if there is an error with the serialization.
	 * @throws ParseException         if there is an error parsing the input.
	 */
	@Override
	public void updateTable(String strTableName, String strClusteringKeyValue,
							Hashtable<String, Object> htblColNameValue) throws DBAppException {

		this.clusteringKeyValue = strClusteringKeyValue;
		takeAction(Action.UPDATE, strTableName, htblColNameValue);
	}

	/**
	 * Deletes records from a table.
	 *
	 * @param strTableName     the name of the table to delete records from.
	 * @param htblColNameValue the values to match records to be deleted.
	 *
	 * @throws DBAppException         if there is an error with the database
	 *                                operations.
	 * @throws CsvValidationException if there is an error with the CSV file.
	 * @throws IOException            if there is an error with file operations.
	 * @throws ClassNotFoundException if there is an error with the serialization.
	 * @throws ParseException         if there is an error parsing the input.
	 */
	@Override
	public void deleteFromTable(String strTableName, Hashtable<String, Object> htblColNameValue) throws DBAppException {

		takeAction(Action.DELETE, strTableName, htblColNameValue);
	}
	

	/**
	 * Performs an action (insert, delete, or update) on a table.
	 *
	 * @param action           the action to perform.
	 * @param strTableName     the name of the table to perform the action on.
	 * @param htblColNameValue the values to use for the action.
	 *
	 * @throws DBAppException         if there is an error with the database
	 *                                operations.
	 * @throws CsvValidationException if there is an error with the CSV file.
	 * @throws IOException            if there is an error with file operations.
	 * @throws ClassNotFoundException if there is an error with the serialization.
	 * @throws ParseException         if there is an error parsing the input.
	 */
	private void takeAction(Action action, String strTableName, Hashtable<String, Object> htblColNameValue)
			throws DBAppException {

		Validator.validateTable(strTableName, myTables);
		Table table = Serializer.deserializeTable(strTableName);

		if (action == Action.INSERT) {

			takeInsertAction(table, htblColNameValue);
		} else if (action == Action.DELETE) {

			takeDeleteAction(table, htblColNameValue);
		} else {

			takeUpdateAction(table, htblColNameValue);
		}
		Serializer.serializeTable(table);

	}

	private void takeInsertAction(Table table, Hashtable<String, Object> htblColNameValue) throws DBAppException {

		Validator.validateInsertionInput(table, htblColNameValue, myTables);
		table.insertTuple(htblColNameValue);
	}

	private void takeDeleteAction(Table table, Hashtable<String, Object> htblColNameValue) throws DBAppException {

		Validator.validateDeletionInput(table, htblColNameValue, myTables);
		table.deleteTuples(htblColNameValue);
	}

	private void takeUpdateAction(Table table, Hashtable<String, Object> htblColNameValue) throws DBAppException {

		castClusteringKeyType(table);
		Validator.checkNoClusteringKey(htblColNameValue, table);
		htblColNameValue.put(table.getPKColumn(), clusteringKey);
		Validator.validateUpdateInput(table, htblColNameValue, myTables);

		if (Validator.foundPK(table, htblColNameValue))
			table.updateRecordsInTaple(clusteringKey, htblColNameValue);
	}

	private void castClusteringKeyType(Table table) {

		clusteringKey = TypeParser.castClusteringKey(table, clusteringKeyValue);
	}

	public Iterator selectFromTable(SQLTerm[] arrSQLTerms, String[] strarrOperators) throws DBAppException {

		Validator.validateSelectionInput(arrSQLTerms, strarrOperators, myTables);
		Vector<Vector<Tuple>> result = new Vector<>();

		for (int i = 0; i < arrSQLTerms.length; i++) {
			Hashtable<String, Object> colNameValue = new Hashtable<>();
			colNameValue.put(arrSQLTerms[i]._strColumnName, arrSQLTerms[i]._objValue);
			String operator = arrSQLTerms[i]._strOperator;
			Table table = Serializer.deserializeTable(arrSQLTerms[i]._strTableName);
			result.add(table.select(colNameValue, operator));
		}

		return applyArrOperators(result, strarrOperators);
	}

	private Iterator applyArrOperators(Vector<Vector<Tuple>> selections, String[] strarrOperators) {

		Vector<Tuple> result = new Vector<>();
		Vector<Vector<Tuple>> tmp = new Vector<>();
		int idx = 0;

		for (Vector<Tuple> tuplesVector : selections) {
			tmp.add(tuplesVector);
			if (tmp.size() == 2) {
				Vector<Tuple> firstSet = tmp.remove(0);
				Vector<Tuple> secondSet = tmp.remove(0);
				tmp.add(Selector.selectOperation(firstSet, secondSet, strarrOperators[idx++]));
			}
		}
		result = tmp.remove(0);

		return result.iterator();
	}

	@Override
	public void createIndex(String strTableName, String[] strarrColName) throws DBAppException {
		Validator.validateTable(strTableName, myTables);
		Table table = Serializer.deserializeTable(strTableName);
		Validator.validateCreatIndex(table, strarrColName);
		OctreeBounds bounds = createBounds(strarrColName);
		OctreeIndex index = new OctreeIndex (bounds, strarrColName[0], strarrColName[1], strarrColName[2]);
		table.getIndices().add(index);
		if (!table.isEmpty()) {
			insertExisitngTuples(strTableName, index, table);
		}
		String indexName = strarrColName[0]+ strarrColName[1]+ strarrColName[2] + "Index";
		updateCsvFile(strTableName, indexName);
	}

	public Iterator parseSQL(StringBuffer strbufSQL) throws
			DBAppException {
		SQLParser parser = new SQLParser(this);
		Iterator result = parser.parse(strbufSQL);
		return result;
	}
}
	
	private void updateCsvFile(String strTableName, String indexName) {
		CsvReader cr = new CsvReader();
		String tablename = strTableName;
		List<String[]> tableInfo = cr.readAll();
		int size = tableInfo.size();
		for (int i = 0; i < size; i++) {
			if (tableInfo.get(i)[0].equals(strTableName)) {
				tableInfo.get(i)[Constants.INDEX_NAME_INDEX] = indexName;
				tableInfo.get(i)[Constants.INDEX_TYPE_INDEX] = "Octree";
			}
		}
		CsvWriter cw = new CsvWriter();
		try {
			cw.writeAll(tableInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void insertExisitngTuples(String strTableName, OctreeIndex index, Table table) throws DBAppException {
		int numOfPages = table.getPagesName().size();
		for (int i=0; i<numOfPages; i++) {
			Page page = table.getPageAtPosition(i); 
			Vector<Tuple> tuples = page.getTuples();
			for (Tuple tuple : tuples) {
				index.add(page, tuple);
			}
		}
	}
	
	private OctreeBounds createBounds (String[] strarrColName) {
		return new OctreeBounds (0, 0, 0,
				1, 1, 1);
	}
	

}