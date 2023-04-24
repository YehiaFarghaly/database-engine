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

		Hashtable<String, String> htblColNameMax = createHashtable(id, Constants.MAX_NAME_VALUE,
				Constants.MAX_AGE_VALUE);

		engine.createTable(newTableName, id, htblColNameType, htblColNameMin, htblColNameMax);
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

	@Test
	void testInsertIntoTable_OneTuple_ShouldInsertSuccessfully() throws ClassNotFoundException, IOException,
			CsvValidationException, DBAppException, ParseException, InterruptedException {
		// Given
		Hashtable<String, Object> htblColNameValue = createRow(1, TEST_NAME, TEST_AGE);

		// When
		engine.insertIntoTable(newTableName, htblColNameValue);

		// Then
		Table table = Serializer.deserializeTable(newTableName);
		assertThat(table.getPagesName().size() == 1);
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
		assertThat(table.getPagesName().size() == 2);
		Page page = table.getPageAtPosition(0);
		assertThat(page.isFull());
		page = table.getPageAtPosition(1);
		assertThat(page.getSize() == 100);
	}

//	@Test
//	void testInsertIntoTable_RepeatedPrimaryKey_ShouldFailInsert() throws CsvValidationException, ClassNotFoundException, DBAppException, IOException {
//		// Given
//		Hashtable<String,Object> htblColNameValue = createRow(1, "Mohamed", TEST_AGE);
//		
//		// When
//		Exception exception = assertThrows(DBAppException.class,()->{
//		engine.insertIntoTable(newTableName, htblColNameValue);
//		}
//		);
//		
//		//Then
//		String expectedMessage = Constants.ERROR_MESSAGE_TUPLE_DATA;
//		String outputMessage = exception.getMessage();
//		assertThat(outputMessage).isEqualTo(expectedMessage);
//	}

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
		assertThat(updated.getCells().get(1).getValue()).isEqualTo(updatedName);
	}

//	@Test
//	void testUpdateTable_InvalidPrimaryKey_ShouldFailUpdate() throws DBAppException {
//		// Given
//		String updatedName = "Mohamed";
//		Hashtable<String, Object> htblColNameValue = new Hashtable();
//		htblColNameValue.put(name, updatedName);
//
//		// When
//		Exception exception = assertThrows(DBAppException.class, () -> {
//			engine.updateTable(newTableName, "0", htblColNameValue);
//		});
//
//		// Then
//		String expectedMessage = Constants.ERROR_MESSAGE_TUPLE_DATA;
//		String outputMessage = exception.getMessage();
//		assertThat(outputMessage).isEqualTo(expectedMessage);
//	}

	@Test
	void testDeleteFromTable_OneTuple_ShouldDeleteSuccessfully()
			throws DBAppException, ClassNotFoundException, IOException, InterruptedException {
		// Given
		insertRow(1);
		Hashtable<String,Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(id, 1);

		// When
		engine.deleteFromTable(newTableName, htblColNameValue);

		// Then
		Table table = Serializer.deserializeTable(newTableName);
		assertThat(table.isEmpty());
	}

	@Test
	void testDeleteFromTable_ManyTuples_ShouldDeleteSuccessfully()
			throws DBAppException, ClassNotFoundException, IOException {
		// Given
		for (int i = 0; i < 100; i++)
			insertRow(i);
		Hashtable<String,Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(name, TEST_NAME);

		// When
		engine.deleteFromTable(newTableName, htblColNameValue);

		// Then
		Table table = Serializer.deserializeTable(newTableName);
		assertThat(table.isEmpty());
	}

//	@Test
//	void testDeleteFromTable_InvalidName_ShouldFailDelete() throws DBAppException, ClassNotFoundException, IOException {
//		// Given
//		insertRow(1);
//		Hashtable<String,Object> htblColNameValue = new Hashtable<>();
//		htblColNameValue.put(name, "Mohamed");
//
//		// When
//		Exception exception = assertThrows(DBAppException.class, () -> {
//			engine.deleteFromTable(newTableName, htblColNameValue);
//		});
//
//		// Then
//		String expectedMessage = Constants.ERROR_MESSAGE_TUPLE_DATA;
//		String outputMessage = exception.getMessage();
//		assertThat(outputMessage).isEqualTo(expectedMessage);
//	}

	@AfterEach
	void deleteCreatedTable() throws ClassNotFoundException, IOException, InterruptedException {
		Table table = Serializer.deserializeTable(newTableName);
		FileDeleter.deleteFile(table, FileType.TABLE);
	}
}
