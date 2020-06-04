package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * class Directional light
 */
public class DirectionalLight extends Light implements LightSource {
    private Vector _direction;

    // ****************************** Constructors *****************************//

    /**
     * constructor directional light
     *
     * @param _intensity intensity
     * @param _direction direction
     */
    public DirectionalLight(Color _intensity, Vector _direction) {
        super(_intensity);
        this._direction = _direction.normalized();
    }

    // ****************************** Overrides *****************************//

    @Override
    public Color getIntensity(Point3D p) {
        return super.getIntensity();
    }

    @Override
    public Vector getL(Point3D p) {
        return _direction;
    }
}