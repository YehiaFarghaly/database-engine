package storage;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import Serializerium.Serializer;
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
		this.tableName=tableName;
		// Name should not be defined here as minPK is still null.
		name = minPK+""+tableName;
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
		return size;
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
	
	public Tuple removeLastTuple() {
		return tuples.remove(tuples.size()-1);
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public void insertIntoPage(Tuple tuple) throws IOException {
		int position = search(tuple);
		  tuples.add(position, tuple);
		  size++;
		  Serializer.SerializePage(name, this);
		  newMinMax();
	}
	
	public void newMinMax() {
		minPK = tuples.get(0).getPrimaryKey();
		maxPK = tuples.get(tuples.size()-1).getPrimaryKey();
	}

	
	public int search(Tuple tuple) {
		return 0;
	}
	

	public boolean isFull() {
		return size==maxRows;
	}
	public int binarySearch(String value) {
		return new PageSearch(this).binarySearch(value);
	}
	public HashMap<Tuple,Integer> linearSearch(String colName , String value) {
		return new PageSearch(this).linearSearch(colName, value);
	}

}
