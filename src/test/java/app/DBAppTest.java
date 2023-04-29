package app;

import org.junit.jupiter.api.Test;
import com.opencsv.exceptions.CsvValidationException;
import exceptions.DBAppException;
import util.filecontroller.FileDeleter;
import util.filecontroller.FileType;
import util.filecontroller.Serializer;
import storage.Page;
import storage.Table;
import storage.Tuple;
import constants.Constants;
import java.io.IOException;
import java.text.ParseException;
import java.util.Hashtable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DBAppTest {
	private static DBApp engine;
	private static String newTableName;
	private static String id = Constants.ID;
	private static String name = Constants.NAME;
	private static String age = Constants.AGE;
	private static final String TEST_NAME = "Yehia";
	private static final int TEST_AGE = 21;

	private static void generateNewTableName() {
		int randomNumber1 = (int) (Math.random() * 100000) + 1;
		int randomNumber2 = (int) (Math.random() * 100000) + 1;
		newTableName = randomNumber1 + "" + randomNumber2;
		while (engine.getMyTables().contains(newTableName)) {
			randomNumber1 = (int) (Math.random() * 100000) + 1;
			randomNumber2 = (int) (Math.random() * 100000) + 1;
			newTableName = randomNumber1 + "" + randomNumber2;
		}
	}

	@BeforeEach
	void setEnvironment() throws IOException, DBAppException {
		engine = new DBApp();
		engine.init();
		generateNewTableName();
		createTable();
	}

	private static void createTable() throws DBAppException {
		Hashtable<String, String> htblColNameType = createHashtable(Constants.INTEGER_DATA_TYPE_NAME,
				Constants.STRING_DATA_TYPE_NAME, Constants.INTEGER_DATA_TYPE_NAME);

		Hashtable<String, String> htblColNameMin = createHashtable(Constants.MIN_ID_VALUE, Constants.MIN_NAME_VALUE,
				Constants.MIN_AGE_VALUE);

		Hashtable<String, String> htblColNameMax = createHashtable(Constants.MAX_ID_VALUE, Constants.MAX_NAME_VALUE,
				Constants.MAX_AGE_VALUE);

		engine.createTable(newTableName, id, htblColNameType, htblColNameMin, htblColNameMax);
	}

	@Test
	void testCreateTable_AlreadyExistingName_ShouldFailCreation() throws DBAppException {
		// Given
		Hashtable<String, String> htblColNameType = new Hashtable<>();
		htblColNameType.put("id", "java.lang.String");
		htblColNameType.put("courseName", "java.lang.String");

		Hashtable<String, String> htblColNameMin = new Hashtable<>();
		htblColNameMin.put("id", "0000");
		htblColNameMin.put("courseName", "AAAAA");

		Hashtable<String, String> htblColNameMax = new Hashtable<>();
		htblColNameMax.put("id", "9999");
		htblColNameMax.put("courseName", "zzzz");
		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.createTable(newTableName, "id", htblColNameType, htblColNameMin, htblColNameMax);
		});
		// Then
		assertThat(exception.getMessage()).isEqualTo(Constants.ERROR_MESSAGE_REPEATED_TABLE_NAME);
	}

	@Test
	void testCreateTable_InvalidPrimaryKeyColumn_ShouldFailCreation() throws DBAppException {
		// Given
		Hashtable<String, String> htblColNameType = new Hashtable<>();
		htblColNameType.put("id", "java.lang.String");
		htblColNameType.put("courseName", "java.lang.String");

		Hashtable<String, String> htblColNameMin = new Hashtable<>();
		htblColNameMin.put("id", "0000");
		htblColNameMin.put("courseName", "AAAAA");

		Hashtable<String, String> htblColNameMax = new Hashtable<>();
		htblColNameMax.put("id", "9999");
		htblColNameMax.put("courseName", "zzzz");
		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.createTable("newTable", "price", htblColNameType, htblColNameMin, htblColNameMax);
		});
		// Then
		assertThat(exception.getMessage()).isEqualTo(Constants.ERROR_MESSAGE_INVALID_CLUSTERINGKEY);
	}

	@Test
	void testCreateTable_InvalidDataType_ShouldFailCreation() throws DBAppException {
		// Given
		Hashtable<String, String> htblColNameType = new Hashtable<>();
		htblColNameType.put("id", "java.lang.Byte");
		htblColNameType.put("courseName", "java.lang.String");

		Hashtable<String, String> htblColNameMin = new Hashtable<>();
		htblColNameMin.put("id", "0");
		htblColNameMin.put("courseName", "AAAAA");

		Hashtable<String, String> htblColNameMax = new Hashtable<>();
		htblColNameMax.put("id", "50");
		htblColNameMax.put("courseName", "zzzz");
		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.createTable("newTable", "id", htblColNameType, htblColNameMin, htblColNameMax);
		});
		// Then
		assertThat(exception.getMessage()).isEqualTo(Constants.ERROR_MESSAGE_DATATYPE);
	}

	@Test
	void testCreateTable_InvalidMinMax_ShouldFailCreation() throws DBAppException {
		// Given
		Hashtable<String, String> htblColNameType = new Hashtable<>();
		htblColNameType.put("course_id", "java.lang.String");
		htblColNameType.put("courseName", "java.lang.String");

		Hashtable<String, String> htblColNameMin = new Hashtable<>();
		htblColNameMin.put("course_id", "9999");
		htblColNameMin.put("courseName", "AAAAA");

		Hashtable<String, String> htblColNameMax = new Hashtable<>();
		htblColNameMax.put("course_id", "0000");
		htblColNameMax.put("courseName", "zzzz");
		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.createTable("newTable", "course_id", htblColNameType, htblColNameMin, htblColNameMax);
		});
		// Then
		assertThat(exception.getMessage()).isEqualTo(Constants.ERROR_MESSAGE_MIN_OR_MAX_NOT_VALID);
	}

	@Test
	void testCreateTable_InconsistentColumns_ShouldFailCreation() throws DBAppException {
		// Given
		Hashtable<String, String> htblColNameType = new Hashtable<>();
		htblColNameType.put("course_id", "java.lang.String");
		htblColNameType.put("courseName", "java.lang.String");

		Hashtable<String, String> htblColNameMin = new Hashtable<>();
		htblColNameMin.put("id", "0000");
		htblColNameMin.put("name", "AAAAA");

		Hashtable<String, String> htblColNameMax = new Hashtable<>();
		htblColNameMax.put("course_id", "9999");
		htblColNameMax.put("courseName", "zzzz");
		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.createTable("newTable", "course_id", htblColNameType, htblColNameMin, htblColNameMax);
		});
		// Then
		assertThat(exception.getMessage()).isEqualTo(Constants.ERROR_MESSAGE_MIN_OR_MAX_NOT_VALID);
	}

	@Test
	void testInsertIntoTable_OneTuple_ShouldInsertSuccessfully() throws ClassNotFoundException, IOException,
			CsvValidationException, DBAppException, ParseException, InterruptedException {
		// Given
		Hashtable<String, Object> htblColNameValue = createRow(1, TEST_NAME, TEST_AGE);

		// When
		engine.insertIntoTable(newTableName, htblColNameValue);

		// Then
		Table table = Serializer.deserializeTable(newTableName);
		assertThat(table.getPagesName().size()).isEqualTo(1);
		Page page = table.getPageAtPosition(0);
		assertThat(page.getSize() == 1);
	}

	@Test
	void testInsertIntoTable_ManyTuples_ShouldInsertSuccessfully() throws ClassNotFoundException, IOException,
			CsvValidationException, DBAppException, ParseException, InterruptedException {

		for (int i = 1; i < 300; i++) {
			// Given
			Hashtable<String, Object> htblColNameValue = createRow(i, TEST_NAME, TEST_AGE);

			// When
			engine.insertIntoTable(newTableName, htblColNameValue);
		}
		// Then
		Table table = Serializer.deserializeTable(newTableName);
		assertThat(table.getPagesName().size()).isEqualTo(2);
		Page page = table.getPageAtPosition(1);
		assertThat(page.getSize()).isEqualTo(99);
		page = table.getPageAtPosition(0);
		assertThat(page.isFull());
	}

	@Test
	void testInsertIntoTable_InsertingLastRecordIntoFullPage_ShouldInsertSuccessfully() throws ClassNotFoundException,
			IOException, CsvValidationException, DBAppException, ParseException, InterruptedException {
		// Given
		for (int i = 2; i < 402; i += 2) {
			Hashtable<String, Object> htblColNameValue = createRow(i, TEST_NAME, TEST_AGE);
			engine.insertIntoTable(newTableName, htblColNameValue);
		}

		// When
		Hashtable<String, Object> htblColNameValue = createRow(399, TEST_NAME, TEST_AGE);
		engine.insertIntoTable(newTableName, htblColNameValue);

		// Then
		Table table = Serializer.deserializeTable(newTableName);
		assertThat(table.getPagesName().size()).isEqualTo(2);
		Page page = table.getPageAtPosition(0);
		assertThat(page.isFull());
		assertThat(page.getTuples().get(199).getPrimaryKey()).isEqualTo(399);
	}

	@Test
	void testInsertIntoTable_InsertingRecordShiftingTwoPages_ShouldInsertSuccessfully() throws ClassNotFoundException,
			IOException, CsvValidationException, DBAppException, ParseException, InterruptedException {
		// Given
		for (int i = 2; i <= 802; i += 2) {
			Hashtable<String, Object> htblColNameValue = createRow(i, TEST_NAME, TEST_AGE);
			engine.insertIntoTable(newTableName, htblColNameValue);
		}

		// When
		Hashtable<String, Object> htblColNameValue = createRow(399, TEST_NAME, TEST_AGE);
		engine.insertIntoTable(newTableName, htblColNameValue);

		// Then
		Table table = Serializer.deserializeTable(newTableName);
		assertThat(table.getPagesName().size()).isEqualTo(3);
		Page page = table.getPageAtPosition(0);
		assertThat(page.getTuples().get(199).getPrimaryKey()).isEqualTo(399);
		page = table.getPageAtPosition(1);
		assertThat(page.getTuples().get(0).getPrimaryKey()).isEqualTo(400);
		page = table.getPageAtPosition(2);
		assertThat(page.getTuples().get(0).getPrimaryKey()).isEqualTo(800);
	}

	@Test
	void testInsertIntoTable_RepeatedPrimaryKey_ShouldFailInsert()
			throws CsvValidationException, ClassNotFoundException, DBAppException, IOException {
		// Given
		insertRow(1);
		Hashtable<String, Object> htblColNameValue = createRow(1, "Mohamed", TEST_AGE);

		// When
		try {
			engine.insertIntoTable(newTableName, htblColNameValue);
			fail("Expected DBAppException but no exception was thrown");
		} catch (DBAppException e) {

			// Then
			assertThat(e.getMessage()).isEqualTo(Constants.ERROR_MESSAGE_TUPLE_DATA);
		}
	}

	@Test
	void testInsertIntoTable_InvalidDataType_ShouldFailInsertion() throws DBAppException {
		// Given
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(name, "Foo");
		htblColNameValue.put(age, "boo");
		htblColNameValue.put(id, 55);

		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.insertIntoTable(newTableName, htblColNameValue);
		});

		// Then
		String expectedMessage = Constants.ERROR_MESSAGE_TUPLE_DATA;
		String outputMessage = exception.getMessage();
		assertThat(outputMessage).isEqualTo(expectedMessage);
	}

	@Test
	void testInsertIntoTable_InvalidTableName_ShouldFailInsertion() {
		// Given
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(name, "Foo");
		htblColNameValue.put(age, TEST_AGE);
		htblColNameValue.put(id, 55);

		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.insertIntoTable("someRandomTableName", htblColNameValue);
		});

		// Then
		String expectedMessage = Constants.ERROR_MESSAGE_TABLE_NAME;
		String outputMessage = exception.getMessage();
		assertThat(outputMessage).isEqualTo(expectedMessage);
	}

	@Test
	void testInsertIntoTable_LessThanMin_ShouldFailInsertion() {
		// Given
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(name, "0abc");
		htblColNameValue.put(age, TEST_AGE);
		htblColNameValue.put(id, 3);

		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.insertIntoTable(newTableName, htblColNameValue);
		});

		// Then
		String expectedMessage = Constants.ERROR_MESSAGE_TUPLE_DATA;
		String outputMessage = exception.getMessage();
		assertThat(outputMessage).isEqualTo(expectedMessage);
	}

	@Test
	void testInsertIntoTable_MoreThanMax_ShouldFailInsertion() {
		// Given
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(name, "{abc");
		htblColNameValue.put(age, TEST_AGE);
		htblColNameValue.put(id, 3);

		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.insertIntoTable(newTableName, htblColNameValue);
		});

		// Then
		String expectedMessage = Constants.ERROR_MESSAGE_TUPLE_DATA;
		String outputMessage = exception.getMessage();
		assertThat(outputMessage).isEqualTo(expectedMessage);
	}

	@Test
	void testInsertIntoTable_MissingColumn_ShouldFailInsertion() {
		// Given
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(age, TEST_AGE);
		htblColNameValue.put(id, 5);

		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.insertIntoTable(newTableName, htblColNameValue);
		});

		// Then
		String expectedMessage = Constants.ERROR_MESSAGE_TUPLE_DATA;
		String outputMessage = exception.getMessage();
		assertThat(outputMessage).isEqualTo(expectedMessage);
	}

	@Test
	void testInsertIntoTable_ExtraColumn_ShouldFailInsertion() {
		// Given
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(name, "Foo");
		htblColNameValue.put("salary", 10000);
		htblColNameValue.put(age, TEST_AGE);
		htblColNameValue.put(id, 3);

		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.insertIntoTable(newTableName, htblColNameValue);
		});

		// Then
		String expectedMessage = Constants.ERROR_MESSAGE_TUPLE_DATA;
		String outputMessage = exception.getMessage();
		assertThat(outputMessage).isEqualTo(expectedMessage);
	}

	@Test
	void testUpdateTable_ValidInput_ShouldUpdateSuccessfully()
			throws DBAppException, ClassNotFoundException, IOException {
		// Given
		insertRow(1);
		String updatedName = "Mohamed";
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(name, updatedName);

		// When
		engine.updateTable(newTableName, "1", htblColNameValue);

		// Then
		Page page = Serializer.deserializePage(newTableName, "0");
		Tuple updated = page.getTuples().get(0);
		assertThat(updated.getCells().get(2).getValue()).isEqualTo(updatedName);
	}

	@Test
	void testUpdateTable_InvalidPrimaryKey_ShouldFailUpdate() throws DBAppException {
		// Given
		insertRow(1);
		String updatedName = "Mohamed";
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(name, updatedName);

		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.updateTable(newTableName, "0", htblColNameValue);
		});

		// Then
		String expectedMessage = Constants.ERROR_MESSAGE_TUPLE_DATA;
		String outputMessage = exception.getMessage();
		assertThat(outputMessage).isEqualTo(expectedMessage);
	}

	@Test
	void testUpdateTable_PrimaryKeyUpdate_ShouldFailUpdate()
			throws DBAppException, ClassNotFoundException, IOException {
		// Given
		insertRow(1);
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(id, 2);

		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.updateTable(newTableName, "1", htblColNameValue);
		});

		// Then
		String expectedMessage = Constants.ERROR_MESSAGE_TUPLE_DATA;
		String outputMessage = exception.getMessage();
		assertThat(outputMessage).isEqualTo(expectedMessage);
	}

	@Test
	void testUpdateTable_ExtraInput_ShouldFailUpdate() throws DBAppException {
		// Given
		insertRow(1);
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(name, "Foo");
		htblColNameValue.put(age, 25);
		htblColNameValue.put("University", "GUC");

		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.updateTable(newTableName, "0", htblColNameValue);
		});

		// Then
		String expectedMessage = Constants.ERROR_MESSAGE_TUPLE_DATA;
		String outputMessage = exception.getMessage();
		assertThat(outputMessage).isEqualTo(expectedMessage);
	}

	@Test
	void testUpdateTable_MoreThanMax_ShouldFailUpdate() throws DBAppException {
		// Given
		insertRow(1);
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(age, 2500);

		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.updateTable(newTableName, "1", htblColNameValue);
		});

		// Then
		String expectedMessage = Constants.ERROR_MESSAGE_TUPLE_DATA;
		String outputMessage = exception.getMessage();
		assertThat(outputMessage).isEqualTo(expectedMessage);
	}

	@Test
	void testUpdateTable_LessThanMin_ShouldFailUpdate() throws DBAppException {
		// Given
		insertRow(1);
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(age, 0);

		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.updateTable(newTableName, "1", htblColNameValue);
		});

		// Then
		String expectedMessage = Constants.ERROR_MESSAGE_TUPLE_DATA;
		String outputMessage = exception.getMessage();
		assertThat(outputMessage).isEqualTo(expectedMessage);
	}

	@Test
	void testUpdateTable_InvalidDataType_ShouldFailUpdate() throws DBAppException {
		// Given
		insertRow(1);
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(age, "Foo");

		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.updateTable(newTableName, "1", htblColNameValue);
		});

		// Then
		String expectedMessage = Constants.ERROR_MESSAGE_TUPLE_DATA;
		String outputMessage = exception.getMessage();
		assertThat(outputMessage).isEqualTo(expectedMessage);
	}

	@Test
	void testUpdateTable_InvalidTableName_ShouldFailUpdate() throws DBAppException {
		// Given
		insertRow(1);
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(age, 25);

		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.updateTable("randomName", "1", htblColNameValue);
		});

		// Then
		String expectedMessage = Constants.ERROR_MESSAGE_TABLE_NAME;
		String outputMessage = exception.getMessage();
		assertThat(outputMessage).isEqualTo(expectedMessage);
	}

	@Test
	void testDeleteFromTable_OneTuple_ShouldDeleteSuccessfully()
			throws DBAppException, ClassNotFoundException, IOException, InterruptedException {
		// Given
		insertRow(1);
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(id, 1);

		// When
		engine.deleteFromTable(newTableName, htblColNameValue);

		// Then
		Table table = Serializer.deserializeTable(newTableName);
		assertThat(table.isEmpty());
	}

	@Test
	void testDeleteFromTable_ManyTuplesDeleteOne_ShouldDeleteSuccessfully()
			throws DBAppException, ClassNotFoundException, IOException {
		// Given
		for (int i = 0; i < 100; i++)
			insertRow(i);
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(name, TEST_NAME);
		htblColNameValue.put(id, 0);

		// When
		engine.deleteFromTable(newTableName, htblColNameValue);

		// Then
		Table table = Serializer.deserializeTable(newTableName);
		assertThat(table.getSize()).isEqualTo(99);
	}

	@Test
	void testDeleteFromTable_ManyTuplesDeleteAll_ShouldDeleteSuccessfully()
			throws DBAppException, ClassNotFoundException, IOException {
		// Given
		for (int i = 0; i < 100; i++)
			insertRow(i);
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(name, TEST_NAME);

		// When
		engine.deleteFromTable(newTableName, htblColNameValue);

		// Then
		Table table = Serializer.deserializeTable(newTableName);
		assertThat(table.isEmpty());
	}

	@Test
	void testDeleteFromTable_InvalidColumnName_ShouldFailDelete()
			throws DBAppException, ClassNotFoundException, IOException {
		// Given
		insertRow(1);
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put("middle_name", "Mohamed");

		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.deleteFromTable(newTableName, htblColNameValue);
		});

		// Then
		String expectedMessage = Constants.ERROR_MESSAGE_TUPLE_DATA;
		String outputMessage = exception.getMessage();
		assertThat(outputMessage).isEqualTo(expectedMessage);
	}

	@Test
	void testDeleteFromTable_InvalidDataType_ShouldFailDelete() throws DBAppException {
		// Given
		insertRow(1);
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(id, 1);
		htblColNameValue.put("age", "Foo");

		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.deleteFromTable(newTableName, htblColNameValue);
		});

		// Then
		String expectedMessage = Constants.ERROR_MESSAGE_TUPLE_DATA;
		String outputMessage = exception.getMessage();
		assertThat(outputMessage).isEqualTo(expectedMessage);
	}

	@Test
	void testDeleteFromTable_InvalidTable_ShouldFailDelete()
			throws DBAppException, ClassNotFoundException, IOException, InterruptedException {
		// Given
		insertRow(1);
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(id, 1);

		// When
		Exception exception = assertThrows(DBAppException.class, () -> {
			engine.deleteFromTable("randomTableName", htblColNameValue);
		});

		// Then
		String expectedMessage = Constants.ERROR_MESSAGE_TABLE_NAME;
		String outputMessage = exception.getMessage();
		assertThat(outputMessage).isEqualTo(expectedMessage);
	}

	private static void insertRow(int id) throws DBAppException {

		Hashtable<String, Object> htblColNameValue = createRow(id, TEST_NAME, TEST_AGE);

		engine.insertIntoTable(newTableName, htblColNameValue);
	}

	private static Hashtable<String, String> createHashtable(String value1, String value2, String value3) {
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		hashtable.put(id, value1);
		hashtable.put(name, value2);
		hashtable.put(age, value3);
		return hashtable;
	}

	private static Hashtable<String, Object> createRow(int idInput, String nameInput, int ageInput) {
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(id, idInput);
		htblColNameValue.put(name, nameInput);
		htblColNameValue.put(age, ageInput);
		return htblColNameValue;
	}

	@AfterEach
	void deleteCreatedTable() throws ClassNotFoundException, IOException, InterruptedException {
		Table table = Serializer.deserializeTable(newTableName);
		FileDeleter.deleteFile(table, FileType.TABLE);
	}
}
