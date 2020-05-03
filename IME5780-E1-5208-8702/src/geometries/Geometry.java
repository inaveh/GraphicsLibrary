package geometries;

import primitives.Point3D;
import primitives.Vector;
/**
 * interface for geometric objects
 */
public interface Geometry extends Intersectable {
    /**
     * this func receiving a point and providing a normal
     * @param point3D the point
     */
    Vector getNormal(Point3D point3D);
}
