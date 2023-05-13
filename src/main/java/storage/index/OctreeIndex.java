package storage.index;

import java.io.IOException;
import java.util.*;
import exceptions.DBAppException;
import storage.Page;
import util.filecontroller.Serializer;

public class OctreeIndex<T> {
	private final String colName1, colName2, colName3;
	private OctreeNode<T> root;

	public OctreeIndex(OctreeBounds bounds, String col1, String col2, String col3) throws DBAppException {
		colName1 = col1;
		colName2 = col2;
		colName3 = col3;
		root = new OctreeNode<>(bounds);
	}

	public void add(Page page, Hashtable<String, Object> tuple) throws DBAppException {
		Object x = tuple.get(colName1);
		Object y = tuple.get(colName2);
		Object z = tuple.get(colName3);
		OctreeBounds itemBounds = new OctreeBounds(x, y, z, x, y, z);
		String ref = Serializer.getPath(page.getTableName(), page.getName());
		getRoot().add(new Item<>(x, y, z, ref), itemBounds);

	}

	public void update(Hashtable<String, Object> oldTuple, Hashtable<String, Object> newTuple, Page oldPage,
			Page newPage) throws DBAppException, IOException {
		remove(oldPage, oldTuple);
		add(newPage, newTuple);
	}

	public void remove(Page page, Hashtable<String, Object> tuple) throws DBAppException {
		String ref = Serializer.getPath(page.getTableName(), page.getName());
		Object x = tuple.get(colName1);
		Object y = tuple.get(colName2);
		Object z = tuple.get(colName3);
		OctreeBounds itemBounds = new OctreeBounds(x, y, z, x, y, z);
		getRoot().remove(ref, itemBounds);
	}

	public List<Object> query(OctreeBounds searchBounds) throws DBAppException {
		List<Object> result = new ArrayList<>();
		getRoot().query(searchBounds, result);
		return result;
	}

	public String getColName1() {
		return colName1;
	}

	public String getColName2() {
		return colName2;
	}

	public String getColName3() {
		return colName3;
	}

	public OctreeNode<T> getRoot() {
		return root;
	}
}
