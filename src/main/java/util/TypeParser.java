package util;

import java.text.ParseException;
import java.util.Hashtable;

import com.ibm.icu.text.SimpleDateFormat;

import constants.Constants;

public class TypeParser {
	public static Object typeParser(Object data, String key, Hashtable<String, String> htblColNameType) {
		String type = htblColNameType.get(key);		
		if (type.equals(Constants.INTEGER_DATA_TYPE_NAME)) {
			return Integer.parseInt(data.toString());
		}else if (type.equals(Constants.DOUBLE_DATA_TYPE_NAME)) {
			return Double.parseDouble(data.toString());
		}else if (type.equals(Constants.DATE_DATA_TYPE_NAME)) {
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				return sdformat.parse(data.toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
			return data.toString();
		
		
	}
	
	public static Object typeParser(Object data) {
		String type = data.getClass().toString(); 
		if (type.equals(Constants.INTEGER_DATA_TYPE_NAME)) {
			return Integer.parseInt(data.toString());
		}else if (type.equals(Constants.DOUBLE_DATA_TYPE_NAME)) {
			return Double.parseDouble(data.toString());
		}else if (type.equals(Constants.DATE_DATA_TYPE_NAME)) {
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				return sdformat.parse(data.toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
			return data.toString();
		
		
	}
	

}
