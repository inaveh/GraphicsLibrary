package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

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

    /**
     * Tube getter
     *
     * @return Ray
     */
    public Ray getAxisRay() {
        return _axisRay;
    }

    /****************************** Overrides *****************************/
    @Override
    public Vector getNormal(Point3D point3D) {
        Vector n = new Vector(point3D.subtract(this._axisRay.getP0()));
        Double t = n.dotProduct(this._axisRay.getDir());
        Vector shadow= this._axisRay.getDir().scale(t);
        return n.subtract(shadow).normalize().scale(-1);
    }

    @Override
    public String toString() {
        return super.toString() +
                "_axisRay=" + _axisRay +
                '}';
    }
}
