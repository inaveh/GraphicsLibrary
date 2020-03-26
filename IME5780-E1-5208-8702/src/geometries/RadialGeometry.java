package geometries;

import primitives.Point3D;
import primitives.Vector;
/**
 *
 */
public abstract class RadialGeometry implements Geometry {
    Double _radius;

    // ****************************** Constructors *****************************/

    /**
     * RadialGeometry constructor
     * @param _radius radius
     */
    public RadialGeometry (Double _radius){
        this._radius = _radius;
    }

    /**
     * RadialGeometry copy constructor
     * @param other radialGeometry instance
     */
    public RadialGeometry (RadialGeometry other){
        this._radius = other._radius;
    }

    /**
     * RadialGeometry getter
     * @return _radius
     */
    public Double get_radius() {
        return _radius;
    }

}
