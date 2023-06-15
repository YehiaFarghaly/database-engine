package storage;

import constants.Constants;
import datamanipulation.CsvReader;
import exceptions.DBAppException;
import storage.index.DBAppNull;
import storage.index.OctreeBounds;
import storage.index.OctreeIndex;
import util.filecontroller.FileCreator;
import util.filecontroller.FileDeleter;
import util.filecontroller.FileType;
import util.filecontroller.Serializer;
import util.search.TableSearch;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;
import java.util.List;

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
	private Vector<OctreeIndex<?>> indices;

	public Table(String name, String pkColumn, Hashtable<String, String> colNameType,
			Hashtable<String, String> colNameMin, Hashtable<String, String> colNameMax) {
		cntPage = 0;
		size = 0;
		this.indices = new Vector<>();
		this.name = name;
		this.pkColumn = pkColumn;
		this.colNameType = colNameType;
		this.colNameMin = colNameMin;
		this.colNameMax = colNameMax;
		pagesName = new Vector<String>();
		primaryKeyType = colNameType.get(pkColumn);
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

	public Vector<OctreeIndex<?>> getIndices() {
		return indices;
	}

	public Vector<Tuple> select(Hashtable<String, Object> colNameValue, String operator) throws DBAppException {
		Vector<Tuple> result = new Vector<>();
		for (int i = 0; i < pagesName.size(); i++) {
			Page page = getPageAtPosition(i);
			result.addAll(page.select(colNameValue, operator));
		}
		return result;
	}

	public void insertTuple(Hashtable<String, Object> htblColNameValue) throws DBAppException {
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
				page.insertIntoPage(tuple, indices);
			}
		}
		size++;
	}

	public Tuple createTuple(Hashtable<String, Object> htblColNameValue) {
		Tuple tuple = getPrototype();

		for (Cell c : tuple.getCells()) {
			c.setValue(htblColNameValue.get(c.getKey()) == null ? new DBAppNull() : htblColNameValue.get(c.getKey()));
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

	public Page getPageAtPosition(int position) throws DBAppException {
		String pageName = pagesName.get(position);
		Page page = Serializer.deserializePage(this.getName(), pageName);
		return page;
	}

	public int tableBinarySearch(Object primaryKey) throws DBAppException {
		return TableSearch.binarySearchPages(this, primaryKey);
	}

	private void handleFullPageInsertion(Page currentPage, int position, Tuple tuple) throws DBAppException {
		if (atLastPage(position)) {
			newLastPage(currentPage, tuple);

		} else {
			Page nextAvailablePage = getNextAvailablePage(position, currentPage, tuple);
			Page nextPage = getPageAtPosition(++position);
			currentPage.insertIntoPage(tuple, indices);
			Tuple lastTuple = currentPage.removeLastTuple(indices);

			while (!arePagesEqual(nextPage, nextAvailablePage)) {
				currentPage = nextPage;
				nextPage = getPageAtPosition(++position);
				currentPage.insertIntoPage(lastTuple, indices);
				lastTuple = currentPage.removeLastTuple(indices);
			}
			nextAvailablePage.insertIntoPage(lastTuple, indices);
		}
	}

	private boolean arePagesEqual(Page page1, Page page2) {
		return page1.getName().equals(page2.getName());
	}

	private Page getNextAvailablePage(int position, Page currentPage, Tuple tuple) throws DBAppException {
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

	private void newLastPage(Page currentPage, Tuple tuple) throws DBAppException {
		currentPage.insertIntoPage(tuple, indices);
		Tuple lastTuple = currentPage.removeLastTuple(indices);
		insertNewPage(lastTuple);
	}

	private void insertNewPage(Tuple tuple) throws DBAppException {
		Page page = initializePage();
		page.insertIntoPage(tuple, indices);
	}

	private Page initializePage() throws DBAppException {
		Page page = new Page(name);
		page.setName((cntPage++) + "");
		page.createPageFile();
		pagesName.add(page.getName());
		return page;
	}

	private boolean atLastPage(int position) {
		return position == pagesName.size() - 1;
	}

	public void deleteTuples(Hashtable<String, Object> htblColNameValue) throws DBAppException {
		OctreeIndex index = checkDimensions(htblColNameValue);
		if (index == null) {
			normalDelete(htblColNameValue);
		} else {
			Object[] minMaxValues = new Object[Constants.NUM_OF_DIMENSIONS];
			int idx = 0;
			for (String col : htblColNameValue.keySet()) {
				if (col.equals(index.getColName1()) || col.equals(index.getColName2())
						|| col.equals(index.getColName3()))
					minMaxValues[idx++] = htblColNameValue.get(col);
			}
			indexDelete(minMaxValues, index, htblColNameValue);
		}
		removeEmptyPages();
	}

	public void indexDelete(Object[] minMaxValues, OctreeIndex index, Hashtable<String, Object> htblColNameValue)
			throws DBAppException {
		OctreeBounds searchBounds = new OctreeBounds(minMaxValues[0], minMaxValues[1], minMaxValues[2], minMaxValues[0],
				minMaxValues[1], minMaxValues[2]);
		List<Object> pages = index.query(searchBounds, 0, 0);
		deleteByPage(pages, htblColNameValue, index);
	}

	public void deleteByPage(List<Object> pages, Hashtable<String, Object> htblColNameValue, OctreeIndex index)
			throws DBAppException {
		for (Object pageObj : pages) {
			String pageName = (String) pageObj;
			Page page = Serializer.deserializePage(name, pagesName.get(getPageIdxFromPath(pageName)));
			Vector<Tuple> toBeDeleted = page.linearSearch(htblColNameValue);
			deletePageRecords(toBeDeleted, page);
		}
	}

	public OctreeIndex checkDimensions(Hashtable<String, Object> htblColNameValue) {
		for (OctreeIndex index : indices) {
			ArrayList<String> dimensions = new ArrayList<>();
			for (String col : htblColNameValue.keySet()) {
				if (index.getColName1().equals(col))
					dimensions.add(col);
				else if (index.getColName2().equals(col))
					dimensions.add(col);
				else if (index.getColName3().equals(col))
					dimensions.add(col);
				if (dimensions.size() == Constants.NUM_OF_DIMENSIONS)
					return index;
			}
		}
		return null;
	}

	public int getPageIdxFromPath(String pageName) {

		return pagesName.indexOf((pageName.split("//")[1]).split(".ser")[0]);
	}

	public void normalDelete(Hashtable<String, Object> htblColNameValue) throws DBAppException {
		for (int i = 0; i < pagesName.size(); i++) {
			Page page = Serializer.deserializePage(name, pagesName.get(i));
			Vector<Tuple> toBeDeleted = page.linearSearch(htblColNameValue);
			deletePageRecords(toBeDeleted, page);
		}
	}

	public boolean checkIndexing(String col) {
		CsvReader read = new CsvReader();
		ArrayList<String[]> tableAtri = read.readTable(name);
		boolean ans = false;
		for (String[] table : tableAtri) {
			if (table[1].equals(col)) {
				if (table[5].equals("null"))
					ans = false;
				else
					ans = true;
				break;
			}
		}
		return ans;
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

	private void deletePageRecords(Vector<Tuple> toBeDeleted, Page page) throws DBAppException {
		for (Tuple tuple : toBeDeleted) {
			page.deleteFromPage(tuple, indices);
			size--;
		}
	}

	public void updateRecordsInTaple(Object clusteringKeyValue, Hashtable<String, Object> htblColNameValue)
			throws DBAppException {
		Page page = getPageToUpdate(clusteringKeyValue);
		page.updateTuple(clusteringKeyValue, htblColNameValue, indices);
	}

	private Page getPageToUpdate(Object clusteringKeyValue) throws DBAppException {
		int pkPagePosition = tableBinarySearch(clusteringKeyValue);
		return getPageAtPosition(pkPagePosition);
	}

	public void createTableFiles() throws DBAppException {
		try {
			FileCreator.createTableFolder(this);
			FileCreator.createFile(this, FileType.TABLE);
		} catch (Exception e) {
			throw new DBAppException(e.getMessage());
		}
	}

	public void deleteTableFiles() {
		FileDeleter.deleteFile(this, FileType.TABLE);
	}
  
}
