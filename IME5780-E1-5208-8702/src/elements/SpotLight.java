package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * class spot light
 */
public class SpotLight extends PointLight {
    private Vector _direction;
    private double _concentration;

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
        super(_intensity, _position, _kC, _kL, _kQ);
        this._direction = _direction;
    }

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
        this(_intensity, _position, _direction, _kC, _kL, _kQ);
        this._concentration = _concentration;
    }
}
