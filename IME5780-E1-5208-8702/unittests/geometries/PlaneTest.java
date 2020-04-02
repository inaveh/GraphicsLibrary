package geometries;

import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.Assert.*;

public class PlaneTest {

    @Test
    public void testGetNormal() {
        Point3D point3D = new Point3D(0,1,1); //-1,0,0
        Vector vector = new Vector(1,1,1); //
        // ============ Equivalence Partitions Tests ==============
        // Test that get normal of plane return the correct answer
        assertEquals("Bad normal to plane",new Vector(0,1,-1) ,new Vector(point3D.subtract(vector.getHead())).crossProduct(vector).normalize());
    }
}