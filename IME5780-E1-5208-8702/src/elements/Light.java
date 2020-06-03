package elements;

import primitives.Color;

/**
 * class Light base class for the Lights
 *
 */
abstract class Light {
    protected Color _intensity;

    // ****************************** Constructors *****************************//

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
