package Serializerium;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import constants.Constants;
import storage.Cell;
import storage.Tuple;

public class Serializer {
	
	
	public void SerializeTable(String TableName,Vector<String> PagesOfTable) throws IOException {
		FileOutputStream fileOut = new FileOutputStream(Constants.DATA_TABLE+TableName+Constants.DATA_EXTENSTION);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(PagesOfTable);
		out.close();
		fileOut.close();
	}
	
	public Vector<String> deserializeTable(String TableName) throws IOException, ClassNotFoundException {
	
		FileInputStream fileIn = new FileInputStream(Constants.DATA_TABLE+TableName+Constants.DATA_EXTENSTION);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		Vector<String> TablePageName = (Vector<String>) in.readObject();
		in.close();
		fileIn.close();
		return TablePageName;
	}
	
	public void SerializePage(String PageName,Vector<Tuple> records) throws IOException {
		FileOutputStream fileOut = new FileOutputStream(Constants.DATA_PAGE+PageName+Constants.DATA_EXTENSTION);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(records);
		out.close();
		fileOut.close();
	}
	
	public Vector<Tuple> deserializePage(String PageName) throws IOException, ClassNotFoundException {
	
		FileInputStream fileIn = new FileInputStream(Constants.DATA_PAGE+PageName+Constants.DATA_EXTENSTION);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		Vector<Tuple> records = (Vector<Tuple>) in.readObject();
		in.close();
		fileIn.close();
		return records;
	}
	
	

}
