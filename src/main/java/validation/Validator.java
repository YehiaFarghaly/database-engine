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
    
    public static boolean validTuple(Table table,Hashtable<String,Object> tuple) throws CsvValidationException, IOException {
    	csvReader cr = new csvReader();
    	String tablename = table.getName();
    	String [] columns = cr.read(tablename).get(0);
    	String [] datatypes = cr.read(tablename).get(1);
    	String [] pk = cr.read(tablename).get(2);
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
    	if(table.search(columns[pk_index],(String) tuple.get(columns[pk_index]))!=null) return false;
    	return true;
    	
    }

}