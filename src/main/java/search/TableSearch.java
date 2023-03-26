package search;

import java.io.IOException;
import java.util.*;

import storage.Page;
import storage.Table;
import storage.Tuple;
import Serializerium.Serializer;

public class TableSearch {
    public static Vector<Tuple> search(Table table, String colName, String value) throws IOException, ClassNotFoundException {
        Vector<Tuple> results = new Vector<Tuple>();

        if (!(table.getColNameMin().get(colName).compareTo(value) <= 0
                && table.getColNameMax().get(colName).compareTo(value) >= 0))
            return results;

        for (String pageName : table.getPagesName()) {
            Page page = Serializer.deserializePage(pageName);

            if (colName.equals(table.getPKColumn())) {

                Compare comp = new Compare();
                String type = table.getColNameType().get(table.getPKColumn());
                //check if page contains the wanted value in pk col
                if (!(comp.compareTo(type, page.getMinPK(), value) <= 0 &&
                        comp.compareTo(type, page.getMaxPK(), value) >= 0)) continue;
            }

            Vector<Tuple> temp = page.search(colName, value);
            results.addAll(temp);
                //if pk col and the value was found then return
            if (temp.size() > 0 && colName.equals(table.getPKColumn())) break;
        }
        return results;
    }

    public static Vector<Tuple> searchGreaterThan(Table table, String colName, String value) throws IOException, ClassNotFoundException {

        Vector<Tuple> results = new Vector<Tuple>();
      //check if the table contains the wanted value
        if (table.getColNameMax().get(colName).compareTo(value) <= 0)
            return results;
        for (String pageName : table.getPagesName()) {
            Page page = Serializer.deserializePage(pageName);

            results.addAll(page.searchGreaterThan(colName, value));
        }
        return results;
    }


    public static Vector<Tuple> searchGreaterThanOrEqual(Table table, String colName, String value) throws IOException, ClassNotFoundException {

        Vector<Tuple> results = new Vector<Tuple>();
        //check if the table contains the wanted value

        String maxValueInCol = table.getColNameMax().get(colName);
        if (maxValueInCol.compareTo(value) < 0)
            return results;

        for (String pageName : table.getPagesName()) {

            Page page = Serializer.deserializePage(pageName);
            results.addAll(page.searchGreaterThanOrEqual(colName, value));

        }

        return results;
    }

    public static Vector<Tuple> searchLessThan(Table table, String colName, String value) throws IOException, ClassNotFoundException {

        Vector<Tuple> results = new Vector<Tuple>();
        //check if the table contains the wanted value

        String minValueInCol = table.getColNameMin().get(colName);
        if (minValueInCol.compareTo(value) >= 0)
            return results;

        for (String pageName : table.getPagesName()) {

            Page page = Serializer.deserializePage(pageName);
            results.addAll(page.searchLessThan(colName, value));

        }
        return results;
    }

    public static Vector<Tuple> searchLessThanOrEqual(Table table, String colName, String value) throws IOException, ClassNotFoundException {

        Vector<Tuple> results = new Vector<Tuple>();
        //check if the table contains the wanted value

        String minValueInCol = table.getColNameMin().get(colName);
        if (minValueInCol.compareTo(value) > 0)
            return results;

        for (String pageName : table.getPagesName()) {
            Page page = Serializer.deserializePage(pageName);
            results.addAll(page.searchLessThanOrEqual(colName, value));
        }

        return results;
    }

    public static Vector<Tuple> searchNotEqual(Table table, String colName, String value) throws IOException, ClassNotFoundException {

        Vector<Tuple> results = new Vector<Tuple>();

        String minValueInCol = table.getColNameMin().get(colName);
        String maxValueInCol = table.getColNameMax().get(colName);
        if (!(minValueInCol.equals(maxValueInCol) && !maxValueInCol.equals(value))) return results;

        for (String pageName : table.getPagesName()) {

            Page page = Serializer.deserializePage(pageName);
            results.addAll(page.searchNotEqual(colName, value));

        }
        return results;
    }

    static Tuple searchForUpdate(Table table, String value) throws IOException, ClassNotFoundException {
        //String value is value of pk to binary search with
        Tuple result = null;
        for (String pageName : table.getPagesName()) {

            Page page = Serializer.deserializePage(pageName);
            Compare comp = new Compare();
            String type = table.getColNameType().get(table.getPKColumn());

            if (comp.compareTo(type, page.getMinPK(), value) <= 0 &&
                    comp.compareTo(type, page.getMaxPK(), value) >= 0) {
                Vector<Tuple> ret = page.search(table.getPKColumn(), value);

                if (ret.size() > 0)
                    return ret.get(0);

            }
        }
        return result;
    }
}