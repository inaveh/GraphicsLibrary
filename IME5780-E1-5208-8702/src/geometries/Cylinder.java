package geometries;

import primitives.Point3D;
import primitives.Vector;

/**
 * class Cylinder for describe Cylinder object
 * this class extends from RadialGeometry
 *
 * @author AhronS, IsraelN
 */
public class Cylinder extends RadialGeometry {
    private Double _height;

    // ****************************** Constructors *****************************/
    /**
     * Cylinder constructor
     *
     * @param _radius radius
     * @param _height the height
     */
    public Cylinder(Double _radius, Double _height) {
        super(_radius);
        this._height = _height;
    }

    /**
     * Cylinder getter
     *
     * @return height
     */
    public Double getHeight() {
        return _height;
    }

    /****************************** Overrides *****************************/
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