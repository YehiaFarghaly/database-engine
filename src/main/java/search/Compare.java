package search;

import constants.Constants;
import exceptions.DBAppException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static constants.Constants.*;

public class Compare {

    public Compare() {

    }

    Integer compareValue(String colType, Object cellValue, String value) throws DBAppException, ParseException {

        switch (colType) {
            case INTEGER_DATA_TYPE_NAME:
                return intCompare(cellValue, value);
            case STRING_DATA_TYPE_NAME:
                return stringCompare(cellValue, value);
            case DOUBLE_DATA_TYPE_NAME:
                return doubleCompare(cellValue, value);
            case DATE_DATA_TYPE_NAME:
                return dateCompare(cellValue, value);
        }
        throw new DBAppException(colType + ": " + Constants.ERROR_MESSAGE_DATATYPE);
    }

    private int dateCompare(Object cellValue, String value) throws DBAppException, ParseException {
        Date date1 = (Date) cellValue;
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMATE);
        Date date2 = null;
        date2 = dateFormat.parse(value);
        int comp = date1.compareTo(date2);
        if (comp == 0) return EQUAL;
        if (comp < 0) return LESS_THAN;
        else return GREATER_THAN;

    }


    private int doubleCompare(Object cellValue, String value) {
        Double double1 = (Double) cellValue;
        Double double2 = Double.parseDouble(value);
        int comp = double1.compareTo(double2);
        if (comp == 0) return EQUAL;
        if (comp < 0) return LESS_THAN;
        else return GREATER_THAN;

    }

    private int stringCompare(Object cellValue, String value) {
        String string1 = (String) cellValue;
        int comp = string1.compareTo(value);
        if (comp == 0) return EQUAL;
        if (comp < 0) return LESS_THAN;
        else return GREATER_THAN;

    }
    private int intCompare(Object cellValue, String value) {
        Integer int1 = (Integer) cellValue;
        Integer int2 = Integer.parseInt(value);
        int comp = int1.compareTo(int2);
        if (comp == 0) return EQUAL;
        if (comp < 0) return LESS_THAN;
        else return GREATER_THAN;

    }
}