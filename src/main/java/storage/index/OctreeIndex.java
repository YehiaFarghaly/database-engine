package storage.index;

import java.io.IOException;
import java.util.*;

import exceptions.DBAppException;

public class OctreeIndex<T> {
	private final Object colName1, colName2, colName3;
	private OctreeNode<T> root;

	public OctreeIndex(OctreeBounds bounds, Object col1, Object col2, Object col3) throws DBAppException {
		colName1 = col1;
		colName2 = col2;
		colName3 = col3;
		root = new OctreeNode<>(bounds);
	}

	// add record at x,y,z with page reference
	public void add(Object ref, Object x, Object y, Object z) throws IOException, DBAppException {
		OctreeBounds itemBounds = new OctreeBounds(x, y, z, x, y, z);
		getRoot().add(new Item<>(x, y, z, ref), itemBounds);

	}

	public void remove(OctreeBounds itemBounds) throws DBAppException {
		remove(null, itemBounds);
	}

	// x0,y0,z0 : oldVals .... x1,y1,z1 : newVals
	public void update(Object x0, Object y0, Object z0, Object x1, Object y1, Object z1, Object oldRef, Object newRef)
			throws DBAppException, IOException {

		remove(oldRef, new OctreeBounds(x0, y0, z0, x0, y0, z0));
		add(newRef, x1, y1, z1);

	}

	private void remove(Object ref, OctreeBounds itemBounds) throws DBAppException {
		getRoot().remove(ref, itemBounds);
	}

	// query range from x0-x1, y0-y1, z0-z1
	public List<Object> query(OctreeBounds searchBounds) throws DBAppException {
		List<Object> result = new ArrayList<>();
		getRoot().query(searchBounds, result);
		return result;
	}

	public Object getColName1() {
		return colName1;
	}

	public Object getColName2() {
		return colName2;
	}

	public Object getColName3() {
		return colName3;
	}

	public OctreeNode<T> getRoot() {
		return root;
	}
}
