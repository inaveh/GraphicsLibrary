package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Cylinder extends RadialGeometry {
    Double _height;

    public Cylinder(Double _radius, Double _height) {
        super(_radius);
        this._height = _height;
    }

    public Double get_height() {
        return _height;
    }

    @Override
    public Vector getNormal(Point3D point3D) {
        return null;
    }

    @Override
    public String toString() {
        return super.toString() +
                "_height=" + _height +
                '}';
    }
}
