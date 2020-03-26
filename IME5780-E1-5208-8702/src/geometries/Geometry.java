package geometries;

import primitives.Point3D;
import primitives.Vector;

public interface Geometry {

    /**
     * this func receiving a point and providing a normal
     * @param point3D the point
     * @return the normal
     */
    public Vector getNormal(Point3D point3D);

}
