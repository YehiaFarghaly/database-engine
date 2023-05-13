package storage.index;

import java.io.*;
import java.util.*;

import constants.Constants;
import exceptions.DBAppException;
import util.filecontroller.ConfigReader;

//CHECKSTYLE:OFF

class OctreeNode<T> {
	private final OctreeBounds bounds;
	private final List<Item<T>> items;
	private final OctreeNode<T>[] children;
	private final int maxSize;

	public OctreeNode(OctreeBounds bounds) throws DBAppException {
		this.bounds = bounds;
		items = new ArrayList<>();
		children = new OctreeNode[8];
		Properties prop = ConfigReader.readProperties();
		maxSize = Integer.parseInt(prop.getProperty(Constants.MAX_ENTRIES_IN_OCTREENODE));
	}

	public boolean add(Item<T> item, OctreeBounds itemBounds) throws IOException, DBAppException {
		if (!getBounds().contains(itemBounds)) {
			return false;
		}
		if (getChildren()[0] != null) {
			// insert into children
			for (int i = 0; i < 8; i++) {
				if (getChildren()[i].add(item, itemBounds))
					return true;
			}
		} else {
			// insert into leaf node
			for (Item<T> itm : getItems()) {
				// handle duplicates
				if (itm.equals(item)) {
					itm.add(item.getData());
					return true;
				}
			}
			getItems().add(item);
			if (getItems().size() > getMaxSize()) {
				split();
			}
		}
		return true;
	}

	public void remove(Object ref, OctreeBounds itemBounds) throws DBAppException {
		if (!getBounds().intersects(itemBounds)) {
			return;
		}
		if (getChildren()[0] != null) {
			// remove from children
			for (int i = 0; i < 8; i++) {
				getChildren()[i].remove(ref, itemBounds);
			}
			int size = 0;
			for (int i = 0; i < 8; i++) {
				if (getChildren()[i] != null)
					return;
				size += getChildren()[i].getItems().size();
			}
			// merging back into parent
			if (size <= getMaxSize()) {
				for (int i = 0; i < 8; i++) {
					for (Item<T> item : getChildren()[i].getItems()) {
						getItems().add(item);
					}
					getChildren()[i] = null;
				}
			}

		} else {
			// remove from leaf node
			for (int i = 0; i < getItems().size(); i++) {
				Item<T> item = getItems().get(i);
				if (itemBounds.contains(getBounds(item))) {
					if (ref == null || item.getDuplicates().isEmpty()) {
						getItems().remove(i);
						i--;
					} else {
						item.getDuplicates().remove(ref);
					}
				}
			}
		}
	}

	public void query(OctreeBounds searchBounds, List<Object> result) throws DBAppException {
		if (!getBounds().intersects(searchBounds)) {
			return;
		}
		// search in children
		if (getChildren()[0] != null) {
			for (int i = 0; i < 8; i++) {
				getChildren()[i].query(searchBounds, result);
			}
		} else {
			// search in leaf node
			for (Item<T> item : getItems()) {
				OctreeBounds itemBounds = getBounds(item);
				if (searchBounds.contains(itemBounds)) {
					result.add(item.getData());
					for (Object dup : item.getDuplicates()) {
						result.add(dup);
					}
				}
			}
		}
	}

	private void split() throws IOException, DBAppException {
		Object x0 = getBounds().getMin().getX();
		Object x1 = getBounds().getMax().getX();
		Object y0 = getBounds().getMin().getY();
		Object y1 = getBounds().getMax().getY();
		Object z0 = getBounds().getMin().getZ();
		Object z1 = getBounds().getMax().getZ();
		Object xMid = getMid(x0, x1);
		Object yMid = getMid(y0, y1);
		Object zMid = getMid(z0, z1);

		getChildren()[0] = new OctreeNode<>(new OctreeBounds(x0, y0, z0, xMid, yMid, zMid));
		getChildren()[1] = new OctreeNode<>(new OctreeBounds(xMid, y0, z0, x1, yMid, zMid));
		getChildren()[2] = new OctreeNode<>(new OctreeBounds(x0, yMid, z0, xMid, y1, zMid));
		getChildren()[3] = new OctreeNode<>(new OctreeBounds(xMid, yMid, z0, x1, y1, zMid));
		getChildren()[4] = new OctreeNode<>(new OctreeBounds(x0, y0, zMid, xMid, yMid, z1));
		getChildren()[5] = new OctreeNode<>(new OctreeBounds(xMid, y0, zMid, x1, yMid, z1));
		getChildren()[6] = new OctreeNode<>(new OctreeBounds(x0, yMid, zMid, xMid, y1, z1));
		getChildren()[7] = new OctreeNode<>(new OctreeBounds(xMid, yMid, zMid, x1, y1, z1));

		// insert into children then clear my list
		for (Item<T> item : getItems()) {
			OctreeBounds itemBounds = getBounds(item);
			for (int i = 0; i < 8; i++) {
				if (getChildren()[i].add(item, itemBounds)) {
					break;
				}
			}
		}
		getItems().clear();
	}

	private OctreeBounds getBounds(Item<T> item) {
		return new OctreeBounds(item.getX(), item.getY(), item.getZ(), item.getX(), item.getY(), item.getZ());
	}

	private Object getMid(Object min, Object max) throws DBAppException {
		if (min instanceof Integer) {
			return (((Integer) min) + ((Integer) max)) / 2;
		}
		if (min instanceof Double) {
			return (((Double) min) + ((Double) max)) / 2;
		}
		if (min instanceof Date) {
			return new Date((((Date) min).getTime() + ((Date) max).getTime()) / 2);
		}
		if (min instanceof String) {
			return getMiddleString((String) min, (String) max,
					Math.min(((String) max).length(), ((String) min).length()));
		}
		throw new DBAppException(Constants.ERROR_MESSAGE_DATATYPE);
	}

	private String getMiddleString(String S, String T, int N) {
		int[] a1 = new int[N + 1];
		for (int i = 0; i < N; i++)
			a1[i + 1] = (int) S.charAt(i) - 97 + (int) T.charAt(i) - 97;
		for (int i = N; i >= 1; i--) {
			a1[i - 1] += a1[i] / 26;
			a1[i] %= 26;
		}
		for (int i = 0; i <= N; i++) {
			if ((a1[i] & 1) != 0)
				if (i + 1 <= N)
					a1[i + 1] += 26;
			a1[i] = a1[i] / 2;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++)
			sb.append((char) (a1[i] + 97));
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

//CHECKSTYLE:ON