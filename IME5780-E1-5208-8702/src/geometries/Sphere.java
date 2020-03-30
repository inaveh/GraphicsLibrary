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

    /**
     * Sphere getter
     *
     * @return center point
     */
    public Point3D getCenter() {
        return _center;
    }

    /****************************** Overrides *****************************/
    @Override
    public Vector getNormal(Point3D point3D) {
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + "Sphere{" +
                "_center=" + _center +
                '}';
    }
}
