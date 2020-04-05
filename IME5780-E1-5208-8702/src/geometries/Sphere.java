package geometries;

import primitives.Point3D;
import primitives.Vector;

/**
 * class Sphere for describe sphere object
 * this class extends from RadialGeometry
 *
 * @author AhronS, IsraelN
 */
public class Sphere extends RadialGeometry {

    private Point3D _center;

    // ****************************** Constructors *****************************/

    /**
     * Sphere constructor
     *
     * @param _radius radius value
     * @param _center point
     */
    public Sphere(Double _radius, Point3D _center) {
        super(_radius);
        this._center = _center;
    }

    // ****************************** Getters *****************************/

    /**
     * Sphere getter
     *
     * @return center point
     */
    public Point3D getCenter() {
        return _center;
    }

    // ****************************** Overrides *****************************/
    @Override
    public Vector getNormal(Point3D point3D) {
        Vector vector = new Vector(point3D.subtract(_center));
        return vector.normalize().scale(-1);
    }

    @Override
    public String toString() {
        return super.toString() + "Sphere{" +
                "_center=" + _center +
                '}';
    }
}
