package datamanipulation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import constants.Constants;

public class CsvReader {

	CSVReader reader;

	public CsvReader() {
		try {
			this.reader = new CSVReader(new FileReader(Constants.METADATA_PATH));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<String[]> readAll() {
		List<String[]> allTablesCol = null;
		try {
			allTablesCol = reader.readAll();
		} catch (IOException | CsvException e) {
			e.printStackTrace();
		}
		return allTablesCol;
	}

	public ArrayList<String[]> readTable(String tableName) {
		ArrayList<String[]> tableCol = new ArrayList<>();
		List<String[]> allTablesCol = readAll();
		for (String[] col : allTablesCol) {
			if (col[0].equals(tableName))
				tableCol.add(col);
		}
		return tableCol;
	}

	public HashSet<String> readAllTables() {
		HashSet<String> tables = new HashSet<>();
		List<String[]> allTablesCol = readAll();
		for (String[] col : allTablesCol) {
			tables.add(col[0]);
		}
		return tables;
	}
}
