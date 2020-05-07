package elements;

import primitives.Color;

/**
 * class for ambient light
 * to add light for our image
 * @author AhronS, IsraelN
 */
public class AmbientLight {
    private Color _intensity;

    /**
     * constructor ambient light
     */
    public AmbientLight(Color i, double k) {
        _intensity = i.scale(k);
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