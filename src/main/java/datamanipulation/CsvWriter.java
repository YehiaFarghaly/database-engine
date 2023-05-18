package datamanipulation;

import java.io.*;
import java.util.List;
import java.util.Map.Entry;
import com.opencsv.CSVWriter;
import constants.Constants;
import exceptions.DBAppException;
import storage.Table;

public class CsvWriter {

	CSVWriter writer;

	public CsvWriter() {
		try {
			this.writer = new CSVWriter(new FileWriter(Constants.METADATA_PATH, true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeAll(List<String[]> tableInfo) throws IOException {
		this.writer = new CSVWriter(new FileWriter(Constants.METADATA_PATH));
		writer.writeAll(tableInfo);
		try {
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void write(Table table) {
		for (Entry<String, String> e : table.getColNameType().entrySet()) {
			writeRecord(table.getName(), e.getKey(), e.getValue(), e.getKey().equals(table.getPKColumn()) + "", "null",
					"null", table.getColNameMin().get(e.getKey()), table.getColNameMax().get(e.getKey()));
		}
		try {
			writer.flush();
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	private void writeRecord(String tableName, String colName, String colType, String isClusteringKey, String indexName,
			String indexType, String minValue, String maxValue) {
		String[] record = { tableName, colName, colType, isClusteringKey, indexName, indexType, minValue, maxValue };
		writer.writeNext(record);
	}

	public void clear() {
		try {
			writer = new CSVWriter(new FileWriter(Constants.METADATA_PATH));
			writer.writeNext(null);
			writer = new CSVWriter(new FileWriter(Constants.METADATA_PATH, true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updateCsvFile(String strTableName, String indexName, String[] strarrColName) throws DBAppException {
		CsvReader cr = new CsvReader();
		List<String[]> tableInfo = cr.readAll();
		int size = tableInfo.size();
		for (int i = 0; i < size; i++) {
			if (tableInfo.get(i)[0].equals(strTableName)) {
				String colName = tableInfo.get(i)[Constants.COLUMN_NAME_INDEX];
				if (colName.equals(strarrColName[0]) || colName.equals(strarrColName[1])
						|| colName.equals(strarrColName[2])) {
					tableInfo.get(i)[Constants.INDEX_NAME_INDEX] = indexName;
					tableInfo.get(i)[Constants.INDEX_TYPE_INDEX] = "Octree";
				}
			}
		}
		try {
			writeAll(tableInfo);
		} catch (IOException e) {
			throw new DBAppException(e.getMessage());
		}
	}
}
