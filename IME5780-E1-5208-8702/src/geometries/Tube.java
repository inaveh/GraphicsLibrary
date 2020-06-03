package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.isZero;

/**
 * class Tube for describe tube object
 * this class extends from RadialGeometry
 *
 * @author AhronS, IsraelN
 */
public class Tube extends RadialGeometry {
    private Ray _axisRay;

    //****************************** Constructors *****************************/

    /**
     * Tube constructor
     *
     * @param _radius  radius
     * @param _axisRay Ray
     */
    public Tube(Double _radius, Ray _axisRay) {
        super(_radius);
        this._axisRay = _axisRay;
    }

    /**
     * tube constructor with color
     *
     * @param _emission emission
     * @param _radius   radius
     * @param _axisRay  axis ray
     */
    public Tube(Color _emission, double _radius, Ray _axisRay) {
        super(_emission, _radius);
        this._axisRay = _axisRay;
    }

    /**
     * tube constructor with color and material
     *
     * @param _material material
     * @param _emission emission
     * @param _radius   radius
     * @param _axisRay  axis ray
     */
    public Tube(Material _material, Color _emission, double _radius, Ray _axisRay) {
        this(_emission, _radius, _axisRay);
        this._material = _material;
    }

    // ****************************** Getters *****************************/

    /**
     * Tube getter
     *
     * @return Ray
     */
    public Ray getAxisRay() {
        return _axisRay;
    }

    // ****************************** Overrides *****************************/
    @Override
    public Vector getNormal(Point3D point3D) {
        Vector n = point3D.subtract(this._axisRay.getP0());
        double t = n.dotProduct(this._axisRay.getDir());
        Vector shadow = this._axisRay.getDir();
        if (!isZero(t))
            shadow = this._axisRay.getDir().scale(t);
        return n.subtract(shadow).normalize();
    }

    @Override
    public String toString() {
        return super.toString() +
                "_axisRay=" + _axisRay +
                '}';
    }

    @Override
    public List<GeoPoint> findIntersections(Ray ray) {
        return null;
    }
}
