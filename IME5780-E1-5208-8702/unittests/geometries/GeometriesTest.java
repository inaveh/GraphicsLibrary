package geometries;

import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.*;

/**
 * Test class for GeometriesTest
 * @author AhronS and IsraelN
 */
public class GeometriesTest {

    /**
     * Test Method for Geometries
     * {@link Geometries#findIntersections(Ray)}
     */
    @Test
    public void findIntersections() {
        Sphere sphere = new Sphere(1d, new Point3D(3, 0 ,0));
        Triangle triangle = new Triangle(
                new Point3D(0,1,0), new Point3D(0,4,0), new Point3D(0,3,1.82));
        Plane plane = new Plane(new Point3D(1,0,0), new Point3D(3,4,0), new Point3D(2,2,3));

        // ============ Equivalence Partitions Tests ==============
        Geometries geometries = new Geometries();
        geometries.add(sphere, triangle, plane);

        //TC01: No geometry is intersected (0 points)
        assertNull("No geometry is intersected",
                geometries.findIntersections(new Ray(new Point3D(2,-4,0), new Vector(3, 0, 0))));

        //TC02: Only one geometry is intersected (1 point)
        assertEquals("one geometry is intersected" ,1,
                (geometries.findIntersections(new Ray(new Point3D(2,-3,0), new Vector(-2, 1, 1.5)))).size());

        //TC03: Many (But not All) geometries are intersected (2 points)
        assertEquals( "Not all geometries intersected" ,2,
                (geometries.findIntersections(new Ray(new Point3D(2,-3,0), new Vector(-2, 6, 0.6)))).size());

        // =============== Boundary Values Tests ==================
        //TC04: All the geometries are intersected (4 points)
        assertEquals("All geometries are intersected" ,4,
                (geometries.findIntersections(new Ray(new Point3D(5,-2,0), new Vector(-5, 5, 0.5)))).size());
        geometries = new Geometries();

        //TC05: Objects Collection is empty (0 points)
        assertNull("Collection is empty",
                geometries.findIntersections(new Ray(new Point3D(6,-3,0), new Vector(-6,6,2))));

    }
}