package util.search;

import constants.Constants;
import exceptions.DBAppException;
import sql.SQLTerm;
import storage.Table;
import storage.Tuple;
import util.filecontroller.Serializer;
import java.util.*;

public class Selector {

	public static Vector<Tuple> selectOperation(Vector<Tuple> set1, Vector<Tuple> set2, String operation) {
		if (operation.equals(Constants.AND_OPERATION))
			return getANDingResults(set1, set2);
		else if (operation.equals(Constants.OR_OPERATION))
			return getORingResults(set1, set2);
		else
			return getXORingResults(set1, set2);
	}

	private static Vector<Tuple> getANDingResults(Vector<Tuple> set1, Vector<Tuple> set2) {
		Vector<Tuple> result = new Vector<>();
		for (int i = 0; i < set1.size(); i++) {
			if (vectorContainsTuple(set2, set1.get(i)))
				result.add(set1.get(i));
		}
		return result;
	}

	private static Vector<Tuple> getORingResults(Vector<Tuple> set1, Vector<Tuple> set2) {
		Vector<Tuple> result = new Vector<>();
		result.addAll(set2);
		for (int i = 0; i < set1.size(); i++) {
			if (!vectorContainsTuple(result, set1.get(i))) {
				result.add(set1.get(i));
			}
		}
		return result;
	}

	private static Vector<Tuple> getXORingResults(Vector<Tuple> set1, Vector<Tuple> set2) {
		Vector<Tuple> andResult = getANDingResults(set1, set2);
		Vector<Tuple> orResult = getORingResults(set1, set2);
		for (int i = 0; i < orResult.size(); i++) {
			if (vectorContainsTuple(andResult, orResult.get(i))) {
				orResult.remove(i--);
			}
		}
		return orResult;
	}

	private static boolean vectorContainsTuple(Vector<Tuple> vector, Tuple tuple) {
		for (Tuple vectorTuple : vector) {
			if (vectorTuple.getPrimaryKey().equals(tuple.getPrimaryKey()))
				return true;
		}
		return false;
	}
	
//	private static Iterator selectWithIndex(SQLTerm[] arrSQLTerms, String[] strarrOperators) throws DBAppException {
//		
//	}

	public static Iterator selectWithNoIndex(SQLTerm[] arrSQLTerms, String[] strarrOperators) throws DBAppException {
		Vector<Vector<Tuple>> result = new Vector<>();
		for (int i = 0; i < arrSQLTerms.length; i++) {
			Hashtable<String, Object> colNameValue = new Hashtable<>();
			colNameValue.put(arrSQLTerms[i]._strColumnName, arrSQLTerms[i]._objValue);
			result.add(selectFromTableHelper(arrSQLTerms[i]._strTableName, colNameValue, arrSQLTerms[i]._strOperator));
		}

		return applyArrOperators(result, strarrOperators).iterator();
	}

	private static Vector<Tuple> selectFromTableHelper(String strTableName, Hashtable<String, Object> colNameValue,
			String operator) throws DBAppException {
		Table table = Serializer.deserializeTable(strTableName);
		return table.select(colNameValue, operator);
	}

	private static Vector<Tuple> applyArrOperators(Vector<Vector<Tuple>> selections, String[] strarrOperators) {

		Vector<Tuple> result = new Vector<>();
		Vector<Vector<Tuple>> tmp = new Vector<>();
		int idx = 0;

		for (Vector<Tuple> tuplesVector : selections) {
			tmp.add(tuplesVector);
			if (tmp.size() == 2) {
				Vector<Tuple> firstSet = tmp.remove(0);
				Vector<Tuple> secondSet = tmp.remove(0);
				tmp.add(Selector.selectOperation(firstSet, secondSet, strarrOperators[idx++].toLowerCase()));
			}
		}
		result = tmp.remove(0);

		return result;
	}
}