package storage.index;

import java.util.*;
import exceptions.DBAppException;
import storage.Page;
import storage.Tuple;
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

	public void add(Page page, Tuple tuple) throws DBAppException {
		if (!suitableIndex(tuple))
			return;
		Object x = tuple.get(colName1);
		Object y = tuple.get(colName2);
		Object z = tuple.get(colName3);
		OctreeBounds itemBounds = new OctreeBounds(x, y, z, x, y, z);
		String ref = Serializer.getPath(page.getTableName(), page.getName());
		root.add(new Item<>(x, y, z, ref), itemBounds);

	}

	public void remove(Page page, Tuple tuple) throws DBAppException {
		if (!suitableIndex(tuple))
			return;
		String ref = Serializer.getPath(page.getTableName(), page.getName());
		Object x = tuple.get(colName1);
		Object y = tuple.get(colName2);
		Object z = tuple.get(colName3);
		OctreeBounds itemBounds = new OctreeBounds(x, y, z, x, y, z);
		root.remove(ref, itemBounds);
	}

	public List<Object> query(OctreeBounds searchBounds) throws DBAppException {
		List<Object> result = new ArrayList<>();
		root.query(searchBounds, result);
		return result;
	}

	private boolean suitableIndex(Tuple tuple) {
		if (tuple.contains(colName1) || tuple.contains(colName2) || tuple.contains(colName3))
			return true;
		return false;
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
