//CHECKSTYLE:OFF: MemberName

package sql;

public class SQLTerm {
	public String _strTableName;
	public String _strColumnName;
	public String _strOperator;
	public Object _objValue;

	public SQLTerm(String strTableName, String strColumnName, String strOperator, Object objValue) {
		this._strTableName = strTableName;
		this._strColumnName = strColumnName;
		this._strOperator = strOperator;
		this._objValue = objValue;
	}

	@Override
	public String toString() {
		return "SQLTerm{" +
				"_strTableName='" + _strTableName + '\'' +
				", _strColumnName='" + _strColumnName + '\'' +
				", _strOperator='" + _strOperator + '\'' +
				", _objValue=" + _objValue +" "+ _objValue.getClass() +
				'}';
	}
}
//CHECKSTYLE:ON: MemberName