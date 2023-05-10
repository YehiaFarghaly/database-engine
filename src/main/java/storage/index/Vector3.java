package storage.index;

class Vector3 {
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
}
