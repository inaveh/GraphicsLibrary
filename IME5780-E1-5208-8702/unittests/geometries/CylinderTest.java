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
        Cylinder t = new Cylinder(1d, r, 15d);
        Cylinder t2 = new Cylinder(1d, r, 1d);
        Cylinder t3 = new Cylinder(1d, r, 15d);
        Point3D p = new Point3D(0, 1, 1);

        // ============ Equivalence Partitions Tests ==============
        // Test cylinder getNormal() return the correct answer
        assertEquals("bad cylinder normal", new Vector(0, 1, 0), t.getNormal(p));

        // =============== Boundary Values Tests ==================
        // Test when height and the vec of Cylinder is same equals
        assertEquals("bad cylinder normal", new Vector(0, 0, 1), t2.getNormal(p));

        // Test when t==0, orthogonal, on same base
        assertEquals("bad cylinder normal", new Vector(0, 0, 1), t3.getNormal(new Point3D(0, 1, 0)));
    }


}