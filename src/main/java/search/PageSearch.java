package search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;


import storage.Cell;
import storage.Page;
import storage.Tuple;
import dataManipulation.csvReader;

import static Serializerium.Serializer.deserializePage;

enum Condition {
    equal,
    notEqual,
    greaterThan,
    lessThan
}
public class PageSearch {

    Page page;
    boolean isPK = false;
    boolean hasIndex = false;
    String indexName = null;
    String indexType = null;
    String colName = null;

    String colType = null;

    int colNum = 0;

    public PageSearch(Page page) {
        this.page = page;


    }

    private void collectInfo(String colName, String value) {

        ArrayList<String[]> tableCol = new csvReader().readTable(page.getTableName());
        int i = 0;
        for (String curCol[] : tableCol) {
            if (curCol[1].equals(colName)) {
                colNum = i;

                colType = curCol[2];

                if (curCol[3].toLowerCase().equals("true"))
                    isPK = true;
                if (!curCol[4].toLowerCase().equals("null"))
                    hasIndex = true;

                if (hasIndex) {
                    indexName = curCol[4];
                    indexType = curCol[5];
                }
                break;
            }

            i++;
        }
    }

    public Vector<Tuple> search(String colName, String value) {
        //validator.valid
        Vector<Tuple> results = new Vector<Tuple>();
        //the next if condition may not work if a column info of a table has changed
        //we can solve it by adding time of last updates on a table these updates are [add/remove index] in a log file
        if (this.colName == null || !this.colName.equals(colName))
            collectInfo(colName, value);

        if (hasIndex) {

        } else if (isPK) {


            binarySearch(colName, value, Condition.equal, null);
        } else {
            try {
                results =  linearSearch(colName, value, Condition.equal, null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return results;
    }

    private Vector<Tuple> binarySearch(String colName, String value, Condition condition1, Condition condition2) {
        Vector<Tuple> results = new Vector<Tuple>();


        return  results;
    }

    private Vector<Tuple> linearSearch(String colName, String value, Condition condition1, Condition condition2) throws IOException{

        Vector<Tuple> results = new Vector<Tuple>();
        int colNum = getColNumber(colName);
        for (Tuple curTuple : page.getTuples()) {
            Cell curCel = curTuple.getCells().get(colNum);
            boolean isToBeAdded = false;
            if (condition1 != null)
                isToBeAdded = isToBeAdded( curCel, value, condition1);

            if (condition2 != null && !isToBeAdded) {
                isToBeAdded = isToBeAdded( curCel,value, condition2);
            }
            if (isToBeAdded)
                results.add(curTuple);

        }
        return results;
    }

    private boolean isToBeAdded(Cell curCel,String value, Condition condition) {
        boolean isToBeAdded =false;
        switch (condition){
            case equal:
                isToBeAdded = (new Compare().compareTo(colType, curCel.getValue(), value) == 0);
                break;
            case notEqual:
                isToBeAdded = (new Compare().compareTo(colType, curCel.getValue(), value) != 0);
                break;
            case lessThan:
                isToBeAdded = (new Compare().compareTo(colType, curCel.getValue(), value) < 0);
                break;
            case greaterThan:
                isToBeAdded = (new Compare().compareTo(colType, curCel.getValue(), value) > 0);
                break;

        }
        return isToBeAdded;
    }

    public Vector<Tuple> searchGreaterThan(String colName, String value) {

        return new Vector<Tuple>();
    }

    public Vector<Tuple> searchGreaterThanOrEqual(String colName, String value) {

        return new Vector<Tuple>();
    }

    public Vector<Tuple> searchLessThan(String colName, String value) {
        return new Vector<Tuple>();
    }

    public Vector<Tuple> searchLessThanOrEqual(String colName, String value) {
        return new Vector<Tuple>();
    }

    public Vector<Tuple> searchNotEqual(String colName, String value) {
        return new Vector<Tuple>();
    }

    private int getColNumber(String colName) {
        return 0;
    }

}