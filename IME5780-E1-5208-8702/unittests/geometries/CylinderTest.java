package geometries;

import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.*;

/**
 * Testing Cylinder
 *
 * @author AhronS and IsraelN
 */
public class CylinderTest {

    /**
     * Test method for
     * {@link geometries.Cylinder#getNormal(primitives.Point3D)}.
     */
    @Test
    public void testGetNormal() {
        Ray r = new Ray(new Point3D(0, 0, 0), new Vector(0, 0, 1));
        Cylinder c1 = new Cylinder(1d, r, 15d);
        Cylinder c2 = new Cylinder(1d, r, 1d);
        Point3D p1 = new Point3D(0, 1, 1);
        Point3D p2 = new Point3D(0, 0.5, 1);
        Point3D p3 = new Point3D(0, 0.5, 0);
        Point3D p4 = new Point3D(0, 0, 15);
        Point3D p5 = new Point3D(0, 1, 0);
        Point3D p6 = new Point3D(0, 1, 15d);

        // ============ Equivalence Partitions Tests ==============
        // Test cylinder getNormal() return the correct answer point on the body of cylinder (like tube)
        assertEquals("bad cylinder normal", new Vector(0, 1, 0), c1.getNormal(p1));

        // Test when height and the vec of Cylinder is same equals (on the top base)
        assertEquals("bad cylinder normal", r.getDir(), c2.getNormal(p2));

        // Test when orthogonal, on the down base
        assertEquals("bad cylinder normal", r.getDir(), c1.getNormal(p3));

        // =============== Boundary Values Tests ==================
        // Test when point is the center of top base
        assertEquals("bad cylinder normal", r.getDir(), c1.getNormal(r.getP0()));

        // Test when point is the center of down base
        assertEquals("bad cylinder normal", r.getDir(), c1.getNormal(p4));

        // Test when point on the corner between the down base and the body
        assertEquals("bad cylinder normal", r.getDir(), c1.getNormal(p5));

        // Test when point on the corner between the top base and the body
        assertEquals("bad cylinder normal", r.getDir(), c1.getNormal(p6));
    }

    @Test
    public void testFindIntersections() {
    }

}