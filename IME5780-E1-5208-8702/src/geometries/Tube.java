package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
/**
 *
 */
public class Tube extends RadialGeometry {
    Ray _axisRay;

    // ****************************** Constructors *****************************/
    /**
     * Tube constructor
     * @param _radius radius
     * @param _axisRay Ray
     */
    public Tube(Double _radius, Ray _axisRay) {
        super(_radius);
        this._axisRay = _axisRay;
    }

    /**
     * Tube getter
     * @return Ray
     */
    public Ray get_axisRay() {
        return _axisRay;
    }

    /****************************** Overrides *****************************/

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
