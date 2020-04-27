package geometries;

import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Testing Triangle
 *
 * @author AhronS and IsraelN
 */
public class TriangleTest {

    /**
     * Test method for
     * {@link geometries.Triangle#getNormal(Point3D)}.
     */
    @Test
    public void testGetNormal() {

        // ============ Equivalence Partitions Tests ==============
        // Test that get normal of triangle return the correct answer
        Triangle pl = new Triangle(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
        double sqrt3 = Math.sqrt(1d / 3);
        assertEquals("Bad normal to triangle", new Vector(sqrt3, sqrt3, sqrt3), pl.getNormal(new Point3D(1, 0, 1)));
    }

    @Test
    public void testFindIntersections() {
        Triangle triangle = new Triangle(new Point3D(0, 0, 0), new Point3D(1, 0, 0), new Point3D(0, 1, 0));

        // ============ Equivalence Partitions Tests ==============
        // TC01: Ray's inside the triangle  (1 points)
        assertEquals("bad findIntersections of triangle", List.of(new Point3D(0.5, 0.5, 0)), triangle.findIntersections(new Ray(new Point3D(0.5, 0.5, 1), new Vector(0, 0, -1))));

        // TC02: Ray's outside against edge (0 points)
        assertNull("bad findIntersections of triangle", triangle.findIntersections(new Ray(new Point3D(2,2,1),new Vector(0,0,-1))));

        // TC03: Ray's outside against vertex (0 points)
        assertNull("bad findIntersections of triangle", triangle.findIntersections(new Ray(new Point3D(-1,-1,1),new Vector(0,0,-1))));


        // =============== Boundary Values Tests ==================
        // TC04: Ray's on edge (0 points)
        assertNull("bad findIntersections of triangle", triangle.findIntersections(new Ray(new Point3D(0.5,0,1),new Vector(0,0,-1))));

        // TC05: Ray's in vertex (0 points)
        assertNull("bad findIntersections of triangle", triangle.findIntersections(new Ray(new Point3D(1,0,1),new Vector(0,0,-1))));

        // TC06: Ray's on edge's continuation (0 points)
        assertNull("bad findIntersections of triangle", triangle.findIntersections(new Ray(new Point3D(2,0,1),new Vector(0,0,-1))));
    }
}