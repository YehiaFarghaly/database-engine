package search;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Vector;

import exceptions.DBAppException;
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
    
    public static Vector<Tuple> search(Page page,String colName, String value) {

        return new Vector<Tuple>();
    }

    public static Vector<Tuple> searchGreaterThan(Page page,String colName, String value) {

        return new Vector<Tuple>();
    }

    public static Vector<Tuple> searchGreaterThanOrEqual(Page page,String colName, String value) {

        return new Vector<Tuple>();
    }

    public static Vector<Tuple> searchLessThan(Page page,String colName, String value) {
        return new Vector<Tuple>();
    }

    public static Vector<Tuple> searchLessThanOrEqual(Page page,String colName, String value) {
        return new Vector<Tuple>();
    }

    public static Vector<Tuple> searchNotEqual(Page page,String colName, String value) {
        return new Vector<Tuple>();
    }
    
    public HashMap<Tuple, Integer> linearSearch(String colName, String value) throws DBAppException, ParseException {
        return null;
    }

    private int getColNumber(Page page , String colName) {
        return 0;
    }

}