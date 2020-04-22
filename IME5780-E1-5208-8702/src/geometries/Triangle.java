package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

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

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        return super.findIntersections(ray);
    }
}
