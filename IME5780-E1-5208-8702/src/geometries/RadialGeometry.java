package geometries;

/**
 * Class RadialGeometries implements Geometry
 *
 * @author AhronS and IsraelN
 */
public abstract class RadialGeometry implements Geometry {
    private Double _radius;

    // ****************************** Constructors *****************************/

    /**
     * RadialGeometry constructor
     *
     * @param _radius radius
     */
    public RadialGeometry(Double _radius) {
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
    public Double getRadius() {
        return _radius;
    }

}
