package elements;

import primitives.Color;

/**
 * class Light
 */
abstract class Light {
    protected Color _intensity;

    /**
     * light constructor
     *
     * @param _intensity intensity
     */
    public Light(Color _intensity) {
        this._intensity = _intensity;
    }

    /**
     * getter for intensity
     *
     * @return intensity
     */
    public Color getIntensity() {
        return _intensity;
    }

}
