package search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;


import storage.Cell;
import storage.Page;
import storage.Tuple;
import dataManipulation.csvReader;

enum Condition {
    equal,
    notEqual,
    greaterThan,
    lessThan
}
public class PageSearch {

    private Page page;
    private boolean isPK = false;
    private boolean hasIndex = false;
    private String indexName = null;
    private String indexType = null;
    private String colName = null;

    private String colType = null;

    private int colNum = 0;

    public PageSearch(Page page) {
        this.page=page;
    }

    private void collectInfo(String colName, String value) {

        ArrayList<String[]> tableCol = new csvReader().readTable(page.getTableName());
        int i = 0;
        for (String curCol[] : tableCol) {
            if (curCol[1].equals(colName)) {
                colNum=(i);

                colType=(curCol[2]);

                if (curCol[3].toLowerCase().equals("true"))
                    isPK=(true);
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

    public Vector<Tuple> search(String colName, String value) {
        //validator.valid
        Vector<Tuple> results = new Vector<Tuple>();
        //the next if condition may not work if a column info of a table has changed
        //we can solve it by adding time of last updates on a table these updates are [add/remove index] in a log file
        if (this.colName == null || !this.colName.equals(colName))
            collectInfo(colName, value);

        if (hasIndex) {

        } else if (isPK) {
            int idx = binarySearch(value);

            if(idx!=-1) {

                Vector<Tuple> left = searchLeft(idx, Condition.equal, value);
                Collections.reverse(left);
                 left.addAll(searchRight(idx, Condition.equal, value));
                results =left;
            }

        } else {
            try {
                results = linearSearch(colName, value, Condition.equal, null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return results;
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
    private int binarySearch(String value) {
        int mid = 0, low = 0, high = page.getSize();
        Tuple curTuple = null;
        Vector<Tuple> rows = page.getTuples();
        while (low <= high) {
            mid = low + (high - low) / 2;
            curTuple = rows.get(mid);
            Cell curCel = curTuple.getCells().get(colNum);
            int compVal = new Compare().compareTo(colType, curCel.getValue(), value);

            if (compVal > 0)
                high = mid - 1;
            else if (compVal < 0)
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }
    private Vector<Tuple>  searchRight(int idx, Condition condition, String value) {
        Vector<Tuple> results = new Vector<Tuple>();
        for (int i = idx; i< page.getSize(); i++) {
            Tuple curTuple = page.getTuples().get(i);
            if (isToBeAdded(curTuple.getCells().get(colNum), value, condition)) {
                results.add(curTuple);
            } else
                break;

        }
        return results;
    }

    private Vector<Tuple> searchLeft(int idx, Condition condition, String value) {
        Vector<Tuple> results = new Vector<Tuple>();
        for (int i = idx; i > -1; i--) {
            Tuple curTuple = page.getTuples().get(i);
            if (isToBeAdded(curTuple.getCells().get(colNum), value, condition)) {
                results.add(curTuple);
            } else
                break;

        }
        return results;
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
}