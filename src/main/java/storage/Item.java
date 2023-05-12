package storage;

import java.util.ArrayList;
import java.util.List;

public class Item<T> {

	private Object x, y, z, data;
	private List<Object> Duplicates;

	public Item(Object x, Object y, Object z, Object data) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.data = data;
		this.Duplicates = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "( " + x + ", " + y + ", " + z + " ), " + data + ", " + Duplicates;
	}

	@Override
	public boolean equals(Object obj) {
		Item<T> item = (Item) obj;
		return x.equals(item.getX()) && y.equals(item.getY()) && z.equals(item.getZ());
	}

	public Object getData() {
		return data;
	}

	public void add(Object data) {
		this.Duplicates.add(data);
	}

	public Object getX() {
		return x;
	}

	public Object getY() {
		return y;
	}

	public Object getZ() {
		return z;
	}

	public List<Object> getDuplicates() {
		return Duplicates;
	}
}
