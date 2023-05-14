package storage.index;

import java.io.Serializable;

public class Vector3 implements Serializable {
	private static final long serialVersionUID = 586536815635767374L;
	private final Object x;
	private final Object y;
	private final Object z;

	public Vector3(Object x, Object y, Object z) {
		this.x = x;
		this.y = y;
		this.z = z;
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

	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}
}
