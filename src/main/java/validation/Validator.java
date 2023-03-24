package validation;

import java.util.Hashtable;

import app.DBApp;
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
    
    public static boolean validTuple(Hashtable<String,Object> tuple) {
    	return false;
    }

}