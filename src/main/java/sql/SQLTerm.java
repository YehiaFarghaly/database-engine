package sql;

public class SQLTerm{
String strTableName, strColumnName, strOperator;
Object objValue;

    public SQLTerm(String strTableName, String strColumnName, String strOperator, Object objValue) {
        this.strTableName = strTableName;
        this.strColumnName = strColumnName;
        this.strOperator = strOperator;
        this.objValue = objValue;
    }
    
    public boolean isValid(){
        return false;
    }
}