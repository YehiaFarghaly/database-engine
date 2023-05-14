package app;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import com.opencsv.exceptions.CsvValidationException;
import exceptions.DBAppException;
import storage.index.OctreeBounds;
import storage.index.OctreeIndex;
import util.filecontroller.Serializer;
import util.search.Selector;
import storage.*;
import util.TypeParser;
import sql.SQLTerm;
import datamanipulation.CsvReader;
import datamanipulation.CsvWriter;
import util.validation.Validator;

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

	// TODO : add the method body
	@Override
	public void createIndex(String strTableName, String[] strarrColName) throws DBAppException {

	}

	public static void main(String[] args) throws DBAppException {
//		DBApp m = new DBApp();
//		m.init();
//		Table table = Serializer.deserializeTable("malek");
//		OctreeBounds searchBounds = new OctreeBounds("cesn2","602","game","cesn2","602","game");
//		System.out.println(table.getIndices().get(0));
//		Hashtable<String, Object> htblColNameType = new Hashtable<>();
//		htblColNameType.put("id", "2000");
//		htblColNameType.put("courseName", "cesn2");
//		htblColNameType.put("courseid", "602");
//		htblColNameType.put("coursenick", "game");
//		m.insertIntoTable("malek", htblColNameType);
//		OctreeBounds in = new OctreeBounds("","","","zzzz","zzzz","zzzz");
//		table.getIndices().add(new OctreeIndex<>(in, "courseName", "courseid", "coursenick"));
//		Hashtable<String, String> htblColNameType = new Hashtable<>();
//		htblColNameType.put("id", "java.lang.String");
//		htblColNameType.put("courseName", "java.lang.String");
//		htblColNameType.put("courseid", "java.lang.String");
//		htblColNameType.put("coursenick", "java.lang.String");
//
//		Hashtable<String, String> htblColNameMin = new Hashtable<>();
//		htblColNameMin.put("id", "0000");
//		htblColNameMin.put("courseName", "");
//		htblColNameMin.put("courseid", "");
//		htblColNameMin.put("coursenick", "");
//
//		Hashtable<String, String> htblColNameMax = new Hashtable<>();
//		htblColNameMax.put("id", "9999");
//		htblColNameMax.put("courseName", "zzzz");
//		htblColNameMax.put("courseid", "zzzz");
//		htblColNameMax.put("coursenick", "zzzz");
//		m.createTable("malek", "id", htblColNameType, htblColNameMin, htblColNameMax);
	}
}
