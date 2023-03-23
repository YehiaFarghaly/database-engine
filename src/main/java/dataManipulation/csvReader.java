package dataManipulation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class csvReader {

	CSVReader reader;

	public csvReader() {
		try {
			this.reader = new CSVReader(new FileReader("Metadata//metadata.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String[]> read(String tableName) throws CsvValidationException, IOException {
		ArrayList<String[]> tableCol = new ArrayList<>();

		StringBuffer SB = new StringBuffer();
		String[] col;
		while ((col = reader.readNext()) != null) {
			if (col[0].equals(tableName))
				tableCol.add(col);
		}
		return tableCol;
	}

}
