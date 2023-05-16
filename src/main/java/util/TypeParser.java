package util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.text.SimpleDateFormat;
import constants.Constants;
import datamanipulation.CsvReader;
import storage.Table;

public class TypeParser {

	public static Object castClusteringKey(Table table, String clusteringKeyValue) {
		String primaryKeyType = table.getPrimaryKeyType();
		if (primaryKeyType.equals(Constants.INTEGER_DATA_TYPE_NAME))
			return Integer.parseInt(clusteringKeyValue);
		else if (primaryKeyType.equals(Constants.DOUBLE_DATA_TYPE_NAME))
			return Double.parseDouble(clusteringKeyValue);
		return clusteringKeyValue;
	}

	public static Object typeParser(Object data, String key, Hashtable<String, String> htblColNameType) {
		String type = htblColNameType.get(key);
		return typeParser(data, type);
	}

	public static Object typeParser(Object data, String type) {
		if (type.equals(Constants.INTEGER_DATA_TYPE_NAME)) {
			return Integer.parseInt(data.toString());
		} else if (type.equals(Constants.DOUBLE_DATA_TYPE_NAME)) {
			return Double.parseDouble(data.toString());
		} else if (type.equals(Constants.DATE_DATA_TYPE_NAME)) {
			String[] patterns = { "yyyy-MM-dd", "MM/dd/yyyy", "dd-MMM-yyyy", "yyyy/MM/dd" };
			for (String pattern : patterns) {
				SimpleDateFormat sdformat = new SimpleDateFormat(pattern);
				try {
					return sdformat.parse(data.toString());
				} catch (ParseException e) {

				}
			}
		}
		return data.toString();
	}

	public static Object parseFromTable(Object data, String colName, String tableName) {
		CsvReader reader = new CsvReader();
		ArrayList<String[]> list = reader.readTable(tableName);
		Object ret = null;
		for (String[] arr : list) {
			if (arr[Constants.COLUMN_NAME_INDEX].equals(colName))
				ret = typeParser(data, arr[Constants.COLUMN_TYPE_INDEX]);
		}
		return ret;
	}

}
