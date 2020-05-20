package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.isZero;

/**
 * class Cylinder for describe Cylinder object
 * this class extends from RadialGeometry
 *
 * @author AhronS, IsraelN
 */
public class Cylinder extends Tube {
    private Double _height;

    // ****************************** Constructors *****************************/

    /**
     * Cylinder constructor
     *
     * @param _radius radius
     * @param _height the height
     */
    public Cylinder(Double _radius, Ray _ray, Double _height) {
        super(_radius, _ray);
        this._height = _height;
    }

    // ****************************** Getters *****************************/

    /**
     * Cylinder getter
     *
     * @return height
     */
    public Double getHeight() {
        return _height;
    }

    // ****************************** Overrides *****************************/
    @Override
    public Vector getNormal(Point3D point3D) {
        // check if its same points p0==p
        Vector n;
        Double t;
        try {
            n = new Vector(point3D.subtract(this.getAxisRay().getP0())); //red vec
            t = n.dotProduct(this.getAxisRay().getDir());
        } catch (IllegalArgumentException e) {
            return this.getAxisRay().getDir();
        }
        // check if p at the base, orthogonal, so the normal is the vec of the ray
        if (isZero(t) || isZero(this._height - t))
            return this.getAxisRay().getDir();
        // else, it's like Tube
        Vector shadow = this.getAxisRay().getDir().scale(t);
        return n.subtract(shadow).normalize();
    }

    @Override
    public String toString() {
        return super.toString() +
                "_height=" + _height +
                '}';
    }

    @Override
    public List<GeoPoint> findIntersections(Ray ray) {
        return super.findIntersections(ray);
    }
}