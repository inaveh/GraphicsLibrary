package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Tube extends RadialGeometry {
    Ray _axisRay;

    public Tube(Double _radius, Ray _axisRay) {
        super(_radius);
        this._axisRay = _axisRay;
    }

    public Ray get_axisRay() {
        return _axisRay;
    }

    @Override
    public Vector getNormal(Point3D point3D) {
        return null;
    }

    @Override
    public String toString() {
        return super.toString() +
                "_axisRay=" + _axisRay +
                '}';
    }
}
