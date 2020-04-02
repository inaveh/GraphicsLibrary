package geometries;

import jdk.jfr.Description;
import jdk.jfr.MetadataDefinition;
import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.Assert.*;

public class TriangleTest {

    /**
     *
     */
    @Test
    public void testGetNormal() {
        Point3D p1 = new Point3D(1, 1, 1);
        Point3D p2 = new Point3D(2, 2, 2); //p2-p1=1,1,1
        Point3D p3 = new Point3D(1, 1, 1); //
        // ============ Equivalence Partitions Tests ==============
        // Test that get normal of triangle return the correct answer
        Triangle pl = new Triangle(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
        double sqrt3 = Math.sqrt(1d / 3);
        assertEquals("Bad normal to triangle", new Vector(sqrt3, sqrt3, sqrt3), pl.getNormal(new Point3D(1, 0, 1)));
    }
}