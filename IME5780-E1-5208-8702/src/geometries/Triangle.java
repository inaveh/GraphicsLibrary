package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import javax.swing.*;
import java.util.List;

import static primitives.Util.isZero;

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
        List<Point3D> intersections = _plane.findIntersections(ray);
        if (intersections == null) return null;

        Point3D p0 = ray.getP0();
        Vector v = ray.getDir();

        // triangle ((0, 0, 0),(1, 0, 0), (0, 1, 0));
        //p0 = 101
        Vector v1 = _vertices.get(0).subtract(p0);
        Vector v2 = _vertices.get(1).subtract(p0); //  0,0,-1
        Vector v3 = _vertices.get(2).subtract(p0); // -1,1,-1

        double s1 = v.dotProduct(v1.crossProduct(v2));
        if (isZero(s1)) return null;
        double s2 = v.dotProduct(v2.crossProduct(v3)); //1,1,0
        if (isZero(s2)) return null;
        double s3 = v.dotProduct(v3.crossProduct(v1));
        if (isZero(s3)) return null;

        if ((s1 > 0 && s2 > 0 && s3 > 0) || (s1 < 0 && s2 < 0 && s3 < 0))
            return intersections;
        return null;
    }
}
