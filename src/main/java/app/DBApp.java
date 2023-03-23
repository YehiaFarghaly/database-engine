package app;

import java.util.Hashtable;
import java.util.Iterator;

import exceptions.DBAppException;
import storage.*;
import validation.Validator;
import search.*;
import sql.SQLTerm;
import constants.Constants;

public class DBApp implements IDatabase {

	private Hashtable<String, Table> myTables;// contains table names and the corresponding table;

	public DBApp() {
		this.myTables = new Hashtable<>();
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
	public void deleteFromTable(String strTableName, Hashtable<String, Object> htblColNameValue) throws DBAppException {
		// TODO Auto-generated method stub

	}

	public Iterator selectFromTable(SQLTerm[] arrSQLTerms, String[] strarrOperators) throws DBAppException {
		return new Selector(arrSQLTerms, strarrOperators).getResult();
	}

	public static void main(String[] args) {
		DBApp engine = new DBApp();
		engine.init();

	}

}
