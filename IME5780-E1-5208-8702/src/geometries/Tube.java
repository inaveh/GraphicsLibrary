package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

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
        Point3D p0 = _axisRay.getP0();
        Vector v = _axisRay.getDir();
        Vector n = point3D.subtract(p0);
        Double t = v.dotProduct(n);
        if (!isZero(t))
            p0.add(v.scale(t));
        return (point3D.subtract(p0)).normalize();
    }

    @Override
    public String toString() {
        return super.toString() +
                "_axisRay=" + _axisRay +
                '}';
    }
}
