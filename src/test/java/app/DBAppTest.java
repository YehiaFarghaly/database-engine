package app;

import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvValidationException;

import Serializerium.Serializer;
import exceptions.DBAppException;
import storage.Page;
import storage.Table;
import constants.Constants;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Hashtable;

import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.*;

public class DBAppTest {
	private DBApp engine;
	private String newTableName;
	private String id = Constants.ID;
	private String name = Constants.NAME;
	private String age = Constants.AGE;

	private void generateNewTableName() {
		int randomNumber1 = (int) (Math.random() * 100000) + 1;
		int randomNumber2 = (int) (Math.random() * 100000) + 1;
		newTableName = randomNumber1 + "" + randomNumber2;
		while (engine.getMyTables().containsKey(newTableName)) {
			randomNumber1 = (int) (Math.random() * 100000) + 1;
			randomNumber2 = (int) (Math.random() * 100000) + 1;
			newTableName = randomNumber1 + "" + randomNumber2;
		}
	}

	@BeforeEach
	void setEnvironment() throws IOException {
		engine = new DBApp();
		engine.init();
		generateNewTableName();
	}

	private Hashtable<String, String> createHashtable(String value1, String value2, String value3) {
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		hashtable.put(id, value1);
		hashtable.put(name, value2);
		hashtable.put(age, value3);
		return hashtable;
	}

	@Test
	void testCreateTable_ValidTableName_ShouldBeCreatedSuccessfully() throws DBAppException {
		// Given
		Hashtable<String, String> htblColNameType = createHashtable(Constants.INTEGER_DATA_TYPE_NAME,
				Constants.STRING_DATA_TYPE_NAME, Constants.INTEGER_DATA_TYPE_NAME);

		Hashtable<String, String> htblColNameMin = createHashtable(Constants.MIN_ID_VALUE, Constants.MIN_NAME_VALUE,
				Constants.MIN_AGE_VALUE);

		Hashtable<String, String> htblColNameMax = createHashtable(Constants.MAX_ID_VALUE, Constants.MAX_NAME_VALUE,
				Constants.MAX_AGE_VALUE);

		// When
		engine.createTable(newTableName, Constants.ID, htblColNameType, htblColNameMin, htblColNameMax);

		// Then
		assertThat(engine.getMyTables().containsKey(newTableName));
	}
	

	@Test
	void testInsertIntoTable_ValidInput_ShouldInsertSuccessfully() throws ClassNotFoundException, IOException, CsvValidationException, DBAppException {
		// Given 
		Hashtable<String, Object> htblColNameValue = new Hashtable<>();
		htblColNameValue.put(id, 1);
		htblColNameValue.put(name, "Yehia");
		htblColNameValue.put(age, 21);
        
		// When
		engine.insertIntoTable(newTableName, htblColNameValue);
		
		// Then
		Table table = Serializer.deserializeTable(newTableName);
		assertThat(table.getPagesName().size()==1);
		Page page = table.getPageAtPosition(0);
		assertThat(page.getSize()==1);
	}
}
