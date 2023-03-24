package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;

import com.opencsv.exceptions.CsvValidationException;

import dataManipulation.csvReader;
import dataManipulation.csvWriter;
import exceptions.DBAppException;
import storage.*;
import validation.Validator;
import search.*;
import sql.SQLTerm;
import constants.Constants;

public class DBApp implements IDatabase {

	private Hashtable<String, Table> myTables;// contains table names and the corresponding table;
	private csvReader reader;
	private csvWriter writer;

	public DBApp() throws IOException {
		this.myTables = new Hashtable<>();
		writer = new csvWriter();
		reader = new csvReader();
	}

	public static void main(String[] args) throws IOException {

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void createTable(String strTableName, String strClusteringKeyColumn,
			Hashtable<String, String> htblColNameType, Hashtable<String, String> htblColNameMin,
			Hashtable<String, String> htblColNameMax) throws DBAppException {

		Table table = new Table(strTableName, strClusteringKeyColumn, htblColNameType, htblColNameMin, htblColNameMax);
		myTables.put(strTableName, table);
		writer.write(table);

	}

	@Override
	public void insertIntoTable(String strTableName, Hashtable<String, Object> htblColNameValue) throws DBAppException {
		// TODO Auto-generated method stub
		boolean validTable = Validator.validTable(strTableName,myTables);
		boolean validTuple = Validator.validTuple(strTableName,htblColNameValue);
		if (!validTable) {

			System.out.println(Constants.ERROR_MESSAGE_TABLE_NAME);

		} else if (!validTuple) {
			
			System.out.println(Constants.ERROR_MESSAGE_TUPLE_DATA);
			
		} else {
			
             
		}

	}

	@Override
	public void updateTable(String strTableName, String strClusteringKeyValue,
			Hashtable<String, Object> htblColNameValue) throws DBAppException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFromTable(String strTableName, Hashtable<String, Object> htblColNameValue) throws DBAppException {
		// TODO Auto-generated method stub

	}

	public Iterator selectFromTable(SQLTerm[] arrSQLTerms, String[] strarrOperators) throws DBAppException {
		return new Selector(arrSQLTerms, strarrOperators).getResult();
	}
}
