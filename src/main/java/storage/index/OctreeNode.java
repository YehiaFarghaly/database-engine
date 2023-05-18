package storage.index;

import java.io.Serializable;
import java.util.*;
import constants.Constants;
import exceptions.DBAppException;
import util.filecontroller.ConfigReader;

public class OctreeNode<T> implements Serializable {
	private static final long serialVersionUID = 4771709168704730297L;
	private final OctreeBounds bounds;
	private final List<Item<T>> items;
	private final OctreeNode<T>[] children;
	private final int maxSize;

	protected OctreeNode(OctreeBounds bounds) throws DBAppException {
		this.bounds = bounds;
		items = new ArrayList<>();
		children = new OctreeNode[Constants.NUMBER_OF_NODE_CHILDREN];
		Properties prop = ConfigReader.readProperties();
		maxSize = Integer.parseInt(prop.getProperty(Constants.MAX_ENTRIES_IN_OCTREENODE));
	}

	protected boolean add(Item<T> item, OctreeBounds itemBounds) throws DBAppException {
		if (!bounds.contains(itemBounds, 0, 0)) {
			return false;
		}
		if (children[0] != null) {
			return nonLeafInsert(item, itemBounds);
		} else {
			return leafInsert(item);
		}
	}

	private boolean nonLeafInsert(Item<T> item, OctreeBounds itemBounds) throws DBAppException {
		for (int i = 0; i < Constants.NUMBER_OF_NODE_CHILDREN; i++) {
			if (children[i].add(item, itemBounds))
				return true;
		}
		return false;
	}

	private boolean leafInsert(Item<T> item) throws DBAppException {
		for (Item<T> itm : items) {
			if (itm.equals(item)) {
				itm.add(item.getData());
				return true;
			}
		}
		items.add(item);
		if (items.size() > maxSize) {
			split();
		}
		return true;
	}

	protected void remove(Object ref, OctreeBounds itemBounds) throws DBAppException {
		if (!bounds.intersects(itemBounds)) {
			return;
		}
		if (children[0] != null) {
			nonLeafRemove(ref, itemBounds);
		} else {
			leafRemove(ref, itemBounds);
		}
	}

	private void nonLeafRemove(Object ref, OctreeBounds itemBounds) throws DBAppException {

		for (int i = 0; i < Constants.NUMBER_OF_NODE_CHILDREN; i++) {
			children[i].remove(ref, itemBounds);
		}
		int size = 0;
		for (int i = 0; i < Constants.NUMBER_OF_NODE_CHILDREN; i++) {
			if (children[i] != null)
				return;
			size += children[i].items.size();
		}
		mergeIntoParents(size);

	}

	private void mergeIntoParents(int size) {
		if (size <= getMaxSize()) {
			for (int i = 0; i < Constants.NUMBER_OF_NODE_CHILDREN; i++) {
				for (Item<T> item : children[i].items) {
					items.add(item);
				}
				children[i] = null;
			}
		}
	}

	private void leafRemove(Object ref, OctreeBounds itemBounds) throws DBAppException {
		for (int i = 0; i < items.size(); i++) {
			Item<T> item = items.get(i);
			if (itemBounds.contains(getBounds(item), 0, 0)) {
				if (ref == null || item.getDuplicates().isEmpty()) {
					items.remove(i);
					i--;
				} else {
					item.getDuplicates().remove(ref);
				}
			}
		}
	}

	protected void query(OctreeBounds searchBounds, int minBoundType, int maxBoundType, List<Object> result)
			throws DBAppException {
		if (!bounds.intersects(searchBounds)) {
			return;
		}
		if (children[0] != null) {
			nonLeafSearch(searchBounds, minBoundType, maxBoundType, result);
		} else {
			leafSearch(searchBounds, minBoundType, maxBoundType, result);
		}
	}

	private void nonLeafSearch(OctreeBounds searchBounds, int minBoundType, int maxBoundType, List<Object> result)
			throws DBAppException {
		for (int i = 0; i < Constants.NUMBER_OF_NODE_CHILDREN; i++) {
			children[i].query(searchBounds, minBoundType, maxBoundType, result);
		}
	}

	private void leafSearch(OctreeBounds searchBounds, int minBoundType, int maxBoundType, List<Object> result)
			throws DBAppException {
		for (Item<T> item : getItems()) {
			OctreeBounds itemBounds = getBounds(item);
		
			if (searchBounds.contains(itemBounds, minBoundType, maxBoundType)) {
				result.add(item.getData());
				for (Object dup : item.getDuplicates()) {
					result.add(dup);
				}
			}
		}
	}

	private void split() throws DBAppException {
		setNewBounds();
		insertIntoChildren();
		items.clear();
	}

	private void setNewBounds() throws DBAppException {
		Object x0 = bounds.getMin().getX();
		Object x1 = bounds.getMax().getX();
		Object y0 = bounds.getMin().getY();
		Object y1 = bounds.getMax().getY();
		Object z0 = bounds.getMin().getZ();
		Object z1 = bounds.getMax().getZ();
		Object xMid = getMid(x0, x1);
		Object yMid = getMid(y0, y1);
		Object zMid = getMid(z0, z1);

		children[0] = new OctreeNode<>(new OctreeBounds(x0, y0, z0, xMid, yMid, zMid));
		children[1] = new OctreeNode<>(new OctreeBounds(xMid, y0, z0, x1, yMid, zMid));
		children[2] = new OctreeNode<>(new OctreeBounds(x0, yMid, z0, xMid, y1, zMid));
		children[3] = new OctreeNode<>(new OctreeBounds(xMid, yMid, z0, x1, y1, zMid));
		children[4] = new OctreeNode<>(new OctreeBounds(x0, y0, zMid, xMid, yMid, z1));
		children[5] = new OctreeNode<>(new OctreeBounds(xMid, y0, zMid, x1, yMid, z1));
		children[6] = new OctreeNode<>(new OctreeBounds(x0, yMid, zMid, xMid, y1, z1));
		children[7] = new OctreeNode<>(new OctreeBounds(xMid, yMid, zMid, x1, y1, z1));
	}

	private void insertIntoChildren() throws DBAppException {
		for (Item<T> item : items) {
			OctreeBounds itemBounds = getBounds(item);
			for (int i = 0; i < Constants.NUMBER_OF_NODE_CHILDREN; i++) {
				if (children[i].add(item, itemBounds)) {
					break;
				}
			}
		}
	}

	private OctreeBounds getBounds(Item<T> item) {
		return new OctreeBounds(item.getX(), item.getY(), item.getZ(), item.getX(), item.getY(), item.getZ());
	}

	private Object getMid(Object min, Object max) throws DBAppException {
		if (min instanceof Integer) {
			return midOfInteger(min, max);
		}
		if (min instanceof Double) {
			return midOfDouble(min, max);
		}
		if (min instanceof Date) {
			return midOfDate(min, max);
		}
		if (min instanceof String) {
			return midOfString(min, max);
		}
		throw new DBAppException(Constants.ERROR_MESSAGE_DATATYPE);
	}

	private Object midOfInteger(Object min, Object max) {
		return (((Integer) min) + ((Integer) max)) / 2;
	}

	private Object midOfDouble(Object min, Object max) {
		return (((Double) min) + ((Double) max)) / 2;
	}

	private Object midOfDate(Object min, Object max) {
		return new Date((((Date) min).getTime() + ((Date) max).getTime()) / 2);
	}

	private Object midOfString(Object min, Object max) {
		return getMiddleString((String) min, (String) max, Math.min(((String) max).length(), ((String) min).length()));
	}

	private String getMiddleString(String min, String max, int size) {
		int[] a1 = new int[size + 1];
		for (int i = 0; i < size; i++)
			a1[i + 1] = (int) min.charAt(i) - Constants.ASCII_OF_FIRST_ALPHAPET + (int) max.charAt(i)
					- Constants.ASCII_OF_FIRST_ALPHAPET;
		for (int i = size; i >= 1; i--) {
			a1[i - 1] += a1[i] / Constants.NUM_OF_ALPHAPET;
			a1[i] %= Constants.NUM_OF_ALPHAPET;
		}
		for (int i = 0; i <= size; i++) {
			if ((a1[i] & 1) != 0)
				if (i + 1 <= size)
					a1[i + 1] += Constants.NUM_OF_ALPHAPET;
			a1[i] = a1[i] / 2;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= size; i++)
			sb.append((char) (a1[i] + Constants.ASCII_OF_FIRST_ALPHAPET));
		return sb.toString();
	}

	public OctreeBounds getBounds() {
		return bounds;
	}

	public List<Item<T>> getItems() {
		return items;
	}

	public OctreeNode<T>[] getChildren() {
		return children;
	}

	public int getMaxSize() {
		return maxSize;
	}
}
