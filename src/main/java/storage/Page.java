package storage;

import java.io.Serializable;
import java.util.Vector;
import search.PageSearch;

public class Page implements Serializable {
	private String name;
	private int maxRows;
	private Vector<Tuple> tuples;
	private Object minPK, maxPK;
	private int size;
	private String tableName;

	public Page(String tableName) {
		this.tuples = new Vector<>();
		this.tableName = tableName;
		name = minPK + "" + tableName;
	}

	public Object getMinPK() {
		return minPK;
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
		return size;
	}

	public String getTableName() {
		return tableName;
	}

	public String getName() {
		return name;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public void insertIntoPage(Tuple tuple) {

	}

	public Vector<Tuple> search(String colName, String value) {
		return
				new PageSearch(this).search(colName, value);
	}

	public Vector<Tuple> searchGreaterThan(String colName, String value) {
		return
				new PageSearch(this).searchGreaterThan(colName, value);
	}

	public Vector<Tuple> searchGreaterThanOrEqual(String colName, String value) {
		return
				new PageSearch(this).searchGreaterThanOrEqual(colName, value);
	}

	public Vector<Tuple> searchLessThan(String colName, String value) {
		return
				new PageSearch(this).searchLessThan(colName, value);
	}

	public Vector<Tuple> searchLessThanOrEqual(String colName, String value) {
		return
				new PageSearch(this).searchLessThanOrEqual(colName, value);
	}

	public Vector<Tuple> searchNotEqual(String colName, String value) {
		return
				new PageSearch(this).searchNotEqual(colName, value);
	}

	public boolean isFull() {
		return size == maxRows;
	}
	public Vector<Tuple> getTuples() {
		return tuples;
	}

}
