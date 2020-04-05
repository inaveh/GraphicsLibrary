package geometries;

import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.*;

/**
 * Testing Tube
 *
 * @author AhronS and IsraelN
 */
public class TubeTest {

    /**
     * Test method for
     * {@link geometries.Tube#getNormal(Point3D)}.
     */
    @Test
    public void getNormal() {

        //============ Equivalence Partitions Tests ==============
        // test that Tube getNormal() return the correct answer
        Ray r = new Ray(new Point3D(0, 0, 0), new Vector(0, 0, 1));
        Point3D p = new Point3D(0, 1, 1);
        Tube t = new Tube(1d, r);
        assertEquals("bad tube normal", new Vector(0, 1, 0), t.getNormal(p));
    }
}