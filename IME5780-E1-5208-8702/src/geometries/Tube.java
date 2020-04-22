package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

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

    // ****************************** Constructors *****************************/

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
    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }
}
