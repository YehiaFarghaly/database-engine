package util.search;

import constants.Constants;
import exceptions.DBAppException;
import sql.SQLTerm;
import storage.Page;
import storage.Table;
import storage.Tuple;
import storage.index.OctreeBounds;
import storage.index.OctreeIndex;
import util.filecontroller.Serializer;

import java.util.*;

import static constants.Constants.*;

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

    public static Iterator selectWithNoIndex(SQLTerm[] arrSQLTerms, String[] strarrOperators) throws DBAppException {
        Vector<Vector<Tuple>> result = new Vector<>();
        for (int i = 0; i < arrSQLTerms.length; i++) {
            Hashtable<String, Object> colNameValue = new Hashtable<>();
            colNameValue.put(arrSQLTerms[i]._strColumnName, arrSQLTerms[i]._objValue);
            result.add(selectFromTableHelper(arrSQLTerms[i]._strTableName, colNameValue, arrSQLTerms[i]._strOperator));
        }

        return applyArrOperators(result, strarrOperators).iterator();
    }
    
//    public static Iterator selectWithIndex(OctreeIndex index, String [] Object colValue) {
//    	Vector<Vector<Tuple>> result = new Vector<>();
//    	
//    }

//    public static Iterator selectWithIndex(SQLTerm[] terms, String[] opr, HashMap<OctreeIndex<?>, ArrayList<Integer>> indIdx) throws DBAppException {
//        String tableName = terms[0]._strTableName;
//        Vector<Vector<Tuple>> finalResult = new Vector<>();
//        for (Map.Entry<OctreeIndex<?>, ArrayList<Integer>> curr : indIdx.entrySet()) {
//            ArrayList<Integer> idx = curr.getValue();
//            OctreeIndex currIndex = curr.getKey();
//            OctreeBounds octreeBounds = prepareOctreeBounds(currIndex, idx, terms);
//            List<Object> pages = curr.getKey().query(octreeBounds);
//            Vector<Vector<Tuple>> result = new Vector<>();
//            getPrimarySelectResult(pages, tableName, idx, terms, result);
//            String[] oprBetweenIndexCol = {AND_OPERATION, AND_OPERATION, AND_OPERATION};
//            finalResult.add(applyArrOperators(result, oprBetweenIndexCol));
//        }
//        return finalResult.iterator();
//    }

    private static void getPrimarySelectResult(List<Object>pages, String tableName, ArrayList<Integer>idx, SQLTerm[]arrSQLTerms, Vector<Vector<Tuple>>result) throws DBAppException {
        for (Object tmp : pages) {
            String tmpPage = (String) tmp;
            Page page = Serializer.deserializePage(tableName, tmpPage);
            for (int i : idx) // O(3)
                result.add(getResultforIndexSelect(page, i, arrSQLTerms));
        }
    }

    private static Vector<Tuple> getResultforIndexSelect(Page page, int idx, SQLTerm[] terms) {
        Hashtable<String, Object> colNameVal = new Hashtable<>();
        colNameVal.put(terms[idx]._strColumnName, terms[idx]._objValue);
        String operator = terms[idx]._strOperator;
        return page.select(colNameVal, operator);
    }

    private static OctreeBounds prepareOctreeBounds(OctreeIndex<?> index, ArrayList<Integer> idx, SQLTerm[] arrSQLTerms) {
        Object[] min = new Object[3];
        Object[] max = new Object[3];

        for (int i : idx) {
            Object[] minmax = prepareMinMax(arrSQLTerms[i]._objValue, arrSQLTerms[i]._strOperator);
            min[i] = minmax[0];
            max[i] = minmax[1];
        }


        return new OctreeBounds(min[0], min[1], min[2], max[0], max[1], max[2]);
    }

    private static Object[] prepareMinMax(Object val, String operator) {

        Object[] minMax = new Object[2]; //0 for min// 1 for max
        switch (operator) {
            case EQUAL: minMax[0] = val; minMax[1] = val; break;
            case GREATER_THAN: minMax[0] = ((Integer) val + 1); minMax[1] = Integer.MAX_VALUE; break;
            case LESS_THAN: minMax[1] = ((Integer) val - 1); minMax[0] = Integer.MIN_VALUE; break;
            case GREATER_THAN_OR_EQUAL: minMax[0] = val; minMax[1] = Integer.MAX_VALUE; break;
            case LESS_THAN_OR_EQUAL: minMax[1] = val; minMax[0] = Integer.MIN_VALUE; break;
            // SHOULD TO BE CHECKED
            case NOT_EQUAL: minMax[0] = Integer.MIN_VALUE; minMax[1] = Integer.MAX_VALUE;
        }
        return minMax;
    }


    public static Vector<Tuple> selectFromTableHelper(String strTableName, Hashtable<String, Object> colNameValue, String operator) throws DBAppException {
        Table table = Serializer.deserializeTable(strTableName);
        return table.select(colNameValue, operator);
    }

    public static Vector<Tuple> applyArrOperators(Vector<Vector<Tuple>> selections, String[] strarrOperators) {

        Vector<Tuple> result = new Vector<>();
        Vector<Vector<Tuple>> tmp = new Vector<>();
        int idx = 0;

        for (Vector<Tuple> tuplesVector : selections) {
            tmp.add(tuplesVector);
            if (tmp.size() == 2) {
                Vector<Tuple> firstSet = tmp.remove(0);
                Vector<Tuple> secondSet = tmp.remove(0);
                tmp.add(Selector.selectOperation(firstSet, secondSet, strarrOperators[idx++]));
            }
        }
        result = tmp.remove(0);

        return result;
    }
}