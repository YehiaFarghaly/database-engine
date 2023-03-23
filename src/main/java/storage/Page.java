package storage;

import java.io.Serializable;
import java.util.Vector;
import search.PageSearch;

public class Page implements Serializable {

	private Vector<Tuple> tuples;
	private Object minPK, maxPK;
	private int size;
	private final String tableName;

	public Page(String tableName) {
		this.tuples = new Vector<>();this.tableName=tableName;
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

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Vector<Tuple> search(String colName, String value) {
		return PageSearch.search(this, String colName, String value);
	}

	public Vector<Tuple> searchGreaterThan(String colName, String value) {
		return PageSearch.searchGreaterThan(this, String colName, String value);
	}

	public Vector<Tuple> searchGreaterThanOrEqual(String colName, String value) {
		return PageSearch.searchGreaterThanOrEqual(this, String colName, String value);
	}

	public Vector<Tuple> searchLessThan(String colName, String value) {
		return PageSearch.searchLessThan(this, String colName, String value);
	}

	public Vector<Tuple> searchLessThanOrEqual(String colName, String value) {
		return PageSearch.searchLessThanOrEqual(this, String colName, String value);
	}

	public Vector<Tuple> searchNotEqual(String colName, String value) {
		return PageSearch.searchNotEqual(this, String colName, String value);
	}
}
