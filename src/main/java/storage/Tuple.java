package storage;

import java.io.Serializable;
import java.util.Vector;

import storage.index.DBAppNull;

public class Tuple implements Cloneable, ITuple, Serializable {

	private static final long serialVersionUID = 7675064852791384832L;
	private Vector<Cell> cells;
	private Object primaryKey; 

	public Tuple() {
		cells = new Vector<>();
	}

	@Override
	public void addCell(Cell c) {
		this.cells.add(c);
	}

	public Vector<Cell> getCells() {
		return cells;
	}

	public Object getPrimaryKey() {
		return primaryKey;
	}

	public Object get(String key) {
		Object ret = null;
		for (Cell cell : cells) {
			if (cell.getKey().equals(key))
				ret = cell.getValue();
		}
		return ret;
	}

	public boolean contains(String key) {
		if (!(get(key) instanceof DBAppNull))
			return true;
		return false;
	}

	@Override
	public void setPrimaryKey(Object pk) {
		this.primaryKey = pk;
	}

	protected Tuple getCopy() {
		Tuple copy = null;
		try {
			copy = (Tuple) this.clone();
			return copy;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return copy;
	}

	@Override
	public String toString() {
		return "Tuple [cells=" + cells + ", primaryKey=" + primaryKey + "]";
	}
}
