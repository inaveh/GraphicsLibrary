package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Sphere extends RadialGeometry {

    Point3D _center;

    public Sphere(Double _radius, Point3D _center) {
        super(_radius);
        this._center = _center;
    }

    public Point3D get_center() {
        return _center;
    }

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
