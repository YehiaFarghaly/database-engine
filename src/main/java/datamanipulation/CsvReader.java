package datamanipulation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import constants.Constants;
import storage.Table;

public class CsvReader {

	CSVReader reader;

	public CsvReader() {
		try {
			this.reader = new CSVReader(new FileReader(Constants.METADATA_PATH));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String[]> readTable(String tableName) {
		ArrayList<String[]> tableCol = new ArrayList<>();
		String[] col;
		try {
			while ((col = reader.readNext()) != null) {
				if (col[0].equals(tableName))
					tableCol.add(col);
			}
		} catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
		return tableCol;
	}
}
