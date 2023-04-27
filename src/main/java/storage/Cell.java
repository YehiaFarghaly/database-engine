package storage;

import java.io.Serializable;

public class Cell implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6329920811762568469L;
	private Object key, value;

	public Cell(Object key, Object value) {
		this.key = key;
		this.value = value;
	}

	public Object getKey() {
		return key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "[key: " + key + ", value: " + value + "]";
	}

}
