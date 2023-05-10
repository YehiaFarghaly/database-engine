package storage.index;

import java.util.*;

public class OctreeIndex<T> {
	private OctreeNode<T> root;

	public OctreeIndex(OctreeBounds bounds) {
		root = new OctreeNode<>(bounds);
	}

	public void add(T item, OctreeBounds itemBounds) {
		root.add(item, itemBounds);
	}

	public void remove(T item, OctreeBounds itemBounds) {
		root.remove(item, itemBounds);
	}

	public List<T> query(OctreeBounds searchBounds) {
		List<T> result = new ArrayList<>();
		root.query(searchBounds, result);
		return result;
	}
}
