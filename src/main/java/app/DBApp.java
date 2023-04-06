package app;

import java.io.IOException;
import java.text.ParseException;
import java.util.Hashtable;
import java.util.Iterator;

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

/**
 * The DBApp class represents a database management system. It implements the IDatabase interface and provides methods
 * for initializing the system, creating tables, creating indices, inserting, updating and deleting records, and selecting records using
 * SQL terms.
 */
public class DBApp implements IDatabase {

	private Hashtable<String, Table> myTables;
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

	 /**
     * Initializes the database management system by reading all the tables from their CSV files.
     */
	@Override
	public void init() {
		this.myTables = reader.readAll();
	}

    /**
     * Creates a new table in the system with the specified parameters.
     * 
     * @param strTableName          The name of the table.
     * @param strClusteringKeyColumn The name of the clustering key column.
     * @param htblColNameType       A Hashtable containing the name and data type of each column in the table.
     * @param htblColNameMin        A Hashtable containing the name and minimum value of each column in the table.
     * @param htblColNameMax        A Hashtable containing the name and maximum value of each column in the table.
     * 
     * @throws DBAppException If the table name is invalid or if the table already exists.
     * @throws IOException    If an error occurs while creating the table files.
     */
	@Override
	public void createTable(String strTableName, String strClusteringKeyColumn,
			Hashtable<String, String> htblColNameType, Hashtable<String, String> htblColNameMin,
			Hashtable<String, String> htblColNameMax) throws DBAppException, IOException {

		Table table = new Table(strTableName, strClusteringKeyColumn, htblColNameType, htblColNameMin, htblColNameMax);
		myTables.put(strTableName, table);
		writer.write(table);
		table.createTableFiles();
	}
	
	   /**
     * Inserts a new record into the specified table.
     * 
     * @param strTableName    The name of the table.
     * @param htblColNameValue A Hashtable containing the name and value of each column in the record.
     * 
     * @throws DBAppException         If the table name is invalid, the record data is invalid or the record already exists.
     * @throws CsvValidationException If the record fails CSV validation.
     * @throws IOException            If an error occurs while inserting the record.
     * @throws ClassNotFoundException If an error occurs while serializing or deserializing the table.
     * @throws ParseException         If an error occurs while parsing the record data.
     */
	@Override
	public void insertIntoTable(String strTableName, Hashtable<String, Object> htblColNameValue)
			throws DBAppException, CsvValidationException, IOException, ClassNotFoundException, ParseException {

		takeAction(Action.INSERT, strTableName, htblColNameValue);

	}
	
	/**
	 * Updates a record in a table.
	 * 
	 * @param strTableName the name of the table to update a record in.
	 * @param strClusteringKeyValue the value of the clustering key for the record to be updated.
	 * @param htblColNameValue the new values for the record.
	 * 
	 * @throws DBAppException if there is an error with the database operations.
	 * @throws CsvValidationException if there is an error with the CSV file.
	 * @throws IOException if there is an error with file operations.
	 * @throws ClassNotFoundException if there is an error with the serialization.
	 * @throws ParseException if there is an error parsing the input.
	 */
	@Override
	public void updateTable(String strTableName, String strClusteringKeyValue,
			Hashtable<String, Object> htblColNameValue)
			throws DBAppException, CsvValidationException, IOException, ClassNotFoundException, ParseException {
		this.clusteringKey = (Object) strClusteringKeyValue;
		takeAction(Action.UPDATE, strTableName, htblColNameValue);
	}
	
	/**
	 * Deletes records from a table.
	 * 
	 * @param strTableName the name of the table to delete records from.
	 * @param htblColNameValue the values to match records to be deleted.
	 * 
	 * @throws DBAppException if there is an error with the database operations.
	 * @throws CsvValidationException if there is an error with the CSV file.
	 * @throws IOException if there is an error with file operations.
	 * @throws ClassNotFoundException if there is an error with the serialization.
	 * @throws ParseException if there is an error parsing the input.
	 */
	@Override
	public void deleteFromTable(String strTableName, Hashtable<String, Object> htblColNameValue)
			throws DBAppException, CsvValidationException, IOException, ClassNotFoundException, ParseException {
		takeAction(Action.DELETE, strTableName, htblColNameValue);
	}
	
	/**
	 * Performs an action (insert, delete, or update) on a table.
	 * 
	 * @param action the action to perform.
	 * @param strTableName the name of the table to perform the action on.
	 * @param htblColNameValue the values to use for the action.
	 * 
	 * @throws DBAppException if there is an error with the database operations.
	 * @throws CsvValidationException if there is an error with the CSV file.
	 * @throws IOException if there is an error with file operations.
	 * @throws ClassNotFoundException if there is an error with the serialization.
	 * @throws ParseException if there is an error parsing the input.
	 */
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
