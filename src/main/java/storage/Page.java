package storage;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import Serializerium.Serializer;
import constants.Constants;
import exceptions.DBAppException;
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
	
	public void insertIntoPage(Tuple tuple) throws IOException, DBAppException, ParseException {
		int position = pageBinarySearch(tuple.getPrimaryKey());
		  tuples.add(position, tuple);
		  size++;
		  Serializer.SerializePage(name, this);
		  newMinMax();
	}
	
	public void DeleteFromPage(Tuple tuple) throws IOException, DBAppException, ParseException {
		int position = pageBinarySearch(tuple.getPrimaryKey());
		if(position!=-1) {
		  tuples.remove(position);
		  size--;
		  Serializer.SerializePage(name, this);
		  newMinMax();
		  handleEmptyPage();
		}
		else {
			throw new DBAppException(Constants.ERROR_MESSAGE_SEARCH_NOT_FOUND);
		}
	}
	
	public  void updateTuple(Object clusteringKeyValue,Hashtable<String, Object> htblColNameValue) throws DBAppException, ParseException {
		int pkVectorPoition = pageBinarySearch(clusteringKeyValue);
		Tuple tuple=tuples.get(pkVectorPoition);
		
		for (Cell c : tuple.getCells()) {
			c.setValue(htblColNameValue.get(c.getKey()));
		}

	}
	
	private void handleEmptyPage() throws IOException {
		if(tuples.isEmpty()) DeleteEmptyPage();
	}
	
	public void DeleteEmptyPage() throws IOException {
		 File pagefile = new File(this.name);
		 pagefile.delete();
	}
	
	public void newMinMax() {
		minPK = tuples.get(0).getPrimaryKey();
		maxPK = tuples.get(tuples.size()-1).getPrimaryKey();
	}

	
	public int pageBinarySearch(Object primaryKey) throws DBAppException, ParseException {
		return PageSearch.binarySearch(this,primaryKey);
	}
	

	public boolean isFull() {
		return size==maxRows;
	}
	
	public Vector<Tuple> linearSearch(String colName , Object value) throws DBAppException, ParseException {
		return PageSearch.linearSearch(this, colName, value);
	}


}
