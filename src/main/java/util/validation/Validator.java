package util.validation;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import com.opencsv.exceptions.CsvValidationException;
import constants.Constants;
import datamanipulation.CsvReader;
import exceptions.DBAppException;
import storage.Page;
import storage.Table;
import storage.Tuple;
import util.Compare;
import util.TypeParser;

public class Validator {

	private static String[] columns;
	private static String[] dataTypes;
	private static String[] pk;
	private static Object[] min;
	private static Object[] max;

	public static void validateTableCreation(HashSet<String> appTables, String strTableName,
			String strClusteringKeyColumn, Hashtable<String, String> htblColNameType,
			Hashtable<String, String> htblColNameMin, Hashtable<String, String> htblColNameMax) throws DBAppException {

		if (validTable(strTableName, appTables)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_REPEATED_TABLE_NAME);

		} else if (!validClusteringKey(strClusteringKeyColumn, htblColNameMax)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_INVALID_CLUSTERINGKEY);

		} else if (!validDataTypes(htblColNameType)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_DATATYPE);

		} else if (!validMinAndMax(htblColNameType, htblColNameMin, htblColNameMax)
				|| !sameColMinMax(htblColNameMin, htblColNameMax)) {
			throw new DBAppException(Constants.ERROR_MESSAGE_MIN_OR_MAX_NOT_VALID);

		}
	}

	private static boolean validClusteringKey(String strClusteringKeyColumn,
			Hashtable<String, String> htblColNameType) {
		if (strClusteringKeyColumn != null && htblColNameType.containsKey(strClusteringKeyColumn)) {
			return true;
		}
		return false;
	}

	private static boolean validDataTypes(Hashtable<String, String> htblColNameType) {
		for (String data : htblColNameType.values()) {
			if (data.equals(Constants.INTEGER_DATA_TYPE_NAME) || data.equals(Constants.DOUBLE_DATA_TYPE_NAME)
					|| data.equals(Constants.STRING_DATA_TYPE_NAME) || data.equals(Constants.DATE_DATA_TYPE_NAME)) {
				return true;
			}
		}
		return false;
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

	private static boolean sameColMinMax(Hashtable<String, String> htblColNameMin,
			Hashtable<String, String> htblColNameMax) {
		return htblColNameMin.keySet().equals(htblColNameMax.keySet());

	}

	public static void validateInsertionInput(Table table, Hashtable<String, Object> htblColNameValue,
			HashSet<String> appTables)
			throws DBAppException, CsvValidationException, ClassNotFoundException, IOException, ParseException {

		if (!validTable(table.getName(), appTables))
			throw new DBAppException(Constants.ERROR_MESSAGE_TABLE_NAME);
		if (!validTuple(table, htblColNameValue))
			throw new DBAppException(Constants.ERROR_MESSAGE_TUPLE_DATA);
	}

	public static void validateDeletionInput(Table table, Hashtable<String, Object> htblColNameValue,
			HashSet<String> appTables) throws DBAppException {
		getTableInfo(table);
		if (!validTable(table.getName(), appTables))
			throw new DBAppException(Constants.ERROR_MESSAGE_TABLE_NAME);
		else if (!isTheSameDataTypeMissingCol(htblColNameValue))
			throw new DBAppException(Constants.ERROR_MESSAGE_TUPLE_DATA);
	}

	public static void validateUpdateInput(Table table, Hashtable<String, Object> htblColNameValue,
			HashSet<String> appTables)
			throws DBAppException, CsvValidationException, ClassNotFoundException, IOException, ParseException {
		if (!validTable(table.getName(), appTables))
			throw new DBAppException(Constants.ERROR_MESSAGE_TABLE_NAME);
		if (!validTupleUpdate(table, htblColNameValue))
			throw new DBAppException(Constants.ERROR_MESSAGE_TUPLE_DATA);
	}

	private static boolean validTable(String tableName, HashSet<String> myTables) {
		return myTables.contains(tableName);
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

	private static boolean sameSuffix(Hashtable<String, Object> tuple, String first, int index) {
		return tuple.get(first).getClass().toString().endsWith(dataTypes[index]);
	}

	private static boolean foundPK(Table table, Hashtable<String, Object> tuple)
			throws ClassNotFoundException, DBAppException, ParseException, IOException {
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
		}

	}

	private static void initializeAttributes(int size) {
		columns = new String[size];
		dataTypes = new String[size];
		pk = new String[size];
		min = new Object[size];
		max = new Object[size];
	}

	private static boolean validTuple(Table table, Hashtable<String, Object> tuple)
			throws CsvValidationException, IOException, ClassNotFoundException, DBAppException, ParseException {

		getTableInfo(table);
		if (!checkTupleSize(tuple) || !isTheSameNumberOfColumns(tuple) || !containsAllColumns(tuple) || !isTheSameDataType(tuple)
				|| !checkMinMax(tuple) || foundPK(table, tuple)) {
			return false;
		} else {
			return true;

		}
	}

	private static boolean isTheSameNumberOfColumns(Hashtable<String, Object> tuple) {
		if (tuple.size() != columns.length) {
			return false;
		}
		return true;
	}

	private static boolean containsAllColumns(Hashtable<String, Object> tuple) {
		for (String s:tuple.keySet()) {
			boolean colFound = false;
			for (int i = 0; i<columns.length; i++) {
				if (columns[i].equals(s)) {
					colFound = true;
				}
			}
			if (!colFound) return false;
		}
		
		return true;
	}
	
	private static boolean checkTupleSize(Hashtable<String, Object> tuple) {
		return tuple.size()<=columns.length;
	}

	private static boolean isTheSameDataType(Hashtable<String, Object> tuple) {
		for (int i = 0; i < columns.length; i++) {
			if (!sameSuffix(tuple, columns[i], i))

				return false;
		}
		return true;
	}

	private static boolean validTupleUpdate(Table table, Hashtable<String, Object> tuple)
			throws CsvValidationException, IOException, ClassNotFoundException, DBAppException, ParseException {
		getTableInfo(table);
		if (!checkTupleSize(tuple) || !isTheSameDataTypeMissingCol(tuple) || !foundPK(table, tuple)
				|| !checkMinMaxMissingCol(tuple) || !containsAllColumns(tuple)) {
			return false;
		} else {
			return true;
		}
	}

	private static boolean checkMinMax(Hashtable<String, Object> tuple) throws ParseException {
		for (int i = 0; i < columns.length; i++) {
			parseMinMax(tuple, columns[i], i);
		}
		return true;
	}

	private static boolean checkMinMaxMissingCol(Hashtable<String, Object> tuple) throws ParseException {
		int index = 0;
		for (String s : columns) {
			if (tuple.containsKey(s)) {
				parseMinMax(tuple, s, index);
			}
			index++;
		}
		return true;
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

}