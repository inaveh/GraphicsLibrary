package geometries;

import elements.LightSource;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Testing Sphere
 *
 * @author AhronS and IsraelN
 */
public class SphereTest {

    /**
     * Test method for
     * {@link geometries.Sphere#getNormal(primitives.Point3D)}.
     */
    @Test
    public void testGetNormal() {
        Sphere s1 = new Sphere(1d, new Point3D(0, 0, 1));

        // ============ Equivalence Partitions Tests ==============
        // Test that get normal of sphere return the correct answer
        assertEquals("Bad normal to sphere", new Vector(0, 0, 1), s1.getNormal(new Point3D(0, 0, 2)));
    }

    /**
     * Test method for Sphere
     * {@link geometries.Sphere#findIntersections(Ray)}.
     */
    @Test
    public void testFindIntersections() {
        Point3D p110 = new Point3D(1, 1, 0);
        Point3D p010 = new Point3D(0, 1, 0);
        Vector v110 = new Vector(p110);
        Sphere sphere = new Sphere(1d, new Point3D(1, 0, 0));

        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray's line is outside the sphere (0 points)
        assertNull("Ray's line out of sphere", sphere.findIntersections(new Ray(new Point3D(-1, 0, 0), v110)));

        // TC02: Ray starts before and crosses the sphere (2 points)
        Point3D p1 = new Point3D(0.0651530771650466, 0.355051025721682, 0);
        Point3D p2 = new Point3D(1.53484692283495, 0.844948974278318, 0);
        List<Intersectable.GeoPoint> result2 = List.of(new Intersectable.GeoPoint(sphere, p1), new Intersectable.GeoPoint(sphere, p2));
        List<Intersectable.GeoPoint> result3 = List.of(new Intersectable.GeoPoint(sphere,p110));
        List<Intersectable.GeoPoint> result = sphere.findIntersections(new Ray(new Point3D(-1, 0, 0),
                new Vector(3, 1, 0)));
        assertEquals("Wrong number of points", 2, result.size());

        if (result.get(0).point.getX().get() > result.get(1).point.getX().get())
            result = List.of(result.get(1), result.get(0));         //sort
        assertEquals("Ray crosses sphere", result2, result);


        // TC03: Ray starts inside the sphere (1 point)
        assertEquals("Ray from inside sphere", List.of(new Intersectable.GeoPoint(sphere,p110)),
                sphere.findIntersections(new Ray(new Point3D(0.5, 0, 0), new Vector(0.5, 1, 0))));

        // TC04: Ray starts after the sphere (0 points)
        assertNull("Sphere behind Ray", sphere.findIntersections(new Ray(new Point3D(2, 2, 0), v110)));

        // =============== Boundary Values Tests ==================
        // **** Group: Ray's line crosses the sphere (but not the center)

        // TC11: Ray starts at sphere and goes inside (1 points)
        assertEquals("Ray from sphere inside", List.of(new Intersectable.GeoPoint(sphere, new Point3D(2, 0, 0))),
                sphere.findIntersections(new Ray(new Point3D(1, -1, 0), v110)));

        // TC12: Ray starts at sphere and goes outside (0 points)
        assertNull("Ray from sphere outside", sphere.findIntersections(new Ray(new Point3D(2, 0, 0), v110)));

        // **** Group: Ray's line goes through the center
        // TC13: Ray starts before the sphere (2 points)
        result = sphere.findIntersections(new Ray(new Point3D(1, -2, 0), new Vector(p010)));

        assertEquals("Wrong number of points", 2, result.size());
        if (result.get(0).point.getY().get() > result.get(1).point.getY().get()) {
            result = List.of(result.get(1), result.get(0));
        }
        assertEquals("Line through O, ray crosses sphere", List.of(new Intersectable.GeoPoint(sphere,new Point3D(1, -1, 0)),
                new Intersectable.GeoPoint(sphere, p110)), result);

        // TC14: Ray starts at sphere and goes inside (1 points)
        assertEquals("Line through O, ray from and crosses sphere", result3,
                sphere.findIntersections(new Ray(new Point3D(1, -1, 0), new Vector(0, 1, 0))));

        // TC15: Ray starts inside (1 points)
        assertEquals("Line through O, ray from inside sphere", result3,
                sphere.findIntersections(new Ray(new Point3D(1, 0.5, 0), new Vector(0, 1, 0))));

        // TC16: Ray starts at the center (1 points)
        assertEquals("Line through O, ray from O",result3,
                sphere.findIntersections(new Ray(new Point3D(1, 0, 0), new Vector(0, 1, 0))));

        // TC17: Ray starts at sphere and goes outside (0 points)
        assertNull("Line through O, ray from sphere outside", sphere.findIntersections(new Ray(p110, new Vector(0, 1, 0))));

        // TC18: Ray starts after sphere (0 points)
        assertNull("Line through O, ray outside sphere", sphere.findIntersections(new Ray(new Point3D(1, 2, 0), new Vector(0, 1, 0))));

        // **** Group: Ray's line is tangent to the sphere (all tests 0 points)
        // TC19: Ray starts before the tangent point
        assertNull("Tangent line, ray before sphere", sphere.findIntersections(new Ray(new Point3D(0, 1, 0), new Vector(1, 0, 0))));

        // TC20: Ray starts at the tangent point
        assertNull("Tangent line, ray at sphere", sphere.findIntersections(new Ray(p110, new Vector(1, 0, 0))));

        // TC21: Ray starts after the tangent point
        assertNull("Tangent line, ray after sphere", sphere.findIntersections(new Ray(new Point3D(2, 1, 0), new Vector(1, 0, 0))));

        // **** Group: Special cases
        // TC19: Ray's line is outside, ray is orthogonal to ray start to sphere's
        // center line
        assertNull("Ray orthogonal to ray head -> O line", sphere.findIntersections(new Ray(new Point3D(-1, 0, 0), new Vector(0, 0, 1))));
    }
}
