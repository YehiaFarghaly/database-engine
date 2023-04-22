package constants;

public final class Constants {
     public static final String ERROR_MESSAGE_TABLE_NAME = "Invalid table name, please enter a correct one";
     
     public static final String ERROR_MESSAGE_REPEATED_TABLE_NAME = "Table name already exists, please enter another one";

     public static final String ERROR_MESSAGE_TUPLE_DATA = "Can't insert this tuple, please insert a valid data";
     
     public static final String ERROR_MESSAGE_SEARCH_NOT_FOUND = "Tuple is not found in the table";

     public static final  String ERROR_BINARY_SEARCH_ON_EMPTY_TABLE = "Can not apply binary search on empty Table";
     
     public static final String ERROR_MESSAGE_MIN_OR_MAX_NOT_VALID = "Min or Max values are Invalid, please enter another one";
     
     public static final String ERROR_MESSAGE_INVALID_CLUSTERINGKEY = "Clusteringkey is invalid, please enter another one";

     public static final String DATA_EXTENSTION = ".ser";

     public static final String METADATA_PATH = "Metadata//metadata.csv";

     public static final String ERROR_MESSAGE_DATATYPE = "Data Type is not supported";
     public static final String DATE_FORMATE = "yyyy-MM-dd";
     public static final String INTEGER_DATA_TYPE_NAME = "java.lang.Integer";

     public static final String DOUBLE_DATA_TYPE_NAME = "java.lang.Double";

     public static final String STRING_DATA_TYPE_NAME = "java.lang.String";

     public static final String DATE_DATA_TYPE_NAME = "java.util.Date";


     public static final int COLUMN_NAME_INDEX = 1;

     public static final int COLUMN_TYPE_INDEX = 2;
     public static final int PRIMARY_KEY_INDEX = 3;
     public static final int INDEX_NAME_INDEX = 4;

     public static final int INDEX_TYPE_INDEX = 5;
     
     public static final String ID = "id";
     public static final String NAME = "name";
     public static final String AGE = "age";
     
     public static final String MIN_ID_VALUE="0";
     public static final String MIN_AGE_VALUE="1";
     public static final String MIN_NAME_VALUE="1";
     
     public static final String MAX_ID_VALUE="100000";
     public static final String MAX_AGE_VALUE="100";
     public static final String MAX_NAME_VALUE="20";
     
     public static final String MAX_ROWS_IN_PAGE = "MaximumRowsCountinTablePage";

	public static final String CONFIG_PATH = "DBApp.config";


}