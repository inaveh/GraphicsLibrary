package geometries;

import primitives.Point3D;
import primitives.Vector;
/**
 *
 */
public class Plane implements Geometry {
    Point3D _p;
    Vector _normal;

    // ****************************** Constructors *****************************/

    /**
     * Plane constructor by 3 Points
     * @param point3D point
     * @param vec1 vector
     * @param vec2 vector
     */
    public Plane(Point3D point3D, Point3D vec1, Point3D vec2) {
        this._normal = null;
        this._p = point3D;
    }

    /**
     * Plane constructor by normal and point
     *
     * @param point3D point
     * @param _normal normal
     */
    public Plane(Point3D point3D, Vector _normal) {
        this._p = point3D;
        this._normal = _normal;
    }

    // ****************************** Getters *****************************/

    /**
     * Plane getter
     * @return point
     */
    public Point3D get_p() {
        return _p;
    }

    /**
     * Plane getter
     *
     * @return plane normal
     */
    public Vector get_normal() {
        return _normal;
    }

    /****************************** Overrides *****************************/

    @Override
    public Vector getNormal(Point3D other) {
        Vector p2p = new Vector(this._p.subtract(other));
        if ((p2p.dotProduct(this._normal)) != 0)
            throw new IllegalArgumentException("your point not exist on the plane");
        return _normal;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "_p=" + _p +
                ", _normal=" + _normal +
                '}';
    }

    public Vector getNormal() {
        return this.getNormal(this._p);
    }
}