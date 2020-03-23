package primitives;

import java.security.InvalidParameterException;
import java.util.Objects;

public class Vector {
    Point3D _head;


    public final static Vector ZERO = new Vector(new Point3D(0.0, 0.0, 0.0));
    /**
     * vector constructor
     * @param _head Point3D
     */
    public Vector(Point3D _head) {
        if (_head._x._coord==0&&_head._y._coord==0&&_head._z._coord==0)
            throw new InvalidParameterException("vector not can not be 0");
        this._head = _head;
    }

    /**
     * vector copy constructor
     * @param other as Vector type
     */
    public Vector(Vector other) {
        this._head=other._head;
    }

    public Vector(double x, double y, double z) {
        Point3D p=new Point3D(x,y,z);
        _head=p;
    }

    /**
     * vector get value
     * @return head point
     */
    public Point3D get_head() {
        return _head;
    }

    /****************************** Override ****************/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Vector)) return false;
        Vector vector = (Vector) o;
        return _head.equals(vector._head);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "_head=" + _head +
                '}';
    }

    public double dotProduct(Vector vector) {
        return vector._head._x.get() * this._head._x.get() +
                vector._head._y.get() * this._head._y.get() +
                vector._head._z.get() * this._head._z.get();
    }

    public Vector crossProduct(Vector vector) {
        if (this._head._x == vector._head._x &&
                this._head._y == vector._head._y &&
                this._head._z == vector._head._z)
            return ZERO;
        double u1 = this._head._x._coord;
        double u2 = this._head._y._coord;
        double u3 = this._head._z._coord;
        double v1 = vector._head._x._coord;
        double v2 = vector._head._y._coord;
        double v3 = vector._head._z._coord;

        Point3D tmp = new Point3D(
                u2 * v3 - u3 * v2,
                u3 * v1 - u1 * v3,
                u1 * v2 - u2 * v1
        );
        return new Vector(tmp);
    }
}
