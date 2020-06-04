package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * class for improve the spot light (sharp spot beam)
 * bonus class:)
 */
public class SpotLightImproved extends SpotLight {
    public SpotLightImproved(Color _colorIntensity, Point3D _position, Vector _direction, double _kC, double _kL, double _kQ, double _concentration) {
        super(_colorIntensity, _position, _direction, _kC, _kL, _kQ);
        this._concentration = _concentration;
    }

    @Override
    public Color getIntensity(Point3D p) {
        double dSquared = p.distanceSquared(_position);
        double d = p.distance(_position);

        Vector vector;
        if (p.subtract(_position).normalized() == null)
            vector = new Vector(_direction);
        else
            vector = p.subtract(_position).normalized();

        return (_intensity.scale(Math.max(0, Math.pow(_direction.dotProduct(vector), _concentration)))
                .reduce(_kC + _kL * d + _kQ * dSquared));
    }
}
