package geometries;

import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.Assert.*;

public class SphereTest {

    @Test
    public void testGetNormal() {
        Sphere s1 = new Sphere(1d, new Point3D(0, 0, 1));
        // ============ Equivalence Partitions Tests ==============
        // Test that get normal of sphere return the correct answer
        assertEquals("Bad normal to sphere",new Vector(0,0,-1), s1.getNormal(new Point3D(0,0,2)));
    }
}