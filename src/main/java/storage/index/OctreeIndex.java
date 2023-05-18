package storage.index;

import java.io.Serializable;
import java.util.*;
import constants.Constants;
import datamanipulation.CsvReader;
import exceptions.DBAppException;
import storage.Page;
import storage.Tuple;
import util.TypeParser;
import util.filecontroller.Serializer;

public class OctreeIndex<T> implements Serializable {
	private static final long serialVersionUID = 4835109290601395974L;
	private final String colName1, colName2, colName3;
	private OctreeNode<T> root;
	private String tableName, name;

	public OctreeIndex(String tableName, String col1, String col2, String col3) throws DBAppException {
		this.tableName = tableName;
		colName1 = col1;
		colName2 = col2;
		colName3 = col3;
		name = colName1+ colName2 + colName3;
		root = new OctreeNode<>(createBounds(col1, col2, col3));
	}

	private OctreeBounds createBounds(String col1, String col2, String col3) {
		Object col1Min = null, col2Min = null, col3Min = null, col1Max = null, col2Max = null, col3Max = null;
		CsvReader reader = new CsvReader();
		List<String[]> columns = reader.readTable(tableName);

		for (String[] arr : columns) {
			if (arr[Constants.COLUMN_NAME_INDEX].equals(col1)) {

				col1Min = TypeParser.typeParser(arr[Constants.COL_MIN_VALUE_INDEX], arr[Constants.COLUMN_TYPE_INDEX]);
				col1Max = TypeParser.typeParser(arr[Constants.COL_MAX_VALUE_INDEX], arr[Constants.COLUMN_TYPE_INDEX]);
			} else if (arr[Constants.COLUMN_NAME_INDEX].equals(col2)) {
				col2Min = TypeParser.typeParser(arr[Constants.COL_MIN_VALUE_INDEX], arr[Constants.COLUMN_TYPE_INDEX]);
				col2Max = TypeParser.typeParser(arr[Constants.COL_MAX_VALUE_INDEX], arr[Constants.COLUMN_TYPE_INDEX]);
			} else if (arr[Constants.COLUMN_NAME_INDEX].equals(col3)) {
				col3Min = TypeParser.typeParser(arr[Constants.COL_MIN_VALUE_INDEX], arr[Constants.COLUMN_TYPE_INDEX]);
				col3Max = TypeParser.typeParser(arr[Constants.COL_MAX_VALUE_INDEX], arr[Constants.COLUMN_TYPE_INDEX]);
			}
		}
		return new OctreeBounds(col1Min, col2Min, col3Min, col1Max, col2Max, col3Max);
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

	public void removeOneTuple(Page page, Tuple tuple) throws DBAppException {
		if (!suitableIndex(tuple))
			return;
		OctreeBounds itemBounds = getBoundsForRemove(tuple);

		root.remove(Serializer.getPath(page.getTableName(), page.getName()), itemBounds);
	}

	public void remove(Page page, Tuple tuple) throws DBAppException {
		if (!suitableIndex(tuple))
			return;

		OctreeBounds itemBounds = getBoundsForRemove(tuple);

		root.remove(null, itemBounds);
	}

	private OctreeBounds getBoundsForRemove(Tuple tuple) {
		Object x = tuple.get(colName1);
		Object y = tuple.get(colName2);
		Object z = tuple.get(colName3);
		OctreeBounds itemBounds = new OctreeBounds(x, y, z, x, y, z);
		return itemBounds;
	}

	public List<Object> query(OctreeBounds searchBounds, int minBoundType, int maxBoundType) throws DBAppException {
		List<Object> result = new ArrayList<>();
		root.query(searchBounds, minBoundType, maxBoundType, result);
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
	
	public String getName() {
		return name;
	}
}
