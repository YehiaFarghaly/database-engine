package app;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import com.opencsv.exceptions.CsvValidationException;

import exceptions.DBAppException;
import filecontroller.Serializer;
import storage.*;
import validation.Validator;
import search.*;
import sql.SQLTerm;
import constants.Constants;
import datamanipulation.CsvReader;
import datamanipulation.CsvWriter;

public class DBApp implements IDatabase {

	private Hashtable<String, Table> myTables;// contains table names and the corresponding table;
	private CsvReader reader;
	private CsvWriter writer;
	private Object clusteringKey;

	public DBApp() throws IOException {
		this.myTables = new Hashtable<>();
		this.writer = new CsvWriter();
		this.reader = new CsvReader();
	}

	public Hashtable<String, Table> getMyTables() {
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
		this.myTables = reader.readAll(); // to read all tables in the metadata file
	}

	@Override
	public void createTable(String strTableName, String strClusteringKeyColumn,
			Hashtable<String, String> htblColNameType, Hashtable<String, String> htblColNameMin,
			Hashtable<String, String> htblColNameMax) throws DBAppException, IOException {

		Table table = new Table(strTableName, strClusteringKeyColumn, htblColNameType, htblColNameMin, htblColNameMax);
		myTables.put(strTableName, table);
		writer.write(table);
		table.createTableFiles();
	}

	@Override
	public void insertIntoTable(String strTableName, Hashtable<String, Object> htblColNameValue)
			throws DBAppException, CsvValidationException, IOException, ClassNotFoundException, ParseException {

		takeAction(Action.INSERT, strTableName, htblColNameValue);

	}

	@Override
	public void updateTable(String strTableName, String strClusteringKeyValue,
			Hashtable<String, Object> htblColNameValue)
			throws DBAppException, CsvValidationException, IOException, ClassNotFoundException, ParseException {
		this.clusteringKey = (Object) strClusteringKeyValue;
		takeAction(Action.UPDATE, strTableName, htblColNameValue);
	}

	@Override
	public void deleteFromTable(String strTableName, Hashtable<String, Object> htblColNameValue)
			throws DBAppException, CsvValidationException, IOException, ClassNotFoundException, ParseException {
		takeAction(Action.DELETE, strTableName, htblColNameValue);
	}

	private void takeAction(Action action, String strTableName, Hashtable<String, Object> htblColNameValue)
			throws DBAppException, CsvValidationException, IOException, ClassNotFoundException, ParseException {
		boolean validTable = Validator.validTable(strTableName, myTables);

		if (!validTable) {

			throw new DBAppException(Constants.ERROR_MESSAGE_TABLE_NAME);

		} else {

			boolean validTuple = Validator.validTuple(myTables.get(strTableName), htblColNameValue);

			if (!validTuple) {
				throw new DBAppException(Constants.ERROR_MESSAGE_TUPLE_DATA);

			} else {

				Table table = Serializer.deserializeTable(strTableName);

				if (action == Action.INSERT)
					table.insertTuple(htblColNameValue);
				else if (action == Action.DELETE)
					table.DeleteTuples(htblColNameValue);
				else
					table.updateRecordsInTaple(clusteringKey, htblColNameValue);

				Serializer.SerializeTable(table);
			}
		}
	}

	public Iterator selectFromTable(SQLTerm[] arrSQLTerms, String[] strarrOperators) throws DBAppException {
		return new Selector(arrSQLTerms, strarrOperators).getResult();
	}

}
