package util.search;

import exceptions.DBAppException;
import storage.Cell;
import storage.Page;
import storage.Tuple;
import util.Compare;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

import constants.Constants;

public class PageSearch {

	public static int binarySearch(Page page, Object primaryKey) throws DBAppException {

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

	public static Vector<Tuple> linearSearchWithOperator(Page page, String operator,
			Hashtable<String, Object> colNameValue) {
		Vector<Tuple> res = new Vector<>();
		String key = colNameValue.keys().nextElement();
		for (int i = 0; i < page.getSize(); i++) {
			Tuple tuple = page.getTuples().get(i);
			Object tupleVal = getValueOfColInTuple(tuple, key);
			if (operatorBasedSelection(tupleVal, colNameValue.get(key), operator))
				res.add(tuple);
		}
		return res;
	}

	private static boolean operatorBasedSelection(Object firstOperand, Object secondOperand, String operator) {

		if (operator.equals(Constants.EQUAL))
			return Compare.compare(firstOperand, secondOperand) == 0;
		if (operator.equals(Constants.GREATER_THAN))
			return Compare.compare(firstOperand, secondOperand) > 0;
		if (operator.equals(Constants.GREATER_THAN_OR_EQUAL))
			return Compare.compare(firstOperand, secondOperand) >= 0;
		if (operator.equals(Constants.LESS_THAN))
			return Compare.compare(firstOperand, secondOperand) < 0;
		if (operator.equals(Constants.LESS_THAN_OR_EQUAL))
			return Compare.compare(firstOperand, secondOperand) <= 0;
		else
			return Compare.compare(firstOperand, secondOperand) != 0;
	}

	public static Vector<Tuple> linearSearch(Page page, Hashtable<String, Object> colNameValue) throws DBAppException {

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