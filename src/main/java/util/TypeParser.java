package util;

import java.text.ParseException;
import java.util.Hashtable;

import com.ibm.icu.text.SimpleDateFormat;

import constants.Constants;

public class TypeParser {
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
			String[] patterns = { "yyyy-MM-dd", "dd/MM/yyyy" };
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

}
