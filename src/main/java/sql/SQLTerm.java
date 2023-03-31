package sql;
import validation.*;
public class SQLTerm{
String _strTableName, _strColumnName ,_strOperator;
Object _objValue;

    public SQLTerm(String _strTableName, String _strColumnName, String _strOperator, Object _objValue) {
        this._strTableName = _strTableName;
        this._strColumnName = _strColumnName;
        this._strOperator = _strOperator;
        this._objValue = _objValue;
    }
    public boolean isValid(){
        return Validator.validateOperatorInside(this);
    }
}