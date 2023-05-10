package storage.index;

class OctreeBounds {
	private final Vector3 min;
	private final Vector3 max;

	public OctreeBounds(Object x0, Object y0, Object z0, Object x1, Object y1, Object z1) {
		min = new Vector3(null, null, null);
		max = new Vector3(null, null, null);
	}

//    public boolean contains(OctreeBounds other) {
//        return min.getX() <= other.getMin().getX() && max.getX() >= other.getMax().getX() &&
//                min.getY() <= other.getMin().getY() && max.getY() >= other.getMax().getY() &&
//                min.getZ() <= other.getMin().getZ() && max.getZ() >= other.getMax().getZ();
//    }
//
//    public boolean intersects(OctreeBounds other) {
//        return min.getX() <= other.getMax().getX() && max.getX() >= other.getMin().getX() &&
//                min.getY() <= other.getMax().getY() && max.getY() >= other.getMin().getY() &&
//                min.getZ() <= other.getMax().getZ() && max.getZ() >= other.getMin().getZ();
//    }

	public Vector3 getMin() {
		return min;
	}

	public Vector3 getMax() {
		return max;
	}
}
