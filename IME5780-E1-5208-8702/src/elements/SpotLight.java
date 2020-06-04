package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Util;
import primitives.Vector;

import static primitives.Util.isZero;

/**
 * class spot light
 */
public class SpotLight extends PointLight {
    protected Vector _direction;
    protected double _concentration;

    // ****************************** Constructors *****************************//

    /**
     * constructor spot light with concentration
     *
     * @param _intensity     intensity
     * @param _position      position
     * @param _direction     direction
     * @param _kC            kc
     * @param _kL            kl
     * @param _kQ            kq
     * @param _concentration concentration
     */
    public SpotLight(Color _intensity, Point3D _position, Vector _direction, double _kC, double _kL, double _kQ, double _concentration) {
        super(_intensity, _position, _kC, _kL, _kQ);
        this._direction = new Vector(_direction).normalized();
        this._concentration = _concentration;
    }

    /**
     * constructor spot light
     *
     * @param _intensity intensity
     * @param _position  position
     * @param _direction direction
     * @param _kC        kc
     * @param _kL        kl
     * @param _kQ        kq
     */
    public SpotLight(Color _intensity, Point3D _position, Vector _direction, double _kC, double _kL, double _kQ) {
        this(_intensity, _position, _direction, _kC, _kL, _kQ, 1);
    }

    // ****************************** Overrides *****************************//

    @Override
    public Color getIntensity(Point3D p) {
        double projection = _direction.dotProduct(getL(p));
        if (Util.isZero(projection))
            return Color.BLACK;
        double factor = Math.max(0, projection);
        Color pointLightIntensity = super.getIntensity(p);
        if (_concentration != 1)
            factor = Math.pow(factor, _concentration);
        return (pointLightIntensity.scale(factor));
    }

    @Override
    public Vector getL(Point3D p) {
        return super.getL(p);
    }
}