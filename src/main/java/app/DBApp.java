package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Vector;

import Serializerium.Serializer;
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
		this.writer = new csvWriter();
		this.reader = new csvReader();
	}

	@Override
	public void init() {
		this.myTables = reader.readAll(); // to read all tables in the metadata file
	}

	@Override
	public void createTable(String strTableName, String strClusteringKeyColumn,
			Hashtable<String, String> htblColNameType, Hashtable<String, String> htblColNameMin,
			Hashtable<String, String> htblColNameMax) throws DBAppException {

		Table table = new Table(strTableName, strClusteringKeyColumn, htblColNameType, htblColNameMin, htblColNameMax);
		getMyTables().put(strTableName, table);
		getWriter().write(table);
	}

	@Override
	public void insertIntoTable(String strTableName, Hashtable<String, Object> htblColNameValue)
			throws DBAppException, CsvValidationException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		boolean validTable = Validator.validTable(strTableName, myTables);

		if (!validTable) {

			throw new DBAppException(Constants.ERROR_MESSAGE_TABLE_NAME);

		} else {

			boolean validTuple = Validator.validTuple(myTables.get(strTableName), htblColNameValue);
			
			if (!validTuple) {
				throw new DBAppException(Constants.ERROR_MESSAGE_TUPLE_DATA);

			} else {

				Table table = Serializer.deserializeTable(strTableName);
				table.insertTuple(htblColNameValue);

				Serializer.SerializeTable(table);
			}
		}

	}

	@Override
	public void updateTable(String strTableName, String strClusteringKeyValue,
			Hashtable<String, Object> htblColNameValue) throws DBAppException, CsvValidationException, IOException, ClassNotFoundException {
		boolean validTable = Validator.validTable(strTableName,myTables);
		
		if (!validTable) {

			System.out.println(Constants.ERROR_MESSAGE_TABLE_NAME);

		} else {
			boolean validTupleUpdate = Validator.validTupleUpdate(myTables.get(strTableName),htblColNameValue);
			if (!validTupleUpdate) {
				
				System.out.println(Constants.ERROR_MESSAGE_TUPLE_DATA);
			}else {
				
				Table table = Serializer.deserializeTable(strTableName);
				upadteTuple(table,strClusteringKeyValue,htblColNameValue);
				Serializer.SerializeTable(table);

			}

		}
			

	}

	@Override
	public void deleteFromTable(String strTableName, Hashtable<String, Object> htblColNameValue) throws DBAppException, CsvValidationException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		boolean validTable = Validator.validTable(strTableName, myTables);

		if (!validTable) {

			System.out.println(Constants.ERROR_MESSAGE_TABLE_NAME);

		} else {

			boolean validTuple = Validator.validTuple(myTables.get(strTableName), htblColNameValue);
			
			if (!validTuple) {
				System.out.println(Constants.ERROR_MESSAGE_TUPLE_DATA);

			} else {

				Table table = Serializer.deserializeTable(strTableName);
				table.DeleteTuples(htblColNameValue);
				Serializer.SerializeTable(table);
			}
		}

				
			 
			
		
		
	}
			
			
		


	public Iterator selectFromTable(SQLTerm[] arrSQLTerms, String[] strarrOperators) throws DBAppException {
		return new Selector(arrSQLTerms, strarrOperators).getResult();
	}

	public Hashtable<String, Table> getMyTables() {
		return myTables;
	}

	public csvReader getReader() {
		return reader;
	}

	public csvWriter getWriter() {
		return writer;
	}
	
	public static Page getPageToUpdate(String strClusteringKeyValue,Table table,Tuple tuple) throws ClassNotFoundException, IOException {
		tuple.setPrimaryKey(strClusteringKeyValue);
		int pkPagePosition = 0; // table.search(tuple);
		return table.getPageAtPosition(pkPagePosition);
	}
	public static Tuple getTupleToUpdate(Tuple tuple,Page page) {
		int pkVectorPoition = page.search(tuple);
		return page.getTuples().get(pkVectorPoition);

	}
	public static void upadteTuple(Table table,String strClusteringKeyValue,Hashtable<String, Object> htblColNameValue) throws ClassNotFoundException, IOException {
		Tuple tuple = new Tuple(); 
		Page page = getPageToUpdate(strClusteringKeyValue, table, tuple);
		tuple = getTupleToUpdate(tuple, page);
		for (Cell c : tuple.getCells()) {
			c.setValue(htblColNameValue.get(c.getKey()));    
		}
	}
}
