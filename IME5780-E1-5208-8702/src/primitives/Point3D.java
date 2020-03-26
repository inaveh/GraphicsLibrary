package primitives;

import java.util.Objects;

/**
 * class Point3D for describe coordinates
 */

public class Point3D {
    Coordinate _x;
    Coordinate _y;
    Coordinate _z;

    /**
     * const Zero point
     */
    public final static Point3D ZERO = new Point3D(0, 0, 0);


    /****************************** Constructors *****************************/

    /**
     * Point3D constructor receiving a 3 coordinate
     * @param _x point on x scale
     * @param _y point on y scale
     * @param _z point on z scale
     */
    public Point3D(Coordinate _x, Coordinate _y, Coordinate _z) {
        this._x = _x;
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
     *
     * @param other is full Point
     */
    public Point3D(Point3D other) {
        this._x = other._x;
        this._y = other._y;
        this._z = other._z;
    }

    /**
     * Point3D value getter
     *
     * @return x value
     */
    public Coordinate get_x() {
        return new Coordinate(_x);
    }

    /**
     * Point3D value getter
     *
     * @return y value
     */
    public Coordinate get_y() {
        return new Coordinate(_y);
    }

    /**
     * Point3D value getter
     *
     * @return z value
     */
    public Coordinate get_z() {
        return new Coordinate(_z);
    }

    /****************************** Functions *****************************/

    /**
     * this func subtracting a point from another point
     *
     * @param vertex one point
     * @return the result as vector
     */
    public Vector subtract(Point3D vertex) {
        return new Vector(vertex._x._coord - this._x._coord,
                vertex._y._coord - this._y._coord,
                vertex._z._coord - this._z._coord);
    }

    /**
     * this func adding vector to point
     *
     * @param vector one vector
     * @return the result as point
     */
    public Point3D add(Vector vector) {
        return new Point3D(this._x._coord + vector._head._x._coord,
                this._y._coord + vector._head._y._coord,
                this._z._coord + vector._head._z._coord);
    }

    /**
     * this func calculate the pow of distance from p2p
     * @param point3D
     * @return the pow of distance from p2p
     */
    public double distanceSquared(Point3D point3D) {
        Vector vector = new Vector(this.subtract(point3D));
        double x2 = vector._head._x._coord * vector._head._x._coord;
        double y2 = vector._head._y._coord * vector._head._y._coord;
        double z2 = vector._head._z._coord * vector._head._z._coord;
        double result = x2 + y2 + z2;
        return result;
    }

    /**
     * this func calculate the distance from p2p
     * @param point3D
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
        if (!(o instanceof Ray)) return false;
        Point3D point3D = (Point3D) o;
        return _x.equals(point3D._x) && _y.equals(point3D._y) && _z.equals(point3D._z);
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "_x=" + _x +
                ", _y=" + _y +
                ", _z=" + _z +
                '}';
    }


}
