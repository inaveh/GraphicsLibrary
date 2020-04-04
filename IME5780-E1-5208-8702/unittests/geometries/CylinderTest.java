package geometries;

import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.*;

public class CylinderTest {

    @Test
    public void testGetNormal() {
        // test that Tube getNormal() return the correct answer
        Ray r = new Ray(new Point3D(0, 0, 0), new Vector(0, 0, 1)); //p0=0,0,0  v=0,0,1
        Cylinder t = new Cylinder(1d, r, 15d);   //
        Cylinder t2 = new Cylinder(1d, r, 1d);   //he-t==0
        Cylinder t3 = new Cylinder(1d, r, 15d);   //t==0
        Point3D p = new Point3D(0, 1, 1); //p-p0= 1,0,0
        // ============ Equivalence Partitions Tests ==============
        // Test cylinder getNormal() return the correct answer
        assertEquals("bad cylinder normal", new Vector(0, 1, 0), t.getNormal(p));

        // =============== Boundary Values Tests ==================
        // Test when height and the vec of Cylinder is same equals
        assertEquals("bad cylinder normal", new Vector(0, 0,1), t2.getNormal(p));
        // Test when t==0, orthogonal, on same base
        assertEquals("bad cylinder normal", new Vector(0, 0,1), t3.getNormal(new Point3D(0,1,0)));
    }


}