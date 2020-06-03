package elements;

import primitives.Color;

import java.awt.*;

/**
 * class for ambient light
 * to add light for our image
 *
 * @author AhronS, IsraelN
 */
public class AmbientLight extends Light {

    /**
     * constructor ambient light
     */
    public AmbientLight(Color i, double k) {
        super(i.scale(k));
    }

}