package app;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import com.opencsv.exceptions.CsvValidationException;

import exceptions.DBAppException;
import sql.SQLTerm;

public interface IDatabase {

	public void init();

	public void createTable(String strTableName, String strClusteringKeyColumn,
			Hashtable<String, String> htblColNameType, Hashtable<String, String> htblColNameMin,
			Hashtable<String, String> htblColNameMax) throws DBAppException, IOException;

//	public void createIndex(String strTableName, String[] strarrColName) throws DBAppException;

	public void insertIntoTable(String strTableName, Hashtable<String, Object> htblColNameValue) throws DBAppException, IOException, CsvValidationException, ClassNotFoundException, ParseException;

	public void updateTable(String strTableName, String strClusteringKeyValue,
			Hashtable<String, Object> htblColNameValue) throws DBAppException, CsvValidationException, IOException, ClassNotFoundException, ParseException;

	public void deleteFromTable(String strTableName, Hashtable<String, Object> htblColNameValue) throws  DBAppException, CsvValidationException, IOException, ClassNotFoundException, ParseException;

	public Iterator selectFromTable(SQLTerm[] arrSQLTerms, String[] strarrOperators) throws DBAppException;
	
}
