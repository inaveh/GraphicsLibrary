package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * class point light
 */
public class PointLight extends Light implements LightSource {
    protected Point3D _position;
    protected double _kC, _kL, _kQ;

    /**
     * constructor point light
     *
     * @param _intensity intensity
     * @param _position  position
     * @param _kC        kc
     * @param _kL        kl
     * @param _kQ        kq
     */
    public PointLight(Color _intensity, Point3D _position, double _kC, double _kL, double _kQ) {
        super(_intensity);
        this._position = _position;
        this._kC = _kC;
        this._kL = _kL;
        this._kQ = _kQ;
    }

    @Override
    public Color getIntensity(Point3D p) {

        return super.getIntensity();
    }

    @Override
    public Vector getL(Point3D p) {
        return null;
    }
}
