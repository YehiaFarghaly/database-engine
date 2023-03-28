package search;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import exceptions.DBAppException;
import org.apache.commons.collections.functors.EqualPredicate;
import storage.Page;
import storage.Table;
import storage.Tuple;

import static Serializerium.Serializer.deserializePage;
import static constants.Constants.*;
public class TableSearch {

    public HashMap<String, HashMap<Tuple, Integer>> linearSearch(Table table, String colName, String value) throws IOException, ClassNotFoundException, DBAppException, ParseException {
        //hasMap <pageName,<Tuple,index>>
        HashMap<String, HashMap<Tuple, Integer>> results = new HashMap<>();
        for (String pageName : table.getPagesName()) {
            Page currPage = deserializePage(pageName);
            results.put(pageName, currPage.linearSearch(colName, value));
        }
        return results;
    }
    public  int getPagePosition(Table table ,String value) throws DBAppException, ParseException, IOException, ClassNotFoundException {
        int pagesCount = table.getPagesName().size();
        int pageIndex = binarySearchPages(table, value);
        if (pageIndex >= pagesCount)
            pageIndex = pagesCount - 1;
        else if (pageIndex < 0)
            pageIndex = 0;
        return pageIndex;
    }
    private int binarySearchPages(Table table, String value) throws DBAppException, ParseException, IOException, ClassNotFoundException {

        String PKColType = table.getColNameType().get(table.getPKColumn());
        HashMap<String, Integer> result = new HashMap<>();
        int low = 0, high = table.getPagesName().size() - 1;
        int mid = -1;
        while (low <= high) {

            mid = low + (high - low) / 2;

            Page currPage = deserializePage(table.getPagesName().get(mid));

            int compWithMax = getComparisonResult(PKColType, currPage.getMaxPK(), value);

            int compWithMin = getComparisonResult(PKColType, currPage.getMinPK(), value);

            if (compWithMax >= EQUAL && compWithMin <= EQUAL) {
                return mid;
            } else if (compWithMax == LESS_THAN)
                low = mid + 1;
            else
                high = mid - 1;

        }
        return low;
    }

    public HashMap<String, Integer> binarySearch(Table table, String value) throws IOException, ClassNotFoundException, DBAppException, ParseException {
        //hashMap <pageName,index>

        int pagesCount = table.getPagesName().size();

        if (pagesCount < 1)
            throw new DBAppException(ERROR_BINARY_SEARCH_ON_EMPTY_TABLE);

        HashMap<String, Integer> result = new HashMap<>();

        int pageIndex = getPagePosition(table, value);

        Page currPage = deserializePage(table.getPagesName().get(pageIndex));

        int rowIdx = currPage.binarySearch(value);

        result.put(currPage.getName(), rowIdx);

        return result;
    }

    private int getComparisonResult(String colType, Object currValue, String value) throws DBAppException, ParseException {
        return new Compare().compareValue(colType, currValue, value);
    }

}



