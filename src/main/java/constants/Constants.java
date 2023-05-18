package constants;

public final class Constants {
	public static final String ERROR_MESSAGE_TABLE_NAME = "Invalid table name, please enter a correct one";

	public static final String ERROR_MESSAGE_REPEATED_TABLE_NAME = "Table name already exists, please enter another one";

	public static final String ERROR_MESSAGE_TUPLE_DATA = "The input row contains invalid data, please insert a valid one";

	public static final String ERROR_MESSAGE_SEARCH_NOT_FOUND = "Tuple is not found in the table";

	public static final String ERROR_MESSAGE_PK_IS_ALREADY_FOUND = "The primary key is already insearted, please enter unique one";

	public static final String ERROR_MESSAGE_PK_IS_NOT_FOUND = "The primary key is not found, please primary key";

	public static final String ERROR_BINARY_SEARCH_ON_EMPTY_TABLE = "Can not apply binary search on empty Table";

	public static final String ERROR_MESSAGE_MIN_OR_MAX_NOT_VALID = "Min or Max values are Invalid, please enter another one";

	public static final String ERROR_MESSAGE_INVALID_CLUSTERINGKEY = "Clusteringkey is invalid, please enter another one";

	public static final String ERROR_MESSAGE_COLUMNS_NOT_FOUND_IN_TABLE = "The Tuple contain some columns that "
			+ "is not in the table, please enter columns in the table";

	public static final String ERROR_MESSAGE_IN_DATA_TYPES = "The Tuple entered data doesn't match the table coulmns data type";

	public static final String ERROR_MESSAGE_DOESNOT_CONTAIN_ALL_MIN_MAX_COLUMNS = "The Min or Max doesn't contain all the columns in the table,"
			+ " please enter all the columns of Min and Max the same as the table";

	public static final String ERROR_MESSAGE_IN_TUPLE_SIZE = "The Tuple contain more columns than the table columns";

	public static final String ERROR_MESSAGE_IN_INDEX_SIZE = "The index should be created on 3 columns so enter 3 columns";

	public static final String ERROR_MESSAGE_INDEX_FOUND = "The index already was created in one of the columns, please select another columns";

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

	public static final int COL_MIN_VALUE_INDEX = 6;

	public static final int COL_MAX_VALUE_INDEX = 7;

	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String AGE = "age";

	public static final String MIN_ID_VALUE = "0";
	public static final String MIN_AGE_VALUE = "1";
	public static final String MIN_NAME_VALUE = "aaaaa";

	public static final String MAX_ID_VALUE = "10000";
	public static final String MAX_AGE_VALUE = "100";
	public static final String MAX_NAME_VALUE = "zzzzz";

	public static final String MAX_ROWS_IN_PAGE = "MaximumRowsCountinTablePage";
	public static final String MAX_ENTRIES_IN_OCTREENODE = "MaximumEntriesinOctreeNode";

	public static final String CONFIG_PATH = "DBApp.config";

	public static final String HEADER_COLOR = "#2C3E50";

	public static final String BUTTON_STYLE = "-fx-background-color: " + HEADER_COLOR
			+ " ; -fx-text-fill: white; -fx-font-size: 16px;";

	public static final String BACKGROUND_COLOR = "#262b30";

	public static final String QUERY_BOX_STYLE = "-fx-background-color: " + HEADER_COLOR
			+ "; -fx-control-inner-background:#000000; -fx-text-fill: #4CAF50;";

	public static final String QUERY_LABEL = "Write your SQL query:";

	public static final int DEFAULT_PADDING = 10;

	public static final String TITLE_LABEL = "GUC SQL Server";

	public static final String TITLE_FONT = "Arial";
	public static final int TITLE_FONT_SIZE = 30;

	public static final String EXECUTE_BUTTON_LABEL = "Execute";

	public static final String TABLE_BUTTON_LABEL = "View existing tables";

	public static final double SCENE_WIDTH = 900;

	public static final double SCENE_HEIGHT = 650;

	public static final String EQUAL = "=";
	public static final String GREATER_THAN_OR_EQUAL = ">=";
	public static final String GREATER_THAN = ">";
	public static final String LESS_THAN_OR_EQUAL = "<=";
	public static final String LESS_THAN = "<";
	public static final String NOT_EQUAL = "!=";

	public static final String AND_OPERATION = "and";
	public static final String OR_OPERATION = "or";
	public static final String XOR_OPERATION = "xor";

	public static final String ERROR_MESSAGE_TOO_MUCH_OPERATOS = "Number of  Operators must be = SQLTERMS - 1";

	public static final String ERROR_MESSAGE_UNKNOWN_ARR_OPERATOR = "The only allowed array operators are AND, OR and XOR";

	public static final String ERROR_MESSAGE_UNKNOWN_OPERATOR = "The only allowed operators are =, >, <, >=, <=, and !=";

	public static final int NUM_OF_DIMENSIONS = 3;

	public static final int NUMBER_OF_NODE_CHILDREN = 8;

	public static final int ASCII_OF_FIRST_ALPHAPET = 97;

	public static final int NUM_OF_ALPHAPET = 26;

}