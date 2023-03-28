package search;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import static constants.Constants.*;
import dataManipulation.csvReader;
import exceptions.DBAppException;
import storage.Cell;
import storage.Page;
import storage.Tuple;

public class PageSearch {

    private Page page;
    private boolean isPK = false;
    private boolean hasIndex = false;
    private String indexName = null;
    private String indexType = null;

    private String colName = null;
    private String colType = null;
    private int colNum = 0;
    private String PKColName = null;
    private String PKColType = null;


    public PageSearch(Page page) {
        this.page = page;
    }

    public int binarySearch(String value) throws DBAppException, ParseException {
        //binary search in only done on PK column
        //returns
        // positive -> (index of wanted value )
        // negative -> (  -(index) where the element should be inserted )

        int low = 0, high = page.getSize() - 1;
        while (low <= high) {

            int mid = low + (high - low) / 2;

            Tuple currTuple = page.getTuples().get(mid);

            Object PKValueOfCurrTuple = getValueOfColInTuple(currTuple, this.PKColName);

            int comp = getComparisonResult(PKColType, PKValueOfCurrTuple, value);

            if (comp == EQUAL)
                return mid;
            else if (comp == LESS_THAN)
                low = mid + 1;
            else
                high = mid - 1;

        }
        return -(high + 1); // or low
    }

    public HashMap<Tuple, Integer> linearSearch(String colName, String value) throws DBAppException, ParseException {
        setColType(colName);
        HashMap<Tuple, Integer> results = new HashMap<Tuple, Integer>();
        int i = 0;
        for (Tuple currTuple : page.getTuples()) {

            Object currValue = getValueOfColInTuple(currTuple, colName);

            int comp = getComparisonResult(colType, currValue, value);

            if (comp == 0)
                results.put(currTuple, i);


            i++;
        }
        return results;
    }

    private void collectAllInfo(String colName) {

        ArrayList<String[]> tableCol = new csvReader().readTable(page.getTableName());
        int i = 0;
        for (String curCol[] : tableCol) {
            if (curCol[PRIMARY_KEY_INDEX].toLowerCase().equals("true"))
                PKColName = curCol[COLUMN_NAME_INDEX];

            if (curCol[COLUMN_NAME_INDEX].equals(colName)) {
                colNum = i;
                colType = curCol[COLUMN_TYPE_INDEX];
                if (curCol[PRIMARY_KEY_INDEX].toLowerCase().equals("true"))
                    isPK = true;
                if (!curCol[INDEX_NAME_INDEX].toLowerCase().equals("null"))
                    hasIndex = true;

                if (hasIndex) {
                    indexName = curCol[INDEX_NAME_INDEX];
                    indexType = curCol[INDEX_TYPE_INDEX];
                }
                break;
            }

            i++;
        }
    }

    private boolean setColType(String colName) {
        ArrayList<String[]> tableCol = new csvReader().readTable(page.getTableName());
        for (String curCol[] : tableCol) {
            if (curCol[COLUMN_NAME_INDEX].equals(colName)) {
                this.colType = (curCol[COLUMN_TYPE_INDEX]);
                return true;
            }
        }
        return false;
    }

    private int getComparisonResult(String colType, Object currValue, String value) throws DBAppException, ParseException {
        return new Compare().compareValue(colType, currValue, value);
    }

    private boolean setPKColNameType() {
        ArrayList<String[]> tableCol = new csvReader().readTable(page.getTableName());
        for (String curCol[] : tableCol) {
            if (curCol[PRIMARY_KEY_INDEX].toLowerCase().equals("true")) {

                PKColName = curCol[COLUMN_NAME_INDEX];
                PKColType = curCol[COLUMN_TYPE_INDEX];
                return true;
            }

//        Table table = deserializeTable(page.getTableName());
//        PKColName = table.getPKColumn();
        }
        return false;
    }

    Object getValueOfColInTuple(Tuple currTuple, String colName) {
        //search for the value of colName in the cells of the tuple
        Object ret = null;
        for (Cell currCellInTuple : currTuple.getCells())
            if (currCellInTuple.getKey().equals(colName)) {
                ret = currCellInTuple.getValue();
                break;
            }
        return ret;
    }
}