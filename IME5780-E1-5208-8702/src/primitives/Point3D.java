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
     * Point3D constructor receiving a 3 value
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
     * copy constructor
     * @param other is full Point
     */
    public Point3D(Point3D other) {
        this._x = other._x;
        this._y = other._y;
        this._z = other._z;
    }

    /**
     * Point3D value getter
     * @return x value
     */
    public Coordinate get_x() {
        return new Coordinate(_x);
    }

    /**
     * Point3D value getter
     * @return y value
     */
    public Coordinate get_y() {
        return new Coordinate(_y);
    }

    /**
     * Point3D value getter
     * @return z value
     */
    public Coordinate get_z() {
        return new Coordinate(_z);
    }

    /****************************** Override ****************/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Ray)) return false;
        Point3D point3D= (Point3D) o;
        return _x.equals(point3D._x)&&_y.equals(point3D._y)&&_z.equals(point3D._z);
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
