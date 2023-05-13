package util.filecontroller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import constants.Constants;
import exceptions.DBAppException;
import storage.Page;
import storage.Table;

public class Serializer {
	static FileOutputStream fileOut;
	static ObjectOutputStream out;
	static FileInputStream fileIn;
	static ObjectInputStream in;

	public static void serializeTable(Table tableObject) throws DBAppException {
		try {
			out = getOutStream(tableObject.getName(), tableObject.getName());
			out.writeObject(tableObject);
			out.close();
			fileOut.close();
		} catch (Exception e) {
			throw new DBAppException(e.getMessage());
		}
	}

	public static Table deserializeTable(String tableName) throws DBAppException {
		try {
			in = getInputStream(tableName, tableName);
			Table table = (Table) in.readObject();
			in.close();
			fileIn.close();
			return table;
		} catch (Exception e) {
			throw new DBAppException(e.getMessage());
		}

	}

	public static void serializePage(String pageName, Page pageObject) throws DBAppException {
		try {
			out = getOutStream(pageObject.getTableName(), pageName);
			out.writeObject(pageObject);
			out.close();
			fileOut.close();
		} catch (Exception e) {
			throw new DBAppException(e.getMessage());
		}
	}

	public static Page deserializePage(String tableName, String pageName) throws DBAppException {
		try {
			in = getInputStream(tableName, pageName);
			Page records = (Page) in.readObject();
			in.close();
			fileIn.close();
			return records;
		} catch (Exception e) {
			throw new DBAppException(e.getMessage());
		}
	}

	public static ObjectOutputStream getOutStream(String tableName, String targetName) throws IOException {
		String path = getPath(tableName, targetName);
		fileOut = new FileOutputStream(path);
		out = new ObjectOutputStream(fileOut);
		return out;
	}

	public static ObjectInputStream getInputStream(String tableName, String targetName) throws IOException {
		String path = getPath(tableName, targetName);
		fileIn = new FileInputStream(path);
		in = new ObjectInputStream(fileIn);
		return in;
	}

	public static String getPath(String tableName, String targetName) {
		return tableName + "//" + targetName + Constants.DATA_EXTENSTION;
	}
}
