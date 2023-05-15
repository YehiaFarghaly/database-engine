package storage.index;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public class Item<T> implements Serializable {

	private static final long serialVersionUID = 5164015443193314963L;
	private Object x, y, z, data;
	private Vector<Object> duplicates;

	public Item(Object x, Object y, Object z, Object data) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.data = data;
		this.duplicates = new Vector<>();
	}

	@Override
	public String toString() {
		return "( " + x + ", " + y + ", " + z + " ), " + data + ", " + duplicates;
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
		this.duplicates.add(data);
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
		return duplicates;
	}
}
