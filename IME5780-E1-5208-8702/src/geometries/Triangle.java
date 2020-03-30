package geometries;

import primitives.Point3D;
/**
 *class Triangle for describe triangle object
 * this class extends from Polygon
 * @author AhronS, IsraelN
 */
public class Triangle extends Polygon {

    // ****************************** Constructors *****************************/
    /**
     * Triangle constructor by super
     * @param a one point
     * @param b one point
     * @param c one point
     */
    public Triangle(Point3D a, Point3D b, Point3D c){
        super(a, b, c);
    }

    /****************************** Overrides *****************************/
    @Override
    public String toString() {
        return super.toString();
    }
}
