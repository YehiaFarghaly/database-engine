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
import storage.Tuple;

public class Validator {
	
	private static String [] columns;
	private static String [] dataTypes;
	private static String [] pk;
	private static Object [] min;
	private static Object [] max;
	
	
	

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
    
    public static int findRowPK() {
    	for(int i=0;i<columns.length;i++) {
    		if(pk[i]=="TRUE") return i;
    		
    	}
    	return -1;
    }
    
    public static boolean isTheSameNumberOfColumns(Hashtable<String,Object> tuple){
    	if(tuple.size()!=columns.length) {
    		return false;
    	}
    	return true;
    }
    
    public static boolean containsAllColumns(Hashtable<String,Object> tuple){
    	for(int i=0;i<columns.length;i++) {
    		if(!tuple.containsKey(columns[i])) {
    			return false;}
    	}
    	return true;
    }
    
    public static boolean isTheSameDataType(Hashtable<String,Object> tuple){
    	for(int i=0;i<columns.length;i++) {
    			if(!tuple.get(columns[i]).getClass().equals(dataTypes[i]))	return false;
    	}
    	return true;
    }
    
    public static boolean isTheSameDataTypeUpdate(Hashtable<String,Object> tuple){
    	int pkIndex = findRowPK();
    	for(int i=0;i<columns.length&&i!=pkIndex;i++) {
    			if(!tuple.get(columns[i]).getClass().toString().endsWith(dataTypes[i]))	return false;
    	}
    	return true;
    }
    
    public static boolean foundPK(Table table,Hashtable<String,Object> tuple) {
    	int pkIndex = findRowPK();
    	Tuple t = table.createTuple(tuple);
//    	if(table.search(t)==-1) return false;
    	return true;
    }
    
    private static void getTableInfo(Table table) {
    	csvReader cr = new csvReader();
		String tablename = table.getName();
		ArrayList<String[]> tableInfo = cr.readTable(tablename);
		int size = tableInfo.size();
		columns = new String[size];
		dataTypes = new String[size];
		pk = new String[size];
		for (int i = 0; i < size; i++) {
			columns[i] = tableInfo.get(i)[1];
			dataTypes[i] = tableInfo.get(i)[2];
			pk[i] = tableInfo.get(i)[3];
			min[i] = tableInfo.get(i)[6];
			max[i] = tableInfo.get(i)[7];
		}

    }
    
    public static boolean validTuple(Table table,Hashtable<String,Object> tuple) throws CsvValidationException, IOException {
    	getTableInfo(table);
    	if( !isTheSameNumberOfColumns(tuple) ||
    		!containsAllColumns(tuple)       ||
    	    !isTheSameDataType(tuple) ||
    	    !checkMinMax(tuple)||
    	    foundPK(table,tuple)) {
    		return false;
    		}
    	else {
    		return true;
    	}
    	
    }
    
    public static boolean containsAllColumnsUpdate(Hashtable<String,Object> tuple){
    	int pkIndex = findRowPK();
    	for(int i=0;i<columns.length&&i!=pkIndex;i++) {
    		if(!tuple.containsKey(columns[i])) {
    			return false;}
    	}
    	return true;
    }
    
    public static boolean validTupleUpdate(Table table,Hashtable<String,Object> tuple) throws CsvValidationException, IOException {
    	getTableInfo(table);
    	if( !isTheSameDataTypeUpdate(tuple) ||!foundPK(table,tuple)||!checkMinMax(tuple)) {
    		return false;
    		}
    	else {
    		return true;
    	}
    	
    }
    
    public static boolean checkMinMax(Hashtable<String,Object> tuple) {
    	for(int i=0;i<columns.length;i++) {
    		
    		Comparable insertedValue = (Comparable)tuple.get(columns[i]);
    		Comparable minValue = (Comparable)(min[i]);
    		Comparable maxValue = (Comparable)(max[i]);
    		
    		if(((insertedValue).compareTo(minValue)<0)  ||
    			((insertedValue).compareTo(maxValue)>0)) {
    			return false;
    		}
    	}
    	return true;
    }

}