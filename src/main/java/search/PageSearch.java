package search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import dataManipulation.csvReader;
import storage.Cell;
import storage.Page;
import storage.Table;
import storage.Tuple;

import static Serializerium.Serializer.deserializeTable;

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

    public int binarySearch(String value) {
        //binary search in only done on PK column
        //returns
        // positive -> (index of wanted value )
        // negative -> (  -(index) where the element should be inserted )
        int low = 0, high = page.getSize();

        while (low <= high) {

            int mid = low + (high - low) / 2;

            Tuple currTuple = page.getTuples().get(mid);

            Object PKValueOfCurrTuple = getValueOfColInTuple(currTuple, this.PKColName);

            int comp = getComparisonResult(PKColType, PKValueOfCurrTuple, value);

            if (comp == 0)
                return mid;
            else if (comp < 0) {
                low = mid + 1;
            } else
                high = mid - 1;

        }
        return -(high + 1); // or low
    }

    public HashMap<Tuple, Integer> linearSearch(String colName, String value) {
        setColType(colName);
        HashMap<Tuple, Integer> results = new HashMap<Tuple,Integer>();
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
            if (curCol[3].toLowerCase().equals("true"))
                PKColName = curCol[1];

            if (curCol[1].equals(colName)) {
                colNum = (i);

                colType = (curCol[2]);

                if (curCol[3].toLowerCase().equals("true"))
                    isPK = (true);
                if (!curCol[4].toLowerCase().equals("null"))
                    hasIndex = (true);

                if (hasIndex) {
                    indexName = (curCol[4]);
                    indexType = (curCol[5]);
                }
                break;
            }

            i++;
        }
    }
    private boolean setColType(String colName) {
        ArrayList<String[]> tableCol = new csvReader().readTable(page.getTableName());
        for (String curCol[] : tableCol) {
            if (curCol[1].equals(colName)) {
                this.colType = (curCol[2]);
                return true;
            }
        }
        return false;
    }

    private int getComparisonResult(String colType, Object currValue, String value) {
        return new Compare().compareTo(PKColType, currValue, value);
    }

    private boolean setPKColNameType() {
        ArrayList<String[]> tableCol = new csvReader().readTable(page.getTableName());
        for (String curCol[] : tableCol) {
            if (curCol[3].toLowerCase().equals("true")) {

                PKColName = curCol[1];
                PKColType = curCol[2];
                return true;
            }

//        Table table = deserializeTable(page.getTableName());
//        PKColName = table.getPKColumn();
        }
        return false;
    }


    Object getValueOfColInTuple(Tuple currTuple, String colName) {
        //search for the value of colName in the cells of the tuple
        for (Cell currCellInTuple : currTuple.getCells())
            if (currCellInTuple.getKey().equals(colName))
                return currCellInTuple.getValue();
        return null;
    }
}