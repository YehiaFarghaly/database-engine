package storage;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Vector;

import Serializerium.Serializer;
import exceptions.DBAppException;
import search.PageSearch;
import search.TableSearch;

public class Table implements Serializable {
	private Vector<String> pagesName;
	private String name, PKColumn;
	private Tuple prototype;
	private Hashtable<String, String> colNameType, colNameMin, colNameMax;

	// we still need to store Pages

	public Table(String name, String PK, Hashtable<String, String> colNameType, Hashtable<String, String> colNameMin,
			Hashtable<String, String> colNameMax) {

		this.name = name;
		this.PKColumn = PK;
		this.colNameType = colNameType;
		this.colNameMin = colNameMin;
		this.colNameMax = colNameMax;
		pagesName = new Vector<String>();

	}
	
	public Vector<String> getPagesName() {
		return pagesName;
	}

	public void setPagesName(Vector<String> pagesName) {
		this.pagesName = pagesName;
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
			throws DBAppException, ClassNotFoundException, IOException {

		Tuple tuple = createTuple(htblColNameValue);

		if (isEmptyTable()) {

			insertNewPage(tuple);

		} else {

			int position = search(tuple);

			Page page = getPageAtPosition(position);

			if (page.isFull()) {

				handleFullPageInsertion(page, position, tuple);
			}

			else {

				page.insertIntoPage(tuple);
			}

		}

	}
	
	public void DeleteTuples(Hashtable<String, Object> htblColNameValue) throws ClassNotFoundException, IOException, DBAppException, ParseException
	{
		
		for (String colName : htblColNameValue.keySet()) {
			
			Object value = htblColNameValue.get(colName);
			iterateOverPageName(colName,value);
			
		}
	}
	public void iterateOverPageName(String colName,Object value) throws ClassNotFoundException, IOException, DBAppException, ParseException 
	{
		for(String PageName : this.getPagesName())
		{
			Page page = Serializer.deserializePage(PageName);
			HashMap<Tuple, Integer> ToBeDelete = page.linearSearch(colName, value.toString());
			deletePageRecords(ToBeDelete,page);
		}
	}
	public void deletePageRecords(HashMap<Tuple, Integer> ToBeDelete, Page page) throws IOException
	{
		for(Tuple tuple : ToBeDelete.keySet())
			page.DeleteFromPage(tuple);

		if(page.isEmpty())
			deleteEmptyPage(page);
	}

	public void deleteEmptyTable() {
		File pagefile = new File(this.name);
		pagefile.delete();
		
	}

	private void handleFullPageInsertion(Page currentPage, int position, Tuple tuple)
			throws ClassNotFoundException, IOException {

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
	
	private void deleteEmptyPage(Page page) throws IOException
	{
		this.getPagesName().remove(page.getName());
		page.DeleteEmptyPage();
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

	private void newLastPage(Page currentPage, Tuple tuple) throws IOException {

		currentPage.insertIntoPage(tuple);
		Tuple lastTuple = currentPage.removeLastTuple();
		insertNewPage(lastTuple);
	}

	private void insertNewPage(Tuple tuple) throws IOException {
		// TODO a new file must be created here
		Page page = new Page(name);
		page.insertIntoPage(tuple);
		pagesName.add(page.getName());
	}

	private boolean atLastPage(int position) {
		return position == pagesName.size() - 1;
	}

	public Page getPageAtPosition(int position) throws ClassNotFoundException, IOException {

		String pageName = pagesName.get(position);
		Page page = Serializer.deserializePage(pageName);
		return page;

	}

	public boolean isEmptyTable() {
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
		
		tuple.setPrimaryKey(htblColNameValue.get(PKColumn));

		return tuple;
	}
	
	

	public Vector<Tuple> search(String colName, String value) {
		return TableSearch.search(this, colName, value);
	}
	public HashMap<String ,HashMap<Tuple, Integer>> TablelinearSearch(String colName, String value) {
		return TableSearch.linearSearch(this, colName, value);
	}

	public int search(Tuple t) {
		return 0;
	}

	public Vector<Tuple> searchGreaterThan(String colName, String value) {
		return TableSearch.searchGreaterThan(this, colName, value);
	}

	public Vector<Tuple> searchGreaterThanOrEqual(String colName, String value) {
		return TableSearch.searchGreaterThanOrEqual(this, colName, value);
	}

	public Vector<Tuple> searchLessThan(String colName, String value) {
		return TableSearch.searchLessThan(this, colName, value);
	}

	public Vector<Tuple> searchLessThanOrEqual(String colName, String value) {
		return TableSearch.searchLessThanOrEqual(this, colName, value);
	}

	public Vector<Tuple> searchNotEqual(String colName, String value) {
		return TableSearch.searchNotEqual(this, colName, value);
	}
}
