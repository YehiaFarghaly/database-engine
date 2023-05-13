package app;


import java.util.*;
import exceptions.DBAppException;
import sql.SQLTerm;

public interface IDatabase {

	public void init();

	public void createTable(String strTableName, String strClusteringKeyColumn,
			Hashtable<String, String> htblColNameType, Hashtable<String, String> htblColNameMin,
			Hashtable<String, String> htblColNameMax) throws DBAppException;

	public void createIndex(String strTableName, String[] strarrColName) throws DBAppException;

	public void insertIntoTable(String strTableName, Hashtable<String, Object> htblColNameValue) throws DBAppException;

	public void updateTable(String strTableName, String strClusteringKeyValue,
			Hashtable<String, Object> htblColNameValue) throws DBAppException;

	public void deleteFromTable(String strTableName, Hashtable<String, Object> htblColNameValue) throws DBAppException;

	public Iterator selectFromTable(SQLTerm[] arrSQLTerms, String[] strarrOperators) throws DBAppException;
	
}
