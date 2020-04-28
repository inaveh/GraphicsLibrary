package geometries;

/**
 * Class RadialGeometries implements Geometry
 *
 * @author AhronS and IsraelN
 */
public abstract class RadialGeometry implements Geometry {
    private double _radius;

    // ****************************** Constructors *****************************/

    /**
     * RadialGeometry constructor
     *
     * @param _radius radius
     */
    public RadialGeometry(double _radius) {
        this._radius = _radius;
    }

    /**
     * RadialGeometry copy constructor
     *
     * @param other radialGeometry instance
     */
    public RadialGeometry(RadialGeometry other) {
        this._radius = other._radius;
    }

    // ****************************** Getters *****************************/

    /**
     * RadialGeometry getter
     *
     * @return _radius
     */
    public double getRadius() {
        return _radius;
    }

}
