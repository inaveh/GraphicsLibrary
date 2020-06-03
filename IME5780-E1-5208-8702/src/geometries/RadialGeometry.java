package geometries;

import primitives.Color;
import primitives.Material;

/**
 * Class RadialGeometries implements Geometry
 *
 * @author AhronS and IsraelN
 */
public abstract class RadialGeometry extends Geometry {
    private double _radius;

    //****************************** Constructors *****************************/

    /**
     * RadialGeometry constructor
     *
     * @param _radius radius
     */
    public RadialGeometry(double _radius) {
        this._radius = _radius;
    }

    /**
     * radial geometry constructor with color
     *
     * @param _emission emission
     * @param _radius   radius
     */
    public RadialGeometry(Color _emission, double _radius) {
        super(_emission);
        this._radius = _radius;
    }

    /**
     * radial geometry constructor with color and material
     *
     * @param _material material
     * @param _emission emission
     * @param _radius   radius
     */
    public RadialGeometry(Material _material, Color _emission, double _radius) {
        this(_emission, _radius);
        this._material = _material;
    }

    /**
     * RadialGeometry copy constructor
     *
     * @param other radialGeometry instance
     */
    public RadialGeometry(RadialGeometry other) {
        super(other._emission, other._material);
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
