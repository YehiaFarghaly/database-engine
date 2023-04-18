package search;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import datamanipulation.CsvReader;

import static constants.Constants.*;

import exceptions.DBAppException;
import storage.Cell;
import storage.Page;
import storage.Tuple;

public class PageSearch {


    public static int binarySearch(Page page,Object primaryKey) throws DBAppException, ParseException {

        int low = 0;
        int high = page.getSize() - 1;
        
        while (low <= high) {

            int mid = low + (high - low) / 2;

            Tuple currTuple = page.getTuples().get(mid);

            Object PKValueOfCurrTuple = currTuple.getPrimaryKey();

            int comp = Compare.compare(primaryKey.toString(),PKValueOfCurrTuple.toString());

            if (comp == 0)
                return mid;
            else if (comp > 0)
                low = mid + 1;
            else
                high = mid - 1;

        }
        
        return low; 
    }

    public static Vector<Tuple> linearSearch(Page page,String colName, Object value) throws DBAppException, ParseException {
    	
        Vector<Tuple> results = new Vector<Tuple>();
        
        
        for (Tuple currTuple : page.getTuples()) {

            Object currValue = getValueOfColInTuple(currTuple, colName);

            int comp = Compare.compare(currValue, value);

            if (comp == 0)
                results.add(currTuple);

        }
        
        return results;
    }



    static Object getValueOfColInTuple(Tuple currTuple, String colName) {
        Object ret = null;
        for (Cell currCellInTuple : currTuple.getCells())
            if (currCellInTuple.getKey().equals(colName)) {
                ret = currCellInTuple.getValue();
                break;
            }
        return ret;
    }
}