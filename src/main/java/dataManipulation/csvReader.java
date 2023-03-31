package dataManipulation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import constants.Constants;
import storage.Table;

public class csvReader {

	CSVReader reader;

	public csvReader() {
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

	public Hashtable<String, Table> readAll() {
		Hashtable<String, Table> allTables = new Hashtable<>();
		String[] col;
		try {
			while ((col = reader.readNext()) != null) {
				updateTable(allTables, col);
			}
		} catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
		return allTables;
	}

	private void updateTable(Hashtable<String, Table> allTables, String[] record) {
		if (!allTables.containsKey(record[0])) {
			allTables.put(record[0],
					new Table(record[0], null, new Hashtable<>(), new Hashtable<>(), new Hashtable<>()));
		}
		Table curr = allTables.get(record[0]);
		curr.getColNameType().put(record[1], record[2]);
		curr.getColNameMin().put(record[1], record[6]);
		curr.getColNameMax().put(record[1], record[7]);
		if (record[3].equals("True")) {
			curr.setPKColumn(record[1]);
		}
	}

}
