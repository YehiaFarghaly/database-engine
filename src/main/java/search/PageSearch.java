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
        this.setPage(page);
    }

    private void collectInfo(String colName, String value) {

        ArrayList<String[]> tableCol = new csvReader().readTable(getPage().getTableName());
        int i = 0;
        for (String curCol[] : tableCol) {
            if (curCol[1].equals(colName)) {
                setColNum(i);

                setColType(curCol[2]);

                if (curCol[3].toLowerCase().equals("true"))
                    setPK(true);
                if (!curCol[4].toLowerCase().equals("null"))
                    setHasIndex(true);

                if (isHasIndex()) {
                    setIndexName(curCol[4]);
                    setIndexType(curCol[5]);
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
        if (this.getColName() == null || !this.getColName().equals(colName))
            collectInfo(colName, value);

        if (isHasIndex()) {

        } else if (isPK()) {
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
        int mid = 0, low = 0, high = getPage().getSize();
        Tuple curTuple = null;
        Vector<Tuple> rows = getPage().getTuples();
        while (low <= high) {
            mid = low + (high - low) / 2;
            curTuple = rows.get(mid);
            Cell curCel = curTuple.getCells().get(getColNum());
            int compVal = new Compare().compareTo(getColType(), curCel.getValue(), value);

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
        for (int i = idx; i< getPage().getSize(); i++) {
            Tuple curTuple = getPage().getTuples().get(i);
            if (isToBeAdded(curTuple.getCells().get(getColNum()), value, condition)) {
                results.add(curTuple);
            } else
                break;

        }
        return results;
    }

    private Vector<Tuple> searchLeft(int idx, Condition condition, String value) {
        Vector<Tuple> results = new Vector<Tuple>();
        for (int i = idx; i > -1; i--) {
            Tuple curTuple = getPage().getTuples().get(i);
            if (isToBeAdded(curTuple.getCells().get(getColNum()), value, condition)) {
                results.add(curTuple);
            } else
                break;

        }
        return results;
    }



    private Vector<Tuple> linearSearch(String colName, String value, Condition condition1, Condition condition2) throws IOException{

        Vector<Tuple> results = new Vector<Tuple>();
        int colNum = getColNumber(colName);
        for (Tuple curTuple : getPage().getTuples()) {
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
                isToBeAdded = (new Compare().compareTo(getColType(), curCel.getValue(), value) == 0);
                break;
            case notEqual:
                isToBeAdded = (new Compare().compareTo(getColType(), curCel.getValue(), value) != 0);
                break;
            case lessThan:
                isToBeAdded = (new Compare().compareTo(getColType(), curCel.getValue(), value) < 0);
                break;
            case greaterThan:
                isToBeAdded = (new Compare().compareTo(getColType(), curCel.getValue(), value) > 0);
                break;

        }
        return isToBeAdded;
    }

    private Page getPage() {
        return page;
    }

    private void setPage(Page page) {
        this.page = page;
    }

    private boolean isPK() {
        return isPK;
    }

    private void setPK(boolean PK) {
        isPK = PK;
    }

    private boolean isHasIndex() {
        return hasIndex;
    }

    private void setHasIndex(boolean hasIndex) {
        this.hasIndex = hasIndex;
    }

    private String getIndexName() {
        return indexName;
    }

    private void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    private String getIndexType() {
        return indexType;
    }

    private void setIndexType(String indexType) {
        this.indexType = indexType;
    }

    private String getColName() {
        return colName;
    }

    private void setColName(String colName) {
        this.colName = colName;
    }

    private String getColType() {
        return colType;
    }

    private void setColType(String colType) {
        this.colType = colType;
    }

    private int getColNum() {
        return colNum;
    }

    private void setColNum(int colNum) {
        this.colNum = colNum;
    }
}