package util.search;

import exceptions.DBAppException;
import storage.Cell;
import storage.Page;
import storage.Tuple;
import util.Compare;

import java.text.ParseException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

public class PageSearch {

	public static int binarySearch(Page page, Object primaryKey) throws DBAppException, ParseException {

		int low = 0;
		int high = page.getSize() - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			Tuple currTuple = page.getTuples().get(mid);
			Object pkValueOfCurrTuple = currTuple.getPrimaryKey();
			int comp = Compare.compare(primaryKey, pkValueOfCurrTuple);
			if (comp == 0)
				return mid;
			else if (comp > 0)
				low = mid + 1;
			else
				high = mid - 1;
		}

		return low;
	}

	public static Vector<Tuple> linearSearch(Page page, Hashtable<String, Object> colNameValue)
			throws DBAppException, ParseException {
		Vector<Tuple> results = new Vector<Tuple>();
		for (Tuple currTuple : page.getTuples()) {
			boolean isValid = true;
			for (Map.Entry<String, Object> curr : colNameValue.entrySet()) {
				String colName = curr.getKey();
				Object value = curr.getValue();
				Object currValue = getValueOfColInTuple(currTuple, colName);
				if (currValue == null || Compare.compare(currValue, value) != 0) {
					isValid = false;
					break;
				}
			}
			if (isValid)
				results.add(currTuple);
		}
		return results;
	}

	private static Object getValueOfColInTuple(Tuple currTuple, String colName) {
		Object ret = null;
		for (Cell currCellInTuple : currTuple.getCells())
			if (currCellInTuple.getKey().equals(colName)) {
				ret = currCellInTuple.getValue();
				break;
			}
		return ret;
	}
}