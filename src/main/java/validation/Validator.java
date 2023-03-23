package validation;

import java.util.Hashtable;

import sql.SQLTerm;

public class Validator {

    public static boolean validateOperatorInside(SQLTerm term) {
        return false;
    }

    public static boolean validateOperatorBetween(String operator) {
        return false;
    }
    
    public static boolean validTable(String tableName) {
    	return false;
    }
    
    public static boolean validTuple(Hashtable<String,Object> tuple) {
    	return false;
    }

}