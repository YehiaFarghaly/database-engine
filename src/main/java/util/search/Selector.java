package util.search;

import constants.Constants;
import datamanipulation.CsvReader;
import exceptions.DBAppException;
import sql.SQLTerm;
import storage.Page;
import storage.Table;
import storage.Tuple;
import storage.index.*;
import storage.index.OctreeIndex;
import util.TypeParser;
import util.filecontroller.Serializer;
import java.util.*;

public class Selector {
	private static boolean incrementIndex;

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

	public static Vector<Tuple> selectWithNoIndex(SQLTerm[] arrSQLTerms, String[] strarrOperators)
			throws DBAppException {
		Vector<Vector<Tuple>> result = new Vector<>();
		for (int i = 0; i < arrSQLTerms.length; i++) {
			Hashtable<String, Object> colNameValue = new Hashtable<>();
			colNameValue.put(arrSQLTerms[i]._strColumnName, arrSQLTerms[i]._objValue);
			result.add(selectFromTableHelper(arrSQLTerms[i]._strTableName, colNameValue, arrSQLTerms[i]._strOperator));
		}
		return applyArrOperators(result, strarrOperators);
	}

	private static Hashtable<String, Object> getMax(String tableName, String[] col) {
		CsvReader reader = new CsvReader();
		List<String[]> columns = reader.readTable(tableName);
		return getColAtIdx(columns, Constants.COL_MAX_VALUE_INDEX, col);
	}

	private static Hashtable<String, Object> getColAtIdx(List<String[]> columns, int idx, String[] colNames) {
		Hashtable<String, Object> colMax = new Hashtable<String, Object>();
		for (String[] arr : columns) {
			if (arr[Constants.COLUMN_NAME_INDEX].equals(colNames[0])) {
				colMax.put(colNames[0],
						TypeParser.typeParser(arr[idx], arr[Constants.COLUMN_TYPE_INDEX]));
			} else if (arr[Constants.COLUMN_NAME_INDEX].equals(colNames[1])) {
				colMax.put(colNames[1],
						TypeParser.typeParser(arr[idx], arr[Constants.COLUMN_TYPE_INDEX]));
			} else if (arr[Constants.COLUMN_NAME_INDEX].equals(colNames[2])) {
				colMax.put(colNames[2],
						TypeParser.typeParser(arr[idx], arr[Constants.COLUMN_TYPE_INDEX]));
			}
		}
		return colMax;
	}

	private static Hashtable<String, Object> getMin(String tableName, String[] col) {
		CsvReader reader = new CsvReader();
		List<String[]> columns = reader.readTable(tableName);
		return getColAtIdx(columns, Constants.COL_MIN_VALUE_INDEX, col);
	}

	private static List getPageIndcies(String[] strOperator, OctreeIndex index, String[] columnsNames,
			Hashtable<String, Object> colNameValue, String tableName) throws DBAppException {
		Hashtable<String, Object> min = getMin(tableName, columnsNames);
		Hashtable<String, Object> max = getMax(tableName, columnsNames);
		Object minBounds[] = new Object[3];
		Object maxBounds[] = new Object[3];
		int minMask = 0;
		int maxMask = 0;
		for (int i = 0; i < strOperator.length; i++) {
			String operator = strOperator[i];
			minBounds[i] = getMinBound(operator, i, colNameValue, columnsNames, min);
			maxBounds[i] = getMaxBound(operator, i, colNameValue, columnsNames, max);
			if (operator.equals(Constants.GREATER_THAN))
				minMask |= (1 << i);
			else if (operator.equals(Constants.LESS_THAN))
				maxMask |= (1 << i);
		}
		OctreeBounds bounds = new OctreeBounds(minBounds[0], minBounds[1], minBounds[2], maxBounds[0], maxBounds[1], maxBounds[2]);
		return index.query(bounds, minMask, maxMask);
	}

	private static Object getMinBound(String operator, int idx, Hashtable<String, Object> colNameValue,
			String[] columnNames, Hashtable<String, Object> min) {
		if (operator.equals(Constants.EQUAL) || operator.equals(Constants.GREATER_THAN)
				|| operator.equals(Constants.GREATER_THAN_OR_EQUAL))
			return colNameValue.get(columnNames[idx]);
		else
			return min.get(columnNames[idx]);
	}

	private static Object getMaxBound(String operator, int idx, Hashtable<String, Object> colNameValue,
			String[] columnNames, Hashtable<String, Object> max) {
		if (operator.equals(Constants.EQUAL) || operator.equals(Constants.LESS_THAN)
				|| operator.equals(Constants.LESS_THAN_OR_EQUAL))
			return colNameValue.get(columnNames[idx]);
		else
			return max.get(columnNames[idx]);
	}

	public static HashSet<Integer> getPagesNumbers(List pagespathes, Table table) {
		HashSet<Integer> result = new HashSet<>();
		for (int i = 0; i < pagespathes.size(); i++) {
			result.add(table.getPageIdxFromPath(pagespathes.get(i).toString()));
		}
		return result;
	}

	private static Vector<Vector<Tuple>> getSelectFromTableWithIndex(SQLTerm[] arrSQLTerms,
			HashSet<Integer> pagenumbers, Hashtable<String, Object> colNameValue) throws DBAppException {
		Vector<Vector<Tuple>> result = new Vector<>();
		int idx = 0;
		for (String key : colNameValue.keySet()) {
			Hashtable<String, Object> colVal = new Hashtable<>();
			colVal.put(key, colNameValue.get(key));
			result.add(selectFromTableWithIndex(arrSQLTerms[idx]._strTableName, colVal, arrSQLTerms[idx++]._strOperator,
					pagenumbers));
		}
		return result;
	}

	private static Hashtable<String, Object> setcolNameValues(SQLTerm[] arrSQLTerms) {
		Hashtable<String, Object> colNameValue = new Hashtable<>();
		for (int i = 0; i < arrSQLTerms.length; i++) {
			colNameValue.put(arrSQLTerms[i]._strColumnName, arrSQLTerms[i]._objValue);
		}
		return colNameValue;
	}

	private static String[] setstrOperators(SQLTerm[] arrSQLTerms) {
		String strOperator[] = new String[arrSQLTerms.length];
		for (int i = 0; i < arrSQLTerms.length; i++) {
			strOperator[i] = arrSQLTerms[i]._strOperator;
		}
		return strOperator;
	}

	public static Vector<Tuple> selectWithIndex(OctreeIndex index, SQLTerm[] arrSQLTerms, String[] columnsNames,
			Table table) throws DBAppException {
		String[] strarrOperators = new String[2];
		List pagepathes;
		HashSet<Integer> pagenumbers;
		String strOperator[] = setstrOperators(arrSQLTerms);
		Vector<Vector<Tuple>> result = new Vector<>();
		Hashtable<String, Object> colNameValue = setcolNameValues(arrSQLTerms);
		pagepathes = getPageIndcies(strOperator, index, columnsNames, colNameValue, table.getName());
		pagenumbers = getPagesNumbers(pagepathes, table);
		result.addAll(getSelectFromTableWithIndex(arrSQLTerms, pagenumbers, colNameValue));
		strarrOperators[0] = Constants.AND_OPERATION;
		strarrOperators[1] = Constants.AND_OPERATION;
		return applyArrOperators(result, strarrOperators);

	}

	public static Vector<Tuple> selectFromTableWithIndex(String strTableName, Hashtable<String, Object> colNameValue,
			String operator, HashSet<Integer> pageIndex) throws DBAppException {
		Vector<Tuple> result = new Vector<>();
		Table table = Serializer.deserializeTable(strTableName);
		for (int index : pageIndex) {
			Page page = table.getPageAtPosition(index);
			result.addAll(page.select(colNameValue, operator));
		}
		return result;
	}

	public static Vector<Tuple> selectFromTableHelper(String strTableName, Hashtable<String, Object> colNameValue,
			String operator) throws DBAppException {
		Table table = Serializer.deserializeTable(strTableName);
		return table.select(colNameValue, operator);
	}

	public static Vector<Tuple> applyArrOperators(Vector<Vector<Tuple>> selections, String[] strarrOperators) {

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

	private static String[] removeFromStrarrOperators(String[] strarrOperators, int index) {
		String[] res = new String[strarrOperators.length-1];
		int idx = 0;
		for (int i = 0; i < strarrOperators.length; i++) {
			if ( i != index)
				res[idx++] = strarrOperators[i];	
		}
		return res;
	}

	public static Iterator selectWithMoreThanTwoOperators(SQLTerm[] sqlTerms, String[] operators)
			throws DBAppException {
		Vector<Vector<Tuple>> result = new Vector<>();
		int len = sqlTerms.length;
		for (int i = 0; i < len - 1; i++) {
			incrementIndex = false;
			if (i < len - 3 && conditionForIndex(operators[i], operators[i + 1])) {
				result.addAll(getResultsFromIndex(sqlTerms, i));
				if (incrementIndex) {
					operators = removeFromStrarrOperators(operators, i);
					operators = removeFromStrarrOperators(operators, ++i);
				}
			} else {
				result.add(getResultsWithNoIndex(sqlTerms, i));
				if (i == operators.length - 1)
					result.add(getResultsWithNoIndex(sqlTerms, i + 1));
			}
		}
		return Selector.applyArrOperators(result, operators).iterator();
	}

	private static boolean conditionForIndex(String operator1, String operator2) {
		return operator1.toLowerCase().equals(Constants.AND_OPERATION)
				&& operator2.toLowerCase().equals(Constants.AND_OPERATION);
	}

	private static ArrayList<String> fillcolNames(SQLTerm[] arrSQLTerms, int index) {
		ArrayList<String> colNames = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			colNames.add(arrSQLTerms[index + i]._strColumnName);
		}
		return colNames;
	}

	private static int[] fillIdx(ArrayList<String> colNames, OctreeIndex index) {
		int idx[] = new int[3];
		idx[0] = colNames.indexOf(index.getColName1());
		idx[1] = colNames.indexOf(index.getColName2());
		idx[2] = colNames.indexOf(index.getColName3());
		return idx;
	}

	private static SQLTerm[] fillarrSQLTermsIndex(SQLTerm[] arrSQLTerms, int i, int[] idx) {
		SQLTerm[] arrSQLTermsIndex = new SQLTerm[3];
		for (int j = 0; j < 3; j++) {
			arrSQLTermsIndex[j] = arrSQLTerms[i + idx[j]];
		}
		return arrSQLTermsIndex;
	}

	private static String[] fillcolumnsNames(SQLTerm[] arrSQLTerms, ArrayList<String> colNames, int[] idx) {
		String[] columnsNames = new String[3];
		for (int j = 0; j < 3; j++) {
			columnsNames[j] = colNames.get(idx[j]);
		}
		return columnsNames;
	}

	private static Vector<Vector<Tuple>> getResultsFromIndex(SQLTerm[] arrSQLTerms, int i) throws DBAppException {
		Vector<Vector<Tuple>> result = new Vector<>();
		ArrayList<String> colNames = fillcolNames(arrSQLTerms, i);
		Table table = Serializer.deserializeTable(arrSQLTerms[0]._strTableName);
		for (OctreeIndex<?> index : table.getIndices()) {
			int idx[] = fillIdx(colNames, index);
			if (idx[0] != -1 && idx[1] != -1 && idx[2] != -1) {
				SQLTerm[] arrSQLTermsIndex = fillarrSQLTermsIndex(arrSQLTerms, i, idx);
				String[] columnsNames = fillcolumnsNames(arrSQLTerms, colNames, idx);
				result.add(Selector.selectWithIndex(index, arrSQLTermsIndex, columnsNames, table));
				incrementIndex = true;
				break;
			}
		}
		return result;
	}

	private static Vector<Tuple> getResultsWithNoIndex(SQLTerm[] arrSQLTerms, int i) throws DBAppException {
		Hashtable<String, Object> colNameValue = new Hashtable<>();
		colNameValue.put(arrSQLTerms[i]._strColumnName, arrSQLTerms[i]._objValue);
		return Selector.selectFromTableHelper(arrSQLTerms[i]._strTableName, colNameValue, arrSQLTerms[i]._strOperator);
	}

}