package storage;

import exceptions.DBAppException;
import util.filecontroller.FileCreator;
import util.filecontroller.FileDeleter;
import util.filecontroller.FileType;
import util.filecontroller.Serializer;
import util.search.TableSearch;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Hashtable;
import java.util.Vector;

public class Table implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 994119161960187256L;
	private int cntPage;
	private Vector<String> pagesName;
	private String name, pkColumn;
	private Tuple prototype;
	private Hashtable<String, String> colNameType, colNameMin, colNameMax;
	private String primaryKeyType;
	private int size;

	public Table(String name, String pkColumn, Hashtable<String, String> colNameType, Hashtable<String, String> colNameMin,
			Hashtable<String, String> colNameMax) {
		cntPage = 0;
		size = 0;
		this.name = name;
		this.pkColumn = pkColumn;
		this.colNameType = colNameType;
		this.colNameMin = colNameMin;
		this.colNameMax = colNameMax;
		pagesName = new Vector<String>();
		primaryKeyType=colNameType.get(pkColumn);
	}
	
	public String getPrimaryKeyType() {
		return primaryKeyType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPKColumn() {
		return pkColumn;
	}

	public void setPKColumn(String pKColumn) {
		pkColumn = pKColumn;
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
	
	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return pagesName.size() == 0;
	}

	public Vector<String> getPagesName() {
		return pagesName;
	}
	

	public void insertTuple(Hashtable<String, Object> htblColNameValue)
			throws DBAppException, ClassNotFoundException, IOException, ParseException {
		removeEmptyPages();
		Tuple tuple = createTuple(htblColNameValue);
		if (isEmpty()) {
			insertNewPage(tuple);
		} else {
			int position = tableBinarySearch(tuple.getPrimaryKey());
			Page page = getPageAtPosition(position);
			if (page.isFull()) {
				handleFullPageInsertion(page, position, tuple);
			} else {
				page.insertIntoPage(tuple);
			}
		}
		size++;
	}

	public Tuple createTuple(Hashtable<String, Object> htblColNameValue) {

		Tuple tuple = getPrototype();

		for (Cell c : tuple.getCells()) {

			c.setValue(htblColNameValue.get(c.getKey()));

			if (c.getKey().equals(getPKColumn())) {
				tuple.setPrimaryKey(c.getValue());
			}

		}

		return tuple;
	}

	private Tuple getPrototype() {
		if (this.prototype == null) {
			TupleDirector tupDir = new TupleDirector(new TupleBuilder());
			tupDir.makeTuple(getColNameType());
			this.prototype = tupDir.getTuple();
		}
		return this.prototype.getCopy();
	}

	public Page getPageAtPosition(int position) throws ClassNotFoundException, IOException {

		String pageName = pagesName.get(position);
		Page page = Serializer.deserializePage(this.getName(), pageName);
		return page;
	}

	public int tableBinarySearch(Object primaryKey)
			throws ClassNotFoundException, DBAppException, ParseException, IOException {
		return TableSearch.binarySearchPages(this, primaryKey);
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
				Page newPage = initializePage();
				Serializer.serializePage(newPage.getName(), newPage);
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
		Page page = initializePage();
		page.insertIntoPage(tuple);
	}
	
	private Page initializePage() throws IOException {
		Page page = new Page(name);
		page.setName((cntPage++) + "");
		page.createPageFile();
		pagesName.add(page.getName());
		return page;
	}

	private boolean atLastPage(int position) {
		return position == pagesName.size() - 1;
	}

	public void deleteTuples(Hashtable<String, Object> htblColNameValue)
			throws ClassNotFoundException, IOException, DBAppException, ParseException {

		for (int i = 0; i < pagesName.size(); i++) {
			Page page = Serializer.deserializePage(name, pagesName.get(i));
			Vector<Tuple> toBeDeleted = page.linearSearch(htblColNameValue);
			deletePageRecords(toBeDeleted, page);
		}

	}

	private void iterateOverPageName(String colName, Object value)
			throws ClassNotFoundException, IOException, DBAppException, ParseException {
		removeEmptyPages();
		for (int i = 0; i < pagesName.size(); i++) {
			Page page = Serializer.deserializePage(name, pagesName.get(i));
			Vector<Tuple> toBeDeleted = page.linearSearch(colName, value);
			deletePageRecords(toBeDeleted, page);
		}
	}

	private void removeEmptyPages() {
		for (int i = 0; i < pagesName.size(); i++) {
			String pageName = pagesName.get(i);
			String path = Serializer.getPath(name, pageName);
			File pageFile = new File(path);
			if (!pageFile.exists()) {
				pagesName.remove(i--);
			}
		}
	}

	private void deletePageRecords(Vector<Tuple> toBeDeleted, Page page)
			throws IOException, DBAppException, ParseException {
		for (Tuple tuple : toBeDeleted) {
			page.deleteFromPage(tuple);
		    size--;	
		}
	}

	public void updateRecordsInTaple(Object clusteringKeyValue, Hashtable<String, Object> htblColNameValue)
			throws ClassNotFoundException, IOException, DBAppException, ParseException {
		Page page = getPageToUpdate(clusteringKeyValue);
		page.updateTuple(clusteringKeyValue, htblColNameValue);
	}

	private Page getPageToUpdate(Object clusteringKeyValue)
			throws ClassNotFoundException, IOException, DBAppException, ParseException {
		int pkPagePosition = tableBinarySearch(clusteringKeyValue);
		return getPageAtPosition(pkPagePosition);
	}

	public void createTableFiles() throws IOException {
		FileCreator.createTableFolder(this);
		FileCreator.createFile(this, FileType.TABLE);
	}

	public void deleteTableFiles() {
		FileDeleter.deleteFile(this, FileType.TABLE);
	}


}
