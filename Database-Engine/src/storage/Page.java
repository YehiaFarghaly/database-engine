package storage;

import java.io.Serializable;
import java.util.Vector;

public class Page implements Serializable {

	private Vector<Tuple> tuples;
	private Object minPK, maxPK;
	private int size;

	public Page() {
		this.tuples = new Vector<>();
	}

	public Object getMinPK() {
		return minPK;
	}

	public void setMinPK(Object minPK) {
		this.minPK = minPK;
	}

	public Object getMaxPK() {
		return maxPK;
	}

	public void setMaxPK(Object maxPK) {
		this.maxPK = maxPK;
	}

	public int getSize() {
		return size;
	}
}
