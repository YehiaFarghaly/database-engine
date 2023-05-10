package storage.index;

import java.util.*;

class OctreeNode<T> {
	private final OctreeBounds bounds;
	private final Vector<T> items;
	private final OctreeNode<T>[] children;

	public OctreeNode(OctreeBounds bounds) {
		this.bounds = bounds;
		items = new Vector<>();
		children = new OctreeNode[8];
	}

	public void add(T item, OctreeBounds itemBounds) {
//        if (!bounds.contains(itemBounds)) {
//            return;
//        }

		if (children[0] != null) {
			for (int i = 0; i < 8; i++) {
				children[i].add(item, itemBounds);
			}
		} else {
			items.add(item);
			if (items.size() > 8) {
				split();
			}
		}
	}

	public void remove(T item, OctreeBounds itemBounds) {
//        if (!bounds.contains(itemBounds)) {
//            return;
//        }

		if (children[0] != null) {
			for (int i = 0; i < 8; i++) {
				children[i].remove(item, itemBounds);
			}
		} else {
			items.remove(item);
		}
	}

	public void query(OctreeBounds searchBounds, List<T> result) {
//        if (!bounds.intersects(searchBounds)) {
//            return;
//        }

		if (children[0] != null) {
			for (int i = 0; i < 8; i++) {
				children[i].query(searchBounds, result);
			}
		} else {
			for (T item : items) {
				OctreeBounds itemBounds = getBounds(item);
//                if (searchBounds.intersects(itemBounds)) {
//                    result.add(item);
//                }
			}
		}
	}

//  double x0 = bounds.getMin().getX();
//  double x1 = bounds.getMax().getX();
//  double y0 = bounds.getMin().getY();
//  double y1 = bounds.getMax().getY();
//  double z0 = bounds.getMin().getZ();
//  double z1 = bounds.getMax().getZ();
//  double xMid = (x0 + x1) / 2;
//  double yMid = (y0 + y1) / 2;
//  double zMid = (z0 + z1) / 2;
//
//  children[0] = new OctreeNode<>(new OctreeBounds(x0, y0, z0, xMid, yMid, zMid));
//  children[1] = new OctreeNode<>(new OctreeBounds(xMid, y0, z0, x1, yMid, zMid));
//  children[2] = new OctreeNode<>(new OctreeBounds(x0, yMid, z0, xMid, y1, zMid));
//  children[3] = new OctreeNode<>(new OctreeBounds(xMid, yMid, z0, x1, y1, zMid));
//  children[4] = new OctreeNode<>(new OctreeBounds(x0, y0, zMid, xMid, yMid, z1));
//  children[5] = new OctreeNode<>(new OctreeBounds(xMid, y0, zMid, x1, yMid, z1));
//  children[6] = new OctreeNode<>(new OctreeBounds(x0, yMid, zMid, xMid, y1, z1));
//  children[7] = new OctreeNode<>(new OctreeBounds(xMid, yMid, zMid, x1, y1, z1));
	

	private void split() {
		for (T item : items) {
			OctreeBounds itemBounds = getBounds(item);
			for (int i = 0; i < 8; i++) {
				children[i].add(item, itemBounds);
			}
		}
		items.clear();
	}

	private OctreeBounds getBounds(T item) {
		// Implement this method to get the bounds of the item
		// Example: For a GameObject, return the bounds of its mesh
		return null;
	}
}
