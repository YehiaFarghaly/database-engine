package search;

import constants.Constants;
import exceptions.DBAppException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static constants.Constants.*;

public class Compare {

	public static int compare(Object first, Object second) {
		return ((Comparable) first).compareTo((Comparable) second);
	}
}