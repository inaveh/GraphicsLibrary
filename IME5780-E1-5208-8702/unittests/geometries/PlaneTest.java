package geometries;


import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;


import java.util.List;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Testing Plane
 *
 * @author AhronS and IsraelN
 */
public class PlaneTest {

    /**
     * Test method for
     * {@link geometries.Plane#getNormal(primitives.Point3D)}.
     */
    @Test
    public void testGetNormal() {
        Point3D point3D = new Point3D(0, 1, 1); //-1,0,0
        Vector vector = new Vector(1, 1, 1); //

        // ============ Equivalence Partitions Tests ==============
        // Test that get normal of plane return the correct answer
        assertEquals("Bad normal to plane", new Vector(0, 1, -1), new Vector(point3D.subtract(vector.getHead())).crossProduct(vector));
    }

    /**
     * Test Method for Plane
     * {@link Plane#findIntersections(Ray)}
     */
    @Test
    public void testFindIntersections() {
        Point3D p000 = new Point3D(0, 0, 0);
        Point3D p100 = new Point3D(1, 0, 0);
        Point3D p010 = new Point3D(0, 1, 0);
        Point3D p001 = new Point3D(0, 0, 1);
        Point3D p110 = new Point3D(1, 1, 0);
        Point3D p111 = new Point3D(1, 1, 1);

        Plane plane = new Plane(p100, p010, p000);
        List<Intersectable.GeoPoint> resultP110 = List.of(new Intersectable.GeoPoint(plane,p110));
        List<Intersectable.GeoPoint> resultP000 = List.of(new Intersectable.GeoPoint(plane,p000));
        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray is neither orthogonal nor parallel (1 points)
        assertEquals("bad findIntersections of plane", resultP110, plane.findIntersections(new Ray(p001, new Vector(1, 1, -1))));

        // TC02: Ray is neither orthogonal nor parallel (0 points)
        assertNull("bad findIntersections of plane", plane.findIntersections(new Ray(p001, new Vector(1, 1, 2))));

        // =============== Boundary Values Tests ==================
        // **** Group: Ray is parallel to the plane

        // TC03: Ray is included in the plane (0 point)
        assertNull("bad findIntersections of plane", plane.findIntersections(new Ray(p000, new Vector(p110))));

        // TC04: Ray is not included in the plane (0 point)
        assertNull("bad findIntersections of plane", plane.findIntersections(new Ray(p001, new Vector(p110))));

        // **** Group: Ray is orthogonal to the plane

        // TC05: Ray is before the plane (1 point)
        assertEquals("bad findIntersections of plane", resultP000, plane.findIntersections(new Ray(new Point3D(0, 0, -1), new Vector(p001))));

        // TC06: Ray is in the plane (0 point)
        assertNull("bad findIntersections of plane", plane.findIntersections(new Ray(p000, new Vector(p001))));

        // TC07: Ray after the plane (0 point)
        assertNull("bad findIntersections of plane", plane.findIntersections(new Ray(p001, new Vector(0,0,2))));

        // TC08: Ray begins at the plane (0 point)
        assertNull("bad findIntersections of plane", plane.findIntersections(new Ray(p110, new Vector(p111))));

        // TC09: Ray is the same point as reference point in the plane (0 point)
        assertNull("bad findIntersections of plane", plane.findIntersections(new Ray(p100, new Vector(p111))));
    }
}
