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
    int colNum = 0;

    public PageSearch(Page page) {
        this.page = page;


    }

    private void collectInfo(String colName, String value) {

        ArrayList<String[]> tableCol = new csvReader().readTable(page.getTableName());
        for (String curCol[] : tableCol) {
            if (curCol[1].equals(colName)) {
                if (curCol[3].toLowerCase().equals("true"))
                    isPK = true;
                if (!curCol[4].toLowerCase().equals("null"))
                    hasIndex = true;

                if (hasIndex) {
                    indexName = curCol[4];
                    indexType = curCol[5];
                }
            }

        }
    }

    public Vector<Tuple> search(String colName, String value) {
        //validator.valid

        //the next if condition may not work if a column info of a table has changed
        //we can solve it by adding time of last updates on a table these updates are [add/remove index] in a log file
        if (this.colName == null || !this.colName.equals(colName))
            collectInfo(colName, value);

        if (hasIndex) {

        } else if (isPK) {

        } else {
            //linear search
            try {
                linearSearch(colName, value, Condition.equal, null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return new Vector<Tuple>();
    }

    private Vector<Tuple> linearSearch(String colName, String value, Condition condition1, Condition condition2) throws IOException, ClassNotFoundException {
        Vector<Tuple> results = new Vector<Tuple>();
        //deserializePage(page.getName());
        int colNum = getColNumber(colName);
        for (Tuple curTuple : page.getTuples()) {
            Cell curCel = curTuple.getCells().get(colNum);
            boolean toBeAdded = false;
            if (condition1 != null)
                switch (condition1) {
                    case equal:
                        toBeAdded = curCel.getValue().equals(value);
                        break;
                    case notEqual:
                        toBeAdded = !curCel.getValue().equals(value);
                        break;
                    case lessThan:
                        toBeAdded = curCel.getValue().equals(value);
                        break;
                    case greaterThan:
                        toBeAdded = curCel.getValue().equals(value);
                        break;

                }
            //NOT COMPLETE

            if (condition2 != null && !toBeAdded)
                switch (condition2) {
                    case equal:
                        toBeAdded = curCel.getValue().equals(value);
                        break;
                    case notEqual:
                        toBeAdded = !curCel.getValue().equals(value);
                        break;
                    case lessThan:
                        toBeAdded = curCel.getValue().equals(value);
                        break;
                    case greaterThan:
                        toBeAdded = curCel.getValue().equals(value);
                        break;

                }
            if (toBeAdded) {
                results.add(curTuple);
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

}