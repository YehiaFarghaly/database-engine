package validation;

import java.io.IOException;
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
    public static int findrowpk(String [] columns,String[] pk) {
    	for(int i=0;i<columns.length;i++) {
    		if(pk[i]=="TRUE") return i;
    		
    	}
    	return -1;
    }
    
    public static boolean validTuple(String tableName,Hashtable<String,Object> tuple) {
    	String [] columns = csvReader.read(tableName).get(0);
    	String [] datatypes = csvReader.read(tableName).get(1);
    	String [] pk = csvReader.read(tableName).get(2);
    	if(tuple.size()!=columns.length) {
    		return false;
    	}
    	for(int i=0;i<columns.length;i++) {
    		if(!tuple.containsKey(columns[i])) {
    			return false;}
    		else {
    			if(!tuple.get(columns[i]).getClass().equals(datatypes[i]))	return false;
    		}
    	}
    	int pk_index = findrowpk(columns,pk);
    	if(TableSearch.search(tuple.get(columns[pk_index])))
    	return true;
    	
    }

}