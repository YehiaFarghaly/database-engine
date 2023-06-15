package app;

import datamanipulation.CsvReader;
import datamanipulation.CsvWriter;
import exceptions.DBAppException;
import sql.SQLTerm;
import sql.parser.SQLParser;
import storage.Page;
import storage.Table;
import storage.Tuple;
import storage.index.OctreeIndex;
import util.TypeParser;
import util.filecontroller.Serializer;
import util.search.Selector;
import util.validation.Validator;
import java.util.*;

public class DBApp implements IDatabase {

	private HashSet<String> myTables;
	private final CsvReader reader;
	private final CsvWriter writer;
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

	@Override
	public void init() {

		this.myTables = reader.readAllTables();

	}

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

	@Override
	public void insertIntoTable(String strTableName, Hashtable<String, Object> htblColNameValue) throws DBAppException {

		takeAction(Action.INSERT, strTableName, htblColNameValue);

	}

	@Override
	public void updateTable(String strTableName, String strClusteringKeyValue,
							Hashtable<String, Object> htblColNameValue) throws DBAppException {

		this.clusteringKeyValue = strClusteringKeyValue;
		takeAction(Action.UPDATE, strTableName, htblColNameValue);
	}

	@Override
	public void deleteFromTable(String strTableName, Hashtable<String, Object> htblColNameValue) throws DBAppException {

		takeAction(Action.DELETE, strTableName, htblColNameValue);
	}

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
		if (strarrOperators.length < 2) {
			return Selector.selectWithNoIndex(arrSQLTerms, strarrOperators).iterator();
		}
		return Selector.selectWithMoreThanTwoOperators(arrSQLTerms, strarrOperators);
	}

	@Override
	public void createIndex(String strTableName, String[] strarrColName) throws DBAppException {
		Validator.validateTable(strTableName, myTables);
		Table table = Serializer.deserializeTable(strTableName);
		Validator.validateCreatIndex(table, strarrColName);
		OctreeIndex index = new OctreeIndex(strTableName, strarrColName[0], strarrColName[1], strarrColName[2]);
		table.getIndices().add(index);
		insertExisitngTuples(index, table);
		updateCsvFile(strTableName, index.getName(), strarrColName);
		Serializer.serializeTable(table);
	}

	private void updateCsvFile(String strTableName, String indexName, String[] strarrColName) throws DBAppException {
		CsvWriter cw = new CsvWriter();
		cw.updateCsvFile(strTableName, indexName, strarrColName);
	}


	private void insertExisitngTuples(OctreeIndex index, Table table) throws DBAppException {
		int numOfPages = table.getPagesName().size();
		for (int i = 0; i < numOfPages; i++) {
			Page page = table.getPageAtPosition(i);
			Vector<Tuple> tuples = page.getTuples();
			for (Tuple tuple : tuples) {
				index.add(page, tuple);
			}
		}
	}

	public Iterator parseSQL(StringBuffer strbufSQL) throws DBAppException {
		SQLParser parser = new SQLParser(this);
		Iterator result = parser.parse(strbufSQL);
		return result;
	}

}