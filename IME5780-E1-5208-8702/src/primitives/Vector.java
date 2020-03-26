package primitives;

import java.security.InvalidParameterException;
import java.util.Objects;

public class Vector {
    Point3D _head;

    public final static Vector ZERO = new Vector(new Point3D(0.0, 0.0, 0.0));

    /****************************** Constructors *****************************/

    /**
     * Vector constructor receiving 3 coordinate
     *
     * @param _x coordinate on x scale
     * @param _y coordinate on y scale
     * @param _z coordinate on z scale
     */
    public Vector(Coordinate _x, Coordinate _y, Coordinate _z) {
        if (new Point3D(_x, _y, _z).equals(Point3D.ZERO))
            throw new IllegalArgumentException("vector can not be 0");
        _head._x = _x;
        _head._y = _y;
        _head._z = _z;
    }

    /**
     * Vector constructor receiving 3 doubles value x,y,z
     * @param _x point on x scale
     * @param _y point on y scale
     * @param _z point on z scale
     */
    public Vector(double _x, double _y, double _z) {
        if (new Point3D(_x, _y, _z).equals(Point3D.ZERO))
            throw new IllegalArgumentException("vector can not be 0");
        this._head = new Point3D(_x, _y, _z);
    }

    /**
     * vector constructor get a Point3D
     * @param point3D as Point3D
     */
    public Vector(Point3D point3D) {
        if (point3D.equals(Point3D.ZERO))
            throw new IllegalArgumentException("vector can not be 0");
        this._head = point3D;
    }

    /**
     * vector copy constructor
     *
     * @param other as Vector type
     */
    public Vector(Vector other) {
        this._head = other._head;
    }

    /****************************** Functions *****************************/

    /**
     * add 2 vectors operation
     * @param vector to adding
     * @return the new vector
     */
    public Vector add(Vector vector) {
        return new Vector(
                this._head.get_x()._coord + vector._head.get_x()._coord,
                this._head.get_y()._coord + vector._head.get_y()._coord,
                this._head.get_z()._coord + vector._head.get_z()._coord);
    }

    /**
     * sub 2 vectors operation
     * @param vector to subtracting
     * @return the new vector
     */
    public Vector subtract(Vector vector) {
        return new Vector(
                this._head.get_x()._coord - vector._head.get_x()._coord,
                this._head.get_y()._coord - vector._head.get_y()._coord,
                this._head.get_z()._coord - vector._head.get_z()._coord);
    }

    /**
     * scalar multiplication
     * @param scalar
     * @return the new vector
     */
    public Vector scale(double scalar){
        return new Vector(
                this._head.get_x()._coord * scalar,
                this._head.get_y()._coord * scalar,
                this._head.get_z()._coord * scalar);
    }

    /**
     * dot product func
     * @param vector to mul
     * @return the result as double
     */
    public double dotProduct(Vector vector) {
        return vector._head.get_x()._coord * this._head.get_x()._coord +
                vector._head.get_x()._coord * this._head.get_x()._coord +
                vector._head.get_x()._coord* this._head.get_x()._coord;
    }

    /**
     * cross product func
     * @param vector to mul
     * @return the result as vector
     */
    public Vector crossProduct(Vector vector) {
        double u1 = this._head._x._coord;
        double u2 = this._head._y._coord;
        double u3 = this._head._z._coord;
        double v1 = vector._head._x._coord;
        double v2 = vector._head._y._coord;
        double v3 = vector._head._z._coord;
        return (new Vector(
                u2 * v3 - u3 * v2,
                u3 * v1 - u1 * v3,
                u1 * v2 - u2 * v1)
        );
    }

    /**
     * this func calculate the pow of vector length
     * @return the pow vector length
     */
    public Double lengthSquared(){
        return (this._head.get_x()._coord * this._head.get_x()._coord +
                this._head.get_y()._coord * this._head.get_y()._coord +
                this._head.get_z()._coord * this._head.get_z()._coord);
    }

    /**
     * this func calculate the vector length
     * @return length of vector
     */
    public Double length(){
        return Math.sqrt(this.lengthSquared());
    }

    /**
     * this func change the operation vector to be the normal
     * @return the normal vector
     */
    public Vector normalize(){
        this._head = new Point3D(this.scale(this.length())._head);
        return this;
    }

    /**
     * this func create vector normal
     * @return the normal vector
     */
    public Vector normalized(){
        return new Vector(this.scale(this.length())._head);
    }


    /**
     * vector get value
     *
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
