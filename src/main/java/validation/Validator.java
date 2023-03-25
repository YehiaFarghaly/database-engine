package validation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import com.opencsv.exceptions.CsvValidationException;

import app.DBApp;
import dataManipulation.csvReader;
import search.TableSearch;
import sql.SQLTerm;
import storage.Table;

public class Validator {

    public static boolean validateOperatorInside(SQLTerm term) {
        return false;
    }


    public static boolean validateOperatorBetween(String operator) {
        return false;
    }
    
    public static boolean validTable(String tableName,Hashtable<String, Table> myTables) {
    	if(myTables.containsKey(tableName)) {
    		return true;
    	}
    	return false;
    }
    public static int findRowPK(String [] columns,String[] pk) {
    	for(int i=0;i<columns.length;i++) {
    		if(pk[i]=="TRUE") return i;
    		
    	}
    	return -1;
    }
    public static boolean isTheSameNumberOfColumns(Hashtable<String,Object> tuple,String [] columns){
    	if(tuple.size()!=columns.length) {
    		return false;
    	}
    	return true;
    }
    public static boolean containsAllColumns(Hashtable<String,Object> tuple,String [] columns){
    	for(int i=0;i<columns.length;i++) {
    		if(!tuple.containsKey(columns[i])) {
    			return false;}
    	}
    	return true;
    }
    public static boolean isTheSameDataType(Hashtable<String,Object> tuple,String [] columns,String [] dataTypes){
    	for(int i=0;i<columns.length;i++) {
    			if(!tuple.get(columns[i]).getClass().equals(dataTypes[i]))	return false;

    	}
    	return true;
    }
    public static boolean foundPK(Table table,String[] columns,String []pk,Hashtable<String,Object> tuple) {
    	int pkIndex = findRowPK(columns,pk);
    	if(table.search(columns[pkIndex],(String) tuple.get(columns[pkIndex]))!=null) return false;
    	return true;
    }
    
    public static boolean validTuple(Table table,Hashtable<String,Object> tuple) throws CsvValidationException, IOException {
    	csvReader cr = new csvReader();
    	String tablename = table.getName();
    	ArrayList<String[]> tableInfo = cr.readTable(tablename);
    	
    	String [] columns = tableInfo.get(0);
    	String [] dataTypes = tableInfo.get(1);
    	String [] pk = tableInfo.get(2);
    	
    	if( !isTheSameNumberOfColumns(tuple,columns) ||
    		!containsAllColumns(tuple,columns)       ||
    	    !isTheSameDataType(tuple,columns,dataTypes) ||
    	    !foundPK(table,columns,pk,tuple)) {
    		return false;
    		}
    	else {
    		return true;
    	}
    	
    }

}