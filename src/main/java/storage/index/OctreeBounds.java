package storage.index;

import java.util.Date;

import constants.Constants;
import exceptions.DBAppException;

class OctreeBounds {
	private final Vector3 min;
	private final Vector3 max;

	public OctreeBounds(Object x0, Object y0, Object z0, Object x1, Object y1, Object z1) {
		min = new Vector3(x0, y0, z0);
		max = new Vector3(x1, y1, z1);
	}

	private Object max(Object x, Object y) throws DBAppException {
		if (x instanceof Integer && y instanceof Integer) {
			return Math.max((Integer) x, (Integer) y);
		}
		if (x instanceof Double && y instanceof Double) {
			return Math.max((Double) x, (Double) y);
		}
		if (x instanceof String && y instanceof String) {
			return ((String) x).compareTo((String) y) <= 0 ? y : x;
		}
		if (x instanceof Date && y instanceof Date) {
			return ((Date) x).compareTo((Date) y) <= 0 ? y : x;
		}
		throw new DBAppException(Constants.ERROR_MESSAGE_DATATYPE);
	}

	private Object min(Object x, Object y) throws DBAppException {
		if (x instanceof Integer && y instanceof Integer) {
			return Math.min((Integer) x, (Integer) y);
		}
		if (x instanceof Double && y instanceof Double) {
			return Math.min((Double) x, (Double) y);
		}
		if (x instanceof String && y instanceof String) {
			return ((String) x).compareTo((String) y) <= 0 ? x : y;
		}
		if (x instanceof Date && y instanceof Date) {
			return ((Date) x).compareTo((Date) y) <= 0 ? x : y;
		}
		throw new DBAppException(Constants.ERROR_MESSAGE_DATATYPE);
	}

	private Object get(Object obj, int dimension) {
		if (obj instanceof DBAppNull) {
			switch (dimension) {
			case 0:
				return getMin().getX();
			case 1:
				return getMin().getY();
			case 2:
				return getMin().getZ();
			}
		}
		return obj;
	}

	private boolean contains(Object leftBound, Object rightBound, Object target) throws DBAppException {
		return min(leftBound, target).equals(leftBound) && max(target, rightBound).equals(rightBound);
	}

	private boolean containsX(Object target) throws DBAppException {
		return contains(getMin().getX(), getMax().getX(), get(target, 0));
	}

	private boolean containsY(Object target) throws DBAppException {
		return contains(getMin().getY(), getMax().getY(), get(target, 1));
	}

	private boolean containsZ(Object target) throws DBAppException {
		return contains(getMin().getZ(), getMax().getZ(), get(target, 2));
	}

	public boolean contains(OctreeBounds other) throws DBAppException {
		return containsX(other.getMin().getX()) && containsX(other.getMax().getX()) && containsY(other.getMin().getY())
				&& containsY(other.getMax().getY()) && containsZ(other.getMin().getZ())
				&& containsZ(other.getMax().getZ());
	}

	public boolean intersects(OctreeBounds other) throws DBAppException {
		Object minX = max(getMin().getX(), other.getMin().getX());
		Object maxX = min(getMax().getX(), other.getMax().getX());
		Object minY = max(getMin().getY(), other.getMin().getY());
		Object maxY = min(getMax().getY(), other.getMax().getY());
		Object minZ = max(getMin().getZ(), other.getMin().getZ());
		Object maxZ = min(getMax().getZ(), other.getMax().getZ());

		return min(minX, maxX).equals(minX) && min(minY, maxY).equals(minY) && min(minZ, maxZ).equals(minZ);
	}

	public Vector3 getMin() {
		return min;
	}

	public Vector3 getMax() {
		return max;
	}

	@Override
	public String toString() {
		return "minBound : " + getMin() + ", maxBound : " + getMax();
	}
}
