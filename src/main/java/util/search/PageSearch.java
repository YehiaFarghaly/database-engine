package util.search;

import java.text.ParseException;
import java.util.Vector;
import exceptions.DBAppException;
import storage.Cell;
import storage.Page;
import storage.Tuple;
import util.Compare;

public class PageSearch {

	public static int binarySearch(Page page, Object primaryKey) throws DBAppException, ParseException {
		
		int LOW = 0;
		int high = page.getSize() - 1;
		
		while (LOW <= high) {
			int mid = LOW + (high - LOW) / 2;
			Tuple currTuple = page.getTuples().get(mid);
			Object pkValueOfCurrTuple = currTuple.getPrimaryKey();
			int comp = Compare.compare(primaryKey, pkValueOfCurrTuple);
			if (comp == 0)
				return mid;
			else if (comp > 0)
				LOW = mid + 1;
			else
				high = mid - 1;
		}
		
		return LOW;
	}

	public static Vector<Tuple> linearSearch(Page page, String colName, Object value)
			throws DBAppException, ParseException {
		
		Vector<Tuple> results = new Vector<Tuple>();
		
		for (Tuple currTuple : page.getTuples()) {
			
			Object currValue = getValueOfColInTuple(currTuple, colName);
			int comp = Compare.compare(currValue, value);
			if (comp == 0)
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