package search;

import java.io.IOException;
import java.util.*;

import storage.Page;
import storage.Table;
import storage.Tuple;
import Serializerium.Serializer;

public class TableSearch {
    public static Vector<Tuple> search(Table table, String colName, String value) {
        Vector<Tuple> results = new Vector<Tuple>();
        for (String pageName : table.getPagesName()) {
            try {
                Page page = Serializer.deserializePage(pageName);
                results.addAll(page.search(colName,value));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return results;
    }

    public static Vector<Tuple> searchGreaterThan(Table table, String colName, String value) {

            Vector<Tuple> results = new Vector<Tuple>();
            for (String pageName : table.getPagesName()) {
                try {
                    Page page = Serializer.deserializePage(pageName);
                    results.addAll(page.searchGreaterThan(colName,value));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }

            return results;
        }


    public static Vector<Tuple> searchGreaterThanOrEqual(Table table, String colName, String value) {

        Vector<Tuple> results = new Vector<Tuple>();
        for (String pageName : table.getPagesName()) {
            try {
                Page page = Serializer.deserializePage(pageName);
                results.addAll(page.searchGreaterThanOrEqual(colName,value));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return results;
    }

    public static Vector<Tuple> searchLessThan(Table table, String colName, String value) {

        Vector<Tuple> results = new Vector<Tuple>();
        for (String pageName : table.getPagesName()) {
            try {
                Page page = Serializer.deserializePage(pageName);
                results.addAll(page.searchLessThan(colName,value));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return results;
    }

    public static Vector<Tuple> searchLessThanOrEqual(Table table, String colName, String value) {

        Vector<Tuple> results = new Vector<Tuple>();
        for (String pageName : table.getPagesName()) {
            try {
                Page page = Serializer.deserializePage(pageName);
                results.addAll(page.searchLessThanOrEqual(colName,value));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return results;
    }

    public static Vector<Tuple> searchNotEqual(Table table, String colName, String value) {

        Vector<Tuple> results = new Vector<Tuple>();
        for (String pageName : table.getPagesName()) {
            try {
                Page page = Serializer.deserializePage(pageName);
                results.addAll(page.searchNotEqual(colName,value));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return results;
    }

}