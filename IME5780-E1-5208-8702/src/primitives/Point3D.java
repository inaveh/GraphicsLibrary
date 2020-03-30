package primitives;

/**
 * class Point3D for describe coordinates
 *  @author AhronS, IsraelN
 */

public class Point3D {
    private Coordinate coordinate;
    private Coordinate _y;
    private Coordinate _z;

    /**
     * const Zero point
     */
    public final static Point3D ZERO = new Point3D(0, 0, 0);

    // ****************************** Constructors *****************************/
    /**
     * Point3D constructor receiving a 3 coordinate
     * @param _x point on x scale
     * @param _y point on y scale
     * @param _z point on z scale
     */
    public Point3D(Coordinate _x, Coordinate _y, Coordinate _z) {
        this.coordinate = _x;
        this._y = _y;
        this._z = _z;
    }

    /**
     * Point3D constructor receiving a 3 doubles value x,y,z
     *
     * @param _x point on x scale
     * @param _y point on y scale
     * @param _z point on z scale
     */
    public Point3D(double _x, double _y, double _z) {
        this(new Coordinate(_x), new Coordinate(_y), new Coordinate(_z));
    }

    /**
     * copy constructor
     * @param other is full Point
     */
    public Point3D(Point3D other) {
        this.coordinate = other.coordinate;
        this._y = other._y;
        this._z = other._z;
    }

    /**
     * Point3D value getter
     * @return x value
     */
    public Coordinate getX() {
        return coordinate;
    }

    /**
     * Point3D value getter
     * @return y value
     */
    public Coordinate getY() {
        return _y;
    }

    /**
     * Point3D value getter
     * @return z value
     */
    public Coordinate getZ() {
        return _z;
    }

    // ****************************** Functions *****************************/
    /**
     * this func subtracting a point from another point
     * @param vertex one point
     * @return the result as vector
     */
    public Vector subtract(Point3D vertex) {
        return new Vector(
                this.coordinate._coord - vertex.coordinate._coord,
                this._y._coord - vertex._y._coord,
                this._z._coord - vertex._z._coord
        );
    }

    /**
     * this func adding vector to point
     * @param vector one vector
     * @return the result as point
     */
    public Point3D add(Vector vector) {
        return new Point3D(
                this.coordinate._coord + vector.getHead().coordinate._coord,
                this._y._coord + vector.getHead()._y._coord,
                this._z._coord + vector.getHead()._z._coord);
    }

    /**
     * this func calculate the pow of distance from p2p
     * @param point3D point
     * @return  the pow of distance from p2p
     */
    public double distanceSquared(Point3D point3D) {
        Vector vector = new Vector(this.subtract(point3D));
        double x2 = vector.getHead().coordinate._coord * vector.getHead().coordinate._coord;
        double y2 = vector.getHead()._y._coord * vector.getHead()._y._coord;
        double z2 = vector.getHead()._z._coord * vector.getHead()._z._coord;
        return x2 + y2 + z2;
    }

    /**
     * this func calculate the distance from p2p
     * @param point3D point
     * @return the distance from p2p
     */
    public double distance(Point3D point3D) {
        return Math.sqrt(this.distanceSquared(point3D));
    }

    /****************************** Override *****************************/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Point3D)) return false;
        Point3D point3D = (Point3D) o;
        return coordinate.equals(point3D.coordinate)
                && _y.equals(point3D._y)
                && _z.equals(point3D._z);
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "_x=" + coordinate +
                ", _y=" + _y +
                ", _z=" + _z +
                '}';
    }


}
