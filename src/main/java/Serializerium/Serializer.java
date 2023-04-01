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

	public static void SerializeTable(Table tableObject) throws IOException {
		out = getOutStream(tableObject.getName(), tableObject.getName());
		out.writeObject(tableObject);
		out.close();
		fileOut.close();
	}

	public static Table deserializeTable(String TableName) throws IOException, ClassNotFoundException {
		in = getInputStream(TableName, TableName);
		Table table = (Table) in.readObject();
		in.close();
		fileIn.close();
		return table;
	}

	public static void SerializePage(String PageName, Page pageObject) throws IOException {
		out = getOutStream(pageObject.getTableName(),PageName);
		out.writeObject(pageObject);
		out.close();
		fileOut.close();
	}

	public static Page deserializePage(String tableName,String PageName) throws IOException, ClassNotFoundException {
		in = getInputStream(tableName, PageName);
		Page records = (Page) in.readObject();
		in.close();
		fileIn.close();
		return records;
	}

	public static ObjectOutputStream getOutStream(String tableName,String targetName) throws IOException {
		String path = getPath(tableName,targetName);
		fileOut = new FileOutputStream(path);
		out = new ObjectOutputStream(fileOut);
		return out;
	}

	public static ObjectInputStream getInputStream(String tableName,String targetName) throws IOException {
		String path = getPath(tableName,targetName);
		fileIn = new FileInputStream(path);
		in = new ObjectInputStream(fileIn);
		return in;
	}

	private static String getPath(String tableName,String targetName) {
		return tableName+ "//" + targetName + Constants.DATA_EXTENSTION;
	}
}
