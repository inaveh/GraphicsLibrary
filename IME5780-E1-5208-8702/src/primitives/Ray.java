package primitives;

import java.util.Objects;

public class Ray {
    Point3D _p0;
    Vector _dir;

    /**
     * Ray constructor receiving a 2 value
     * @param _p0 as Point3D
     * @param _dir as Vector
     */
    public Ray(Point3D _p0, Vector _dir) {
        this._p0 = _p0;
        this._dir = _dir;
    }

    /**
     * Ray copy constructor
     * @param other
     */
    public Ray(Ray other) {
        this._p0 = other._p0;
        this._dir = other._dir;
    }

    /**
     * Ray getter value
     * @return Point3D
     */
    public Point3D get_p0() {
        return _p0;
    }

    /**
     * Ray getter value
     * @return Vector
     */
    public Vector get_dir() {
        return _dir;
    }

    /****************************** Override ****************/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Ray)) return false;
        Ray ray = (Ray) o;
        return _dir.equals(ray._dir)&&_p0.equals(ray._p0);
    }

    @Override
    public String toString() {
        return "Ray{" +
                "_p0=" + _p0 +
                ", _dir=" + _dir +
                '}';
    }
}
