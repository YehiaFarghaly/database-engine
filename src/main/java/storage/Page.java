package storage;

import constants.Constants;
import exceptions.DBAppException;
import util.PagePrinter;
import util.filecontroller.*;
import util.search.PageSearch;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

public class Page implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 2857345022460368698L;
	private String name;
	private int maxRows;
	private Vector<Tuple> tuples;
	private Object minPK, maxPK;
	private String tableName;

	public Page(String tableName) throws IOException {
		this.tuples = new Vector<>();
		this.tableName = tableName;
		Properties prop = ConfigReader.readProperties();
		maxRows = Integer.parseInt(prop.getProperty(Constants.MAX_ROWS_IN_PAGE));
	}

	public Object getMinPK() {
		return minPK;
	}

	public Vector<Tuple> getTuples() {
		return tuples;
	}

	public void setMinPK(Object minPK) {
		this.minPK = minPK;
	}

	public Object getMaxPK() {
		return maxPK;
	}

	public void setMaxPK(Object maxPK) {
		this.maxPK = maxPK;
	}

	public int getSize() {
		return tuples.size();
	}

	public String getTableName() {
		return tableName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public boolean isEmpty() {
		return tuples.size() == 0;
	}

	public boolean isFull() {
		return tuples.size() == maxRows;
	}

	protected Tuple removeLastTuple() throws IOException {
		Tuple ret = tuples.remove(tuples.size() - 1);
		Serializer.serializePage(name, this);
		return ret;
	}

	protected void insertIntoPage(Tuple tuple) throws IOException, DBAppException, ParseException {
		int position = isEmpty() ? 0 : pageBinarySearch(tuple.getPrimaryKey());
		tuples.add(position, tuple);
		newMinMax();
		Serializer.serializePage(name, this);
	}

	private void newMinMax() {
		if (tuples.size() > 0) {
			minPK = tuples.get(0).getPrimaryKey();
			maxPK = tuples.get(tuples.size() - 1).getPrimaryKey();
		}
	}

	public int pageBinarySearch(Object primaryKey) throws DBAppException, ParseException {
		return PageSearch.binarySearch(this, primaryKey);
	}

	protected Vector<Tuple> linearSearch(String colName, Object value) throws DBAppException, ParseException {
		return PageSearch.linearSearch(this, colName, value);
	}

	protected Vector<Tuple> linearSearch(Hashtable<String, Object> colNameValue) throws DBAppException, ParseException {
		return PageSearch.linearSearch(this, colNameValue);
	}

	protected void deleteFromPage(Tuple tuple) throws IOException, DBAppException, ParseException {
		int position = pageBinarySearch(tuple.getPrimaryKey());
		if (position != -1) {
			tuples.remove(position);
			newMinMax();
			Serializer.serializePage(name, this);
			handleEmptyPage();
		} else {
			throw new DBAppException(Constants.ERROR_MESSAGE_SEARCH_NOT_FOUND);
		}
	}

	private void handleEmptyPage() throws IOException {
		if (tuples.isEmpty()) {
			deletePageFile();
		}

	}

	private void deletePageFile() {
		FileDeleter.deleteFile(this, FileType.PAGE);
	}

	protected void createPageFile() throws IOException {

		FileCreator.createFile(this, FileType.PAGE);
	}

	protected void updateTuple(Object clusteringKeyValue, Hashtable<String, Object> htblColNameValue)
			throws DBAppException, ParseException, IOException {
		int pkVectorPoition = pageBinarySearch(clusteringKeyValue);
		Tuple tuple = tuples.get(pkVectorPoition);

		for (Cell c : tuple.getCells()) {
			if (htblColNameValue.get(c.getKey()) != null)
				c.setValue(htblColNameValue.get(c.getKey()));
		}
		Serializer.serializePage(name, this);

	}


	public void print() throws IOException, ClassNotFoundException {
		PagePrinter print = new PagePrinter(this);
		print.printPage();
	}
}
