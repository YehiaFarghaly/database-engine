package search;

import java.io.IOException;
import java.util.*;

import storage.Page;
import storage.Table;
import storage.Tuple;

import static Serializerium.Serializer.deserializePage;

public class TableSearch {

    public HashMap<String ,HashMap<Tuple, Integer>> linearSearch(Table table ,String colName, String value) throws IOException, ClassNotFoundException {
        //hasMap <pageName,<Tuple,index>>
        HashMap<String, HashMap<Tuple, Integer>> results = new HashMap<>();
        for (String pageName : table.getPagesName()) {
            Page currPage = deserializePage(pageName);
            results.put(pageName, currPage.linearSearch(colName, value));
        }
        return results;
    }
    public HashMap<String , Integer> binarySearch(Table table , String value) throws IOException, ClassNotFoundException {
        //hashMap <pageName,index>
        HashMap<String, Integer> result = new HashMap<>();
        for (String pageName : table.getPagesName()) {
            Page currPage = deserializePage(pageName);
            int idx = currPage.binarySearch(value);
            if (!currPage.isFull()) {
                result.put(pageName, idx);
                break;
            }
        }
        return result;
    }




}
