package search;

import java.io.IOException;
import java.util.*;

import Serializerium.Serializer;
import storage.Page;
import storage.Table;
import storage.Tuple;

public class TableSearch {
	
	public static HashMap<String ,HashMap<Tuple, Integer>> linearSearch(Table table ,String colName, String value) {
		return null;
    }
	
    public static Vector<Tuple> search(Table table, String colName, String value) {

        return new Vector<Tuple>();
    }

    public static Vector<Tuple> searchGreaterThan(Table table, String colName, String value) {

        return new Vector<Tuple>();
    }

    public static Vector<Tuple> searchGreaterThanOrEqual(Table table, String colName, String value) {

        return new Vector<Tuple>();
    }

    public static Vector<Tuple> searchLessThan(Table table, String colName, String value) {
        return new Vector<Tuple>();
    }

    public static Vector<Tuple> searchLessThanOrEqual(Table table, String colName, String value) {
        return new Vector<Tuple>();
    }

    public static Vector<Tuple> searchNotEqual(Table table, String colName, String value) {
        return new Vector<Tuple>();
    }

    private int getColNumber(Table table, String colName) {
        return 0;
    }

}