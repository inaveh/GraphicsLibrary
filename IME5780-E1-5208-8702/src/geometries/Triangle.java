package geometries;

import primitives.Point3D;
import primitives.Vector;

/**
 * class Triangle for describe triangle object
 * this class extends from Polygon
 *
 * @author AhronS, IsraelN
 */
public class Triangle extends Polygon {

    // ****************************** Constructors *****************************/

    /**
     * Triangle constructor by super
     *
     * @param a one point
     * @param b one point
     * @param c one point
     */
    public Triangle(Point3D a, Point3D b, Point3D c) {
        super(a, b, c);
    }
}
