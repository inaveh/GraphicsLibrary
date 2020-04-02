package geometries;

import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.*;

public class TubeTest {

    @Test
    public void getNormal() {
        Ray r = new Ray(new Point3D(0, 0, 0), new Vector(0, 0, 1));
        Point3D p = new Point3D(1, 0, 0);
        Tube t = new Tube(5d, r);
        assertEquals("",new Vector(0,0,1) ,t.getNormal(p));
    }
}