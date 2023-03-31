package Serializerium;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import constants.Constants;
import storage.Cell;
import storage.Page;
import storage.Table;
import storage.Tuple;

public class Serializer {
	static FileOutputStream fileOut;
	static ObjectOutputStream out;
	static FileInputStream fileIn;
	static ObjectInputStream in;

	public static void SerializeTable(Table table) throws IOException {
		out = getOutStream(table.getName());
		out.writeObject(table);
		out.close();
		fileOut.close();
	}

	public static Table deserializeTable(String TableName) throws IOException, ClassNotFoundException {
		in = getInputStream(TableName);
		Table table = (Table) in.readObject();
		in.close();
		fileIn.close();
		return table;
	}

	public static void SerializePage(String PageName, Page records) throws IOException {
		out = getOutStream(PageName);
		out.writeObject(records);
		out.close();
		fileOut.close();
	}

	public static Page deserializePage(String PageName) throws IOException, ClassNotFoundException {
		in = getInputStream(PageName);
		Page records = (Page) in.readObject();
		in.close();
		fileIn.close();
		return records;
	}

	public static ObjectOutputStream getOutStream(String name) throws IOException {
		String path = getPath(name);
		fileOut = new FileOutputStream(path);
		out = new ObjectOutputStream(fileOut);
		return out;
	}

	public static ObjectInputStream getInputStream(String name) throws IOException {
		String path = getPath(name);
		fileIn = new FileInputStream(path);
		in = new ObjectInputStream(fileIn);
		return in;
	}

	public static String getPath(String name) {
		return Constants.DATA_TABLE + name + Constants.DATA_EXTENSTION;
	}
}
