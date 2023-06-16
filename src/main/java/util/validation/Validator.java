package util.validation;

import java.util.*;
import constants.Constants;
import datamanipulation.CsvReader;
import exceptions.DBAppException;
import sql.SQLTerm;
import storage.Page;
import storage.Table;
import storage.Tuple;
import util.Compare;
import util.TypeParser;
import util.filecontroller.Serializer;

public class Validator {

	private static String[] columns;
	private static String[] dataTypes;
	private static String[] pk;
	private static Object[] min;
	private static Object[] max;
	private static String[] indexName;

	public static void validateTableCreation(HashSet<String> appTables, String strTableName,
											 String strClusteringKeyColumn, Hashtable<String, String> htblColNameType,
											 Hashtable<String, String> htblColNameMin,
											 Hashtable<String, String> htblColNameMax) throws DBAppException {

		if (isValidTable(strTableName, appTables)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_REPEATED_TABLE_NAME);

		} else if (!validClusteringKey(strClusteringKeyColumn, htblColNameType)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_INVALID_CLUSTERINGKEY);

		} else if (!validDataTypes(htblColNameType)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_DATATYPE);

		} else if (!sameCol(htblColNameMin, htblColNameMax, htblColNameType)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_DOESNOT_CONTAIN_ALL_MIN_MAX_COLUMNS);

		} else if (!validMinAndMax(htblColNameType, htblColNameMin, htblColNameMax)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_MIN_OR_MAX_NOT_VALID);
		}
	}

	public static void validateInsertionInput(Table table, Hashtable<String, Object> htblColNameValue,
											  HashSet<String> appTables) throws DBAppException {
		getTableInfo(table);
		if (!primaryKeyExists(table, htblColNameValue)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_PK_IS_NOT_FOUND);
		} else if (!columnsExistenceInTable(htblColNameValue)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_COLUMNS_NOT_FOUND_IN_TABLE);
		} else if (!isTheSameDataTypeMissingCol(htblColNameValue)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_IN_DATA_TYPES);
		} else if (!checkMinMaxMissingCol(htblColNameValue)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_MIN_OR_MAX_NOT_VALID);
		} else if (foundPK(table, htblColNameValue)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_PK_IS_ALREADY_FOUND);
		}
	}

	public static void validateDeletionInput(Table table, Hashtable<String, Object> htblColNameValue,
											 HashSet<String> appTables) throws DBAppException {
		getTableInfo(table);
		if (!isTheSameDataTypeMissingCol(htblColNameValue)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_IN_DATA_TYPES);
		} else if (!checkTupleSize(htblColNameValue)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_IN_TUPLE_SIZE);
		} else if (!columnsExistenceInTable(htblColNameValue)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_COLUMNS_NOT_FOUND_IN_TABLE);
		}
	}

	public static void validateUpdateInput(Table table, Hashtable<String, Object> htblColNameValue,
										   HashSet<String> appTables) throws DBAppException {
		getTableInfo(table);
		if (!checkTupleSize(htblColNameValue)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_IN_TUPLE_SIZE);
		} else if (!isTheSameDataTypeMissingCol(htblColNameValue)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_IN_DATA_TYPES);
		} else if (!checkMinMaxMissingCol(htblColNameValue)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_MIN_OR_MAX_NOT_VALID);
		} else if (!columnsExistenceInTable(htblColNameValue)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_COLUMNS_NOT_FOUND_IN_TABLE);
		}
	}

	public static void validateCreatIndex(Table table, String[] strarrColName) throws DBAppException {
		getTableInfo(table);
		if (!numberOfColumnsInIndex(strarrColName)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_IN_INDEX_SIZE);
		} else if (!checkindex(strarrColName)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_INDEX_FOUND);
		}
	}

	public static void validateTable(String tableName, HashSet<String> myTables) throws DBAppException {
		if (!isValidTable(tableName, myTables)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_TABLE_NAME);
		}
	}

	private static boolean validClusteringKey(String strClusteringKeyColumn,
											  Hashtable<String, String> htblColNameType) {
		if (strClusteringKeyColumn != null && htblColNameType.containsKey(strClusteringKeyColumn)) {
			return true;
		}
		return false;
	}

	private static boolean numberOfColumnsInIndex(String[] strarrColName) {
		if (strarrColName.length == 3) {
			return true;
		}
		return false;
	}

	private static boolean checkindex(String[] strarrColName) {
		int tableColumnsLength = columns.length;
		for (String colName : strarrColName) {
			for (int i = 0; i < tableColumnsLength; i++) {
				if (colName.equals(columns[i])) {
					if (!indexName[i].equals("null")) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static boolean validDataTypes(Hashtable<String, String> htblColNameType) {
		boolean valid = true;
		for (String data : htblColNameType.values()) {
			if (data.equals(Constants.INTEGER_DATA_TYPE_NAME) || data.equals(Constants.DOUBLE_DATA_TYPE_NAME)
					|| data.equals(Constants.STRING_DATA_TYPE_NAME) || data.equals(Constants.DATE_DATA_TYPE_NAME)) {
				valid &= true;
			} else
				valid &= false;
		}
		return valid;
	}

	private static boolean validMinAndMax(Hashtable<String, String> htblColNameType,
										  Hashtable<String, String> htblColNameMin, Hashtable<String, String> htblColNameMax) {
		int length = htblColNameMin.values().size();

		for (int i = 0; i < length; i++) {
			Object minValue = (String) htblColNameMin.values().toArray()[i];
			String keyMinValue = (String) htblColNameMin.keySet().toArray()[i];
			minValue = TypeParser.typeParser(minValue, keyMinValue, htblColNameType);
			Object maxValue = htblColNameMax.values().toArray()[i];
			String keyMaxValue = (String) htblColNameMax.keySet().toArray()[i];
			maxValue = TypeParser.typeParser(maxValue, keyMaxValue, htblColNameType);

			if (isFirstLessThanSecond(maxValue, minValue) || !minValue.getClass().equals(maxValue.getClass())) {
				return false;
			}
		}
		return true;
	}

	private static boolean sameCol(Hashtable<String, String> htblColNameMin, Hashtable<String, String> htblColNameMax,
								   Hashtable<String, String> htblColNameType) {
		return htblColNameMin.keySet().equals(htblColNameMax.keySet())
				&& htblColNameMin.keySet().equals(htblColNameType.keySet());

	}

	public static void checkNoClusteringKey(Hashtable<String, Object> htblColNameValue, Table table)
			throws DBAppException {
		if (htblColNameValue.containsKey(table.getPKColumn()))
			throw new DBAppException(Constants.ERROR_MESSAGE_TUPLE_DATA);

	}

	private static boolean isValidTable(String tableName, HashSet<String> myTables) {
		return myTables.contains(tableName);
	}

	private static boolean sameSuffix(Hashtable<String, Object> tuple, String first, int index) {
		return tuple.get(first).getClass().toString().endsWith(dataTypes[index]);
	}

	public static boolean foundPK(Table table, Hashtable<String, Object> tuple) throws DBAppException {
		if (!table.isEmpty()) {
			Tuple tupleToFind = table.createTuple(tuple);
			Object pk = tupleToFind.getPrimaryKey();
			int pageNum = table.tableBinarySearch(pk);
			if (pageNum < table.getPagesName().size()) {
				Page page = table.getPageAtPosition(pageNum);
				int position = page.pageBinarySearch(pk);
				if (checkPKExistance(page, position, pk))
					return true;
			}
		}
		return false;
	}

	private static boolean checkPKExistance(Page page, int position, Object pk) {
		if (position < page.getSize()) {
			Tuple tuple = page.getTuples().get(position);
			return tuple.getPrimaryKey().equals(pk);
		}
		return false;
	}

	private static void getTableInfo(Table table) {
		CsvReader cr = new CsvReader();
		String tablename = table.getName();
		ArrayList<String[]> tableInfo = cr.readTable(tablename);
		int size = tableInfo.size();
		initializeAttributes(size);
		for (int i = 0; i < size; i++) {
			columns[i] = tableInfo.get(i)[Constants.COLUMN_NAME_INDEX];
			dataTypes[i] = tableInfo.get(i)[Constants.COLUMN_TYPE_INDEX];
			pk[i] = tableInfo.get(i)[Constants.PRIMARY_KEY_INDEX];
			min[i] = tableInfo.get(i)[Constants.COL_MIN_VALUE_INDEX];
			max[i] = tableInfo.get(i)[Constants.COL_MAX_VALUE_INDEX];
			indexName[i] = tableInfo.get(i)[Constants.INDEX_NAME_INDEX];
		}
	}

	private static void initializeAttributes(int size) {
		columns = new String[size];
		dataTypes = new String[size];
		pk = new String[size];
		min = new Object[size];
		max = new Object[size];
		indexName = new String[size];
	}

	private static boolean primaryKeyExists(Table table, Hashtable<String, Object> tuple) {
		for (String key : tuple.keySet()) {
			if (key.equals(table.getPKColumn()))
				return true;
		}
		return false;
	}

	private static boolean columnsExistenceInTable(Hashtable<String, Object> tuple) {
		for (String attribute : tuple.keySet()) {
			boolean colFound = checkAttributeExistence(attribute);
			if (!colFound)
				return false;
		}

		return true;
	}

	private static boolean checkAttributeExistence(String attribute) {
		for (int i = 0; i < columns.length; i++) {
			if (columns[i].equals(attribute)) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkTupleSize(Hashtable<String, Object> tuple) {
		return tuple.size() <= columns.length;
	}

	private static boolean isTheSameDataTypeMissingCol(Hashtable<String, Object> tuple) {
		int index = 0;
		for (String column : columns) {
			if (tuple.containsKey(column)) {
				if (!sameSuffix(tuple, column, index))
					return false;
			}
			index++;
		}
		return true;
	}

	private static boolean checkMinMaxMissingCol(Hashtable<String, Object> tuple) throws DBAppException {
		int index = 0;
		boolean valid = true;
		for (String s : columns) {
			if (tuple.containsKey(s)) {
				valid &= parseMinMax(tuple, s, index);
			}
			index++;
		}
		return valid;
	}

	private static boolean parseMinMax(Hashtable<String, Object> tuple, String value, int index) {

		Object insertedValue = tuple.get(value);
		Object minValue = min[index];
		Object maxValue = max[index];
		String dataType = dataTypes[index];
		minValue = TypeParser.typeParser(minValue, dataType);
		maxValue = TypeParser.typeParser(maxValue, dataType);
		if ((isFirstLessThanSecond(insertedValue, minValue)) || (isFirstGreaterThanSecond(insertedValue, maxValue))) {
			return false;
		}
		return true;
	}

	private static boolean isFirstLessThanSecond(Object comp1, Object comp2) {
		return Compare.compare(comp1, comp2) < 0;
	}

	private static boolean isFirstGreaterThanSecond(Object comp1, Object comp2) {
		return Compare.compare(comp1, comp2) > 0;
	}

	public static void validateSelectionInput(SQLTerm[] arrSQLTerms, String[] strarrOperators, HashSet<String> myTables)
			throws DBAppException {

		if (strarrOperators.length >= arrSQLTerms.length)
			throw new DBAppException(Constants.ERROR_MESSAGE_TOO_MUCH_OPERATOS);
		if (!knownArrOperators(strarrOperators))
			throw new DBAppException(Constants.ERROR_MESSAGE_UNKNOWN_ARR_OPERATOR);
		if (!validTables(arrSQLTerms, myTables))
			throw new DBAppException(Constants.ERROR_MESSAGE_TABLE_NAME);
		if (!validOperators(arrSQLTerms))
			throw new DBAppException(Constants.ERROR_MESSAGE_UNKNOWN_OPERATOR);
		validateTermColumn(arrSQLTerms);

	}

	private static boolean knownArrOperators(String[] operators) {
		for (String operator : operators) {
			if (!(operator.toLowerCase().equals(Constants.AND_OPERATION)
					|| operator.toLowerCase().equals(Constants.OR_OPERATION)
					|| operator.toLowerCase().equals(Constants.XOR_OPERATION)))
				return false;

		}
		return true;
	}

	private static boolean validTables(SQLTerm[] sqlTerms, HashSet<String> myTables) {

		for (int i = 0; i < sqlTerms.length; i++) {
			if (!isValidTable(sqlTerms[i]._strTableName, myTables))
				return false;
		}

		return true;
	}

	private static boolean validOperators(SQLTerm[] sqlTerms) {

		for (int i = 0; i < sqlTerms.length; i++) {
			String operator = sqlTerms[i]._strOperator;
			if (!(operator.equals(Constants.EQUAL) || operator.equals(Constants.NOT_EQUAL)
					|| operator.equals(Constants.GREATER_THAN) || operator.equals(Constants.LESS_THAN)
					|| operator.equals(Constants.GREATER_THAN_OR_EQUAL)
					|| operator.equals(Constants.LESS_THAN_OR_EQUAL)))
				return false;
		}
		return true;
	}

	private static void validateTermColumn(SQLTerm[] sqlTerms) throws DBAppException {
		for (int i = 0; i < sqlTerms.length; i++) {
			Table table = Serializer.deserializeTable(sqlTerms[i]._strTableName);
			Hashtable<String, Object> colNameValue = new Hashtable<>();
			if (sqlTerms[i]._objValue == null)
				throw new DBAppException(Constants.ERROR_MESSAGE_COLUMNS_NOT_FOUND_IN_TABLE);
			colNameValue.put(sqlTerms[i]._strColumnName, sqlTerms[i]._objValue);
			getTableInfo(table);
			if (!columnsExistenceInTable(colNameValue))
				throw new DBAppException(Constants.ERROR_MESSAGE_COLUMNS_NOT_FOUND_IN_TABLE);
			if (!isTheSameDataTypeMissingCol(colNameValue))
				throw new DBAppException(Constants.ERROR_MESSAGE_IN_DATA_TYPES);
		}

	}
}