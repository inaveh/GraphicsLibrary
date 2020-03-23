package primitives;

import java.security.InvalidParameterException;
import java.util.Objects;

public class Vector {
    Point3D _head;

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
}
