package storage;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.Vector;

import Serializerium.Serializer;
import constants.Constants;
import exceptions.DBAppException;
import search.TableSearch;


public class Table implements Serializable {
	public Vector<String> getPagesName() {
		return pagesName;
	}
    private int cntPage;
	private Vector<String> pagesName;
	private String name, PKColumn;
	private Tuple prototype;
	private Hashtable<String, String> colNameType, colNameMin, colNameMax;


	public Table(String name, String PK, Hashtable<String, String> colNameType, Hashtable<String, String> colNameMin,
				 Hashtable<String, String> colNameMax) {
        cntPage = 0;
		this.name = name;
		this.PKColumn = PK;
		this.colNameType = colNameType;
		this.colNameMin = colNameMin;
		this.colNameMax = colNameMax;
		pagesName = new Vector<String>();

	}

	public Tuple getPrototype() {
		if (this.prototype == null) {
			TupleDirector tupDir = new TupleDirector(new TupleBuilder());
			tupDir.makeTuple(getColNameType());
			this.prototype = tupDir.getTuple();
		}
		return this.prototype.getCopy();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPKColumn() {
		return PKColumn;
	}

	public void setPKColumn(String pKColumn) {
		PKColumn = pKColumn;
	}

	public Hashtable<String, String> getColNameType() {
		return colNameType;
	}

	public void setColNameType(Hashtable<String, String> colNameType) {
		this.colNameType = colNameType;
	}

	public Hashtable<String, String> getColNameMin() {
		return colNameMin;
	}

	public void setColNameMin(Hashtable<String, String> colNameMin) {
		this.colNameMin = colNameMin;
	}

	public Hashtable<String, String> getColNameMax() {
		return colNameMax;
	}

	public void setColNameMax(Hashtable<String, String> colNameMax) {
		this.colNameMax = colNameMax;
	}

	public void insertTuple(Hashtable<String, Object> htblColNameValue)
			throws DBAppException, ClassNotFoundException, IOException, ParseException {

		Tuple tuple = createTuple(htblColNameValue);

		if (isEmptyTable()) {

			insertNewPage(tuple);

		} else {

			int position =  tableBinarySearch(tuple.getPrimaryKey());

			Page page = getPageAtPosition(position);

			if (page.isFull()) {

				handleFullPageInsertion(page, position, tuple);
			} else {

				page.insertIntoPage(tuple);
			}

		}

	}

	private void handleFullPageInsertion(Page currentPage, int position, Tuple tuple)
			throws ClassNotFoundException, IOException, DBAppException, ParseException {

		if (atLastPage(position)) {
			newLastPage(currentPage, tuple);
		} else {
			Page nextAvailablePage = getNextAvailablePage(position, currentPage, tuple);

			Page nextPage = getPageAtPosition(++position);
			currentPage.insertIntoPage(tuple);
			Tuple lastTuple = currentPage.removeLastTuple();

			while (!arePagesEqual(nextPage, nextAvailablePage)) {

				currentPage = nextPage;
				nextPage = getPageAtPosition(++position);
				currentPage.insertIntoPage(lastTuple);
				lastTuple = currentPage.removeLastTuple();

			}

			nextAvailablePage.insertIntoPage(lastTuple);

		}

	}

	private boolean arePagesEqual(Page page1, Page page2) {
		return page1.getName().equals(page2.getName());
	}

	private Page getNextAvailablePage(int position, Page currentPage, Tuple tuple)
			throws ClassNotFoundException, IOException {
		Page nextPage = getPageAtPosition(++position);
		while (nextPage.isFull()) {
			if (atLastPage(position)) {
				Page newPage = new Page(name);
				pagesName.add(newPage.getName());
				return newPage;
			}
			nextPage = getPageAtPosition(++position);

		}
		return nextPage;
	}

	private void newLastPage(Page currentPage, Tuple tuple) throws IOException, DBAppException, ParseException {

		currentPage.insertIntoPage(tuple);
		Tuple lastTuple = currentPage.removeLastTuple();
		insertNewPage(lastTuple);
	}

	private void insertNewPage(Tuple tuple) throws IOException, DBAppException, ParseException {
		Page page = new Page(name);
		page.insertIntoPage(tuple);
		page.setName((cntPage++)+"");
		pagesName.add(page.getName());
	}

	private boolean atLastPage(int position) {
		return position == pagesName.size() - 1;
	}

	public Page getPageAtPosition(int position) throws ClassNotFoundException, IOException {

		String pageName = pagesName.get(position);
		Page page = Serializer.deserializePage(this.getName(),pageName);
		return page;
	}

	private boolean isEmptyTable() {
		return pagesName.size() == 0;
	}

	public Tuple createTuple(Hashtable<String, Object> htblColNameValue) {

		Tuple tuple = getPrototype();

		for (Cell c : tuple.getCells()) {

			c.setValue(htblColNameValue.get(c.getKey()));

			if(c.getKey().equals(getPKColumn())) {
				tuple.setPrimaryKey(c.getValue());
			}

		}

		return tuple;
	}
	
	public void DeleteTuples(Hashtable<String, Object> htblColNameValue) throws ClassNotFoundException, IOException, DBAppException, ParseException
	{

		for (String colName : htblColNameValue.keySet()) {

			Object value = htblColNameValue.get(colName);
			iterateOverPageName(colName,value);

		}
	}
	
	private void iterateOverPageName(String colName,Object value) throws ClassNotFoundException, IOException, DBAppException, ParseException 
	{
		for(String PageName : this.getPagesName())
		{
			Page page = Serializer.deserializePage(name,PageName);
			Vector<Tuple> toBeDeleted = page.linearSearch(colName, value);
			deletePageRecords(toBeDeleted,page);
		}
	}
	
	private void deletePageRecords(Vector<Tuple> toBeDeleted, Page page) throws IOException, DBAppException, ParseException
	{
		for(Tuple tuple : toBeDeleted)
			page.DeleteFromPage(tuple);
	}
	
	public void updateRecordsInTaple(Object clusteringKeyValue,
			Hashtable<String, Object> htblColNameValue) throws ClassNotFoundException, IOException, DBAppException, ParseException {
		Page page = getPageToUpdate(clusteringKeyValue);
		page.updateTuple(clusteringKeyValue, htblColNameValue);
	}
	
	private  Page getPageToUpdate(Object clusteringKeyValue)
			throws ClassNotFoundException, IOException, DBAppException, ParseException {
		int pkPagePosition =  tableBinarySearch(clusteringKeyValue);
		return getPageAtPosition(pkPagePosition);
	}
	
	private int tableBinarySearch(Object primaryKey) throws ClassNotFoundException, DBAppException, ParseException, IOException {
		return TableSearch.binarySearchPages(this,primaryKey);
	}


	public void createTableFiles() throws IOException {
		File createFolder = new File(this.getName());
		createFolder.mkdir();
		File createFile = new File(this.getName()+"//"+this.getName()+ Constants.DATA_EXTENSTION);
		createFile.createNewFile();
	}

	public void deleteTableFile() {
		File folder = new File(getAbsPath());
		if (folder.isDirectory()) {
			File[] files = folder.listFiles();
			if (files != null)
				for (File file : files)
					file.delete();
			folder.delete();
		}
	}

	public String getAbsPath(){return Paths.get("").toAbsolutePath().toString() + "//" + getName();}

}
