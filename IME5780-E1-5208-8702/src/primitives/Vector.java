package primitives;

import java.security.InvalidParameterException;

/**
 * class Vector for describe a vector when the begin point is 0,0,0
 *
 * @author AhronS, IsraelN
 */
public class Vector {
    private Point3D _head;

    // ****************************** Constructors *****************************/

    /**
     * Vector constructor receiving 3 coordinate
     *
     * @param _x coordinate on x scale
     * @param _y coordinate on y scale
     * @param _z coordinate on z scale
     */
    public Vector(Coordinate _x, Coordinate _y, Coordinate _z) {
        if (new Point3D(_x, _y, _z).equals(Point3D.ZERO))
            throw new NullPointerException("vector can not be 0");
        this._head = new Point3D(_x, _y, _z);
    }

    /**
     * Vector constructor receiving 3 doubles value x,y,z
     *
     * @param _x point on x scale
     * @param _y point on y scale
     * @param _z point on z scale
     */
    public Vector(double _x, double _y, double _z) {
        Point3D point3D = new Point3D(_x, _y, _z);
        if (point3D.equals(Point3D.ZERO))
            throw new IllegalArgumentException("vector can not be 0");
        this._head = point3D;
    }

    /**
     * vector constructor get a Point3D
     *
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

    // ****************************** Functions *****************************/

    /**
     * add 2 vectors operation
     *
     * @param vector to adding
     * @return the new vector
     */
    public Vector add(Vector vector) {
        return new Vector(
                this._head.getX()._coord + vector._head.getX()._coord,
                this._head.getY()._coord + vector._head.getY()._coord,
                this._head.getZ()._coord + vector._head.getZ()._coord);
    }

    /**
     * sub 2 vectors operation
     *
     * @param vector to subtracting
     * @return the new vector
     */
    public Vector subtract(Vector vector) {
        return new Vector(
                this._head.getX()._coord - vector._head.getX()._coord,
                this._head.getY()._coord - vector._head.getY()._coord,
                this._head.getZ()._coord - vector._head.getZ()._coord);
    }

    /**
     * scalar multiplication
     *
     * @param scalar scalar
     * @return the new vector
     */
    public Vector scale(double scalar) {
        return new Vector(
                this._head.getX()._coord * scalar,
                this._head.getY()._coord * scalar,
                this._head.getZ()._coord * scalar);
    }

    /**
     * dot product func
     *
     * @param vector to mul
     * @return the result as double
     */
    public double dotProduct(Vector vector) {
        return vector._head.getX()._coord * this._head.getX()._coord +
                vector._head.getY()._coord * this._head.getY()._coord +
                vector._head.getZ()._coord * this._head.getZ()._coord;
    }

    /**
     * cross product func
     *
     * @param vector to mul
     * @return the result as vector
     */
    public Vector crossProduct(Vector vector) {
        double u1 = this._head.getX()._coord;
        double u2 = this._head.getY()._coord;
        double u3 = this._head.getZ()._coord;
        double v1 = vector._head.getX()._coord;
        double v2 = vector._head.getY()._coord;
        double v3 = vector._head.getZ()._coord;
        if(u2 * v3 - u3 * v2 == 0 && u3 * v1 - u1 * v3 == 0  && u1 * v2 - u2 * v1 == 0)
            throw new IllegalArgumentException("the operation crossProduct() for parallel vectors impossible");
        return (new Vector(
                u2 * v3 - u3 * v2,
                u3 * v1 - u1 * v3,
                u1 * v2 - u2 * v1)
        );
    }

    /**
     * this func calculate the pow of vector length
     *
     * @return the pow vector length
     */
    public Double lengthSquared() {
        return (this._head.getX()._coord * this._head.getX()._coord +
                this._head.getY()._coord * this._head.getY()._coord +
                this._head.getZ()._coord * this._head.getZ()._coord);
    }

    /**
     * this func calculate the vector length
     *
     * @return length of vector
     */
    public Double length() {
        return Math.sqrt(this.lengthSquared());
    }

    /**
     * this func change the operation vector to be the normal
     *
     * @return the normal vector
     */
    public Vector normalize() {
        Point3D point3D = new Point3D( this._head.getX()._coord / this.length(),
                this._head.getY()._coord / this.length(),
                this._head.getZ()._coord / this.length());
        this._head = point3D;
        return this;
    }

    /**
     * this func create vector normal
     *
     * @return the normal vector
     */
    public Vector normalized() {
        Vector vector = new Vector(this);
        return vector.normalize();
    }

    /**
     * vector get value
     *
     * @return head point
     */
    public Point3D getHead() {
        return _head;
    }

    /****************************** Override ****************/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null)
            return false;
        if (!(o instanceof Vector))
            return false;
        Vector vector = (Vector) o;
        return this._head.getX().equals(vector._head.getX())
                && this._head.getY().equals(vector._head.getY())
                && this._head.getZ().equals(vector._head.getZ());
    }

    @Override
    public String toString() {
        return "Vector{" +
                "_head=" + _head +
                '}';
    }
}
