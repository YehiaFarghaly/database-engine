package storage;

import java.io.IOException;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;

import Serializerium.Serializer;
import exceptions.DBAppException;
import search.TableSearch;

public class Table implements Serializable {
	public Vector<String> getPagesName() {
		return pagesName;
	}

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
		
		tuple.setPrimaryKey(htblColNameValue.get(PKColumn));

		return tuple;
	}
	

}
