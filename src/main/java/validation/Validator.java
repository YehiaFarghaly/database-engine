package validation;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Hashtable;

import com.opencsv.exceptions.CsvValidationException;
import datamanipulation.CsvReader;
import exceptions.DBAppException;
import search.Compare;
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
    
    public static boolean foundPK(Table table,Hashtable<String,Object> tuple) throws ClassNotFoundException, DBAppException, ParseException, IOException {
    	int pkIndex = findRowPK();
    	Tuple t = table.createTuple(tuple);
    	if(table.tableBinarySearch(t.getPrimaryKey())==-1) return false;
    	return true;
    }
    
    private static void getTableInfo(Table table) {
    	CsvReader cr = new CsvReader();
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
    
    public static boolean validTuple(Table table,Hashtable<String,Object> tuple) throws CsvValidationException, IOException, ClassNotFoundException, DBAppException, ParseException {
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
    
    public static boolean validTupleUpdate(Table table,Hashtable<String,Object> tuple) throws CsvValidationException, IOException, ClassNotFoundException, DBAppException, ParseException {
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
    		
    		Object insertedValue = tuple.get(columns[i]);
    		Object minValue = min[i];
    		Object maxValue = max[i];
    		
    		if((isFirstLessThanSecond(insertedValue, minValue))  ||
    			(isFirstGreaterThanSecond(insertedValue,maxValue))) {
    			return false;
    		}
    	}
    	return true;
    }
    
    private static boolean isFirstLessThanSecond(Object comp1, Object comp2) {
    	return Compare.compare(comp1, comp2)<0;
    }
    
    private static boolean isFirstGreaterThanSecond(Object comp1, Object comp2) {
    	return Compare.compare(comp1, comp2)>0;
    }

}