package geometries;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;
/**
 * interface for geometric objects
 */
public abstract class Geometry implements Intersectable {
    protected Color _emission;

    /**
     * constructor for Geometry
     * @param _emission emission
     */
    public Geometry(Color _emission) {
        this._emission = _emission;
    }

    /**
     * default constructor for Geometry
     */
    public Geometry() {
        this._emission = Color.BLACK;
    }

    /**
     * _emission getter
     * @return emission
     */
    public Color getEmission() {
        return _emission;
    }

    /**
     * this func receiving a point and providing a normal
     * @param point3D the point
     */
    public abstract getNormal(Point3D point3D);
}
