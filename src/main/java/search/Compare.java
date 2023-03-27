package search;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Compare {

    public Compare(){

    }
    Integer compareTo(String colType, Object cellValue , String value) {

        switch (colType.toLowerCase()){
            case "java.lang.integer": return intCompare(cellValue,value);
            case "java.lang.string":return stringCompare(cellValue,value);
            case "java.lang.double":return doubleCompare(cellValue,value);
            case "java.util.date":return dateCompare(cellValue,value);
        }

        return null;
    }

    private int dateCompare(Object cellValue, String value)  {

        Date d1= (Date) cellValue;
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Date d2 = null;
        try {
            d2 = sdformat.parse(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return d1.compareTo(d2);
        //0 equal
        //+ d1> d2
        //- d1 < d2
    }

    private int doubleCompare(Object cellValue, String value) {

        Double d1 = (Double) cellValue;
        Double d2 = Double.parseDouble(value);
        return d1.compareTo(d2);
    }

    private int stringCompare(Object cellValue, String value) {
        String d1 = (String) cellValue;
        return d1.compareTo(value);
    }

    private int intCompare(Object cellValue, String value) {
        Integer d1 = (Integer) cellValue;
        Integer d2 = Integer.parseInt(value);
        return d1.compareTo(d2);
    }
}