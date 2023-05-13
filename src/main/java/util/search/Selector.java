package util.search;

import java.util.Vector;
import constants.Constants;
import storage.Tuple;

public class Selector {

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

}