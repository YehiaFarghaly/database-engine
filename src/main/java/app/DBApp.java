package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

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
		boolean validTable = Validator.validTable(strTableName);
		boolean validTuple = Validator.validTuple(htblColNameValue);
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
	public void deleteFromTable(String strTableName, Hashtable<String, Object> htblColNameValue) throws DBAppException, CsvValidationException, IOException {
		// TODO Auto-generated method stub
		boolean validTable = Validator.validTable(strTableName);
		boolean validTuple = Validator.validTuple(htblColNameValue);
		if (!validTable) {

			System.out.println(Constants.ERROR_MESSAGE_TABLE_NAME);

		} else if (!validTuple) {
			
			System.out.println(Constants.ERROR_MESSAGE_TUPLE_DATA);
			
		} else {
				String colname = null;
				Object colval = null;
				int colnumber = 0;
				Boolean Easyserach = null; // null when != index or PK, False when = index, True when = PK
				ArrayList<String[]> TableMetaData = reader.read(strTableName);
				
				for(String i : htblColNameValue.keySet())
				{
					colname = i;
					colval = htblColNameValue.get(i);
					break;
				}
				
				for(String[] i : TableMetaData)
				{
					if(i[1].equals(colname))
					{
						if(i[3].equals("True"))
							Easyserach = true;
						else if(!i[3].equals("null"))
						{
							// TODO for index
						} 
						break;
					}
				}
				
			 
			
		}
			
			
		

	}

	public Iterator selectFromTable(SQLTerm[] arrSQLTerms, String[] strarrOperators) throws DBAppException {
		return new Selector(arrSQLTerms, strarrOperators).getResult();
	}
}
