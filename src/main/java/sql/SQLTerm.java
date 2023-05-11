//CHECKSTYLE:OFF: MemberName

package sql;

public class SQLTerm{
String _strTableName, _strColumnName, _strOperator;
Object _objValue;

    public SQLTerm(String strTableName, String strColumnName, String strOperator, Object objValue) {
        this._strTableName = strTableName;
        this._strColumnName = strColumnName;
        this._strOperator = strOperator;
        this._objValue = objValue;
    }
    
}
//CHECKSTYLE:ON: MemberName