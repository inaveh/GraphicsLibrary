package elements;

import primitives.Color;

/**
 * class for ambient light
 * to add light for our image
 */
public class AmbientLight {
    private Color _intensity;

    /**
     * constructor ambient light
     */
    public AmbientLight(Color i, double k) {
        _intensity = i.scale(k);
    }

    public Color GetIntensity(){
        return null;
    }
}
