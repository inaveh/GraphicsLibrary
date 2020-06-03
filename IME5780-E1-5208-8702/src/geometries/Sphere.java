package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.alignZero;

/**
 * class Sphere for describe sphere object
 * this class extends from RadialGeometry
 *
 * @author AhronS, IsraelN
 */
public class Sphere extends RadialGeometry {

    private Point3D _center;

    //****************************** Constructors *****************************/

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
     * Sphere constructor with color
     *
     * @param _emission emission color
     * @param _radius   radius
     * @param _center   center
     */
    public Sphere(Color _emission, double _radius, Point3D _center) {
        this(_radius, _center);
        this._emission = _emission;
    }

    /**
     * Sphere constructor with color and material
     *
     * @param _material      material
     * @param _emissionLight emission color
     * @param _radius        radius
     * @param _center        center
     */
    public Sphere(Color _emissionLight, Material _material, double _radius, Point3D _center) {
        this(_emissionLight, _radius, _center);
        this._material = _material;
    }

//****************************** Getters *****************************/

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
        return point3D.subtract(_center).normalize();
    }

    @Override
    public String toString() {
        return super.toString() + "Sphere{" +
                "_center=" + _center +
                '}';
    }

    @Override
    public List<GeoPoint> findIntersections(Ray ray) {
        Point3D p0 = ray.getP0();
        Vector v = ray.getDir();
        Vector u;
        //check if p0 same as _center
        try {
            u = _center.subtract(p0);
        } catch (IllegalArgumentException e) {
            return List.of(new GeoPoint(this, ray.getPoint(getRadius())));
        }
        double tm = alignZero(v.dotProduct(u));
        double dSquared = u.lengthSquared() - tm * tm;
        double thSquared = alignZero(getRadius() * getRadius() - dSquared);

        if (thSquared <= 0)
            return null;
        double th = alignZero(Math.sqrt(thSquared));
        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm + th);
        if (t1 <= 0 && t2 <= 0)
            return null;
        if (t1 > 0 && t2 > 0)
            return List.of(new GeoPoint(this, ray.getPoint(t1)), new GeoPoint(this, ray.getPoint(t2)));
        if (t1 > 0)
            return List.of(new GeoPoint(this, ray.getPoint(t1)));
        return List.of(new GeoPoint(this, ray.getPoint(t2)));
    }
}