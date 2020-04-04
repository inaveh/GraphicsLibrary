package geometries;

import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.*;

public class TubeTest {

    @Test

    public void getNormal() {
        // test that Tube getNormal() return the correct answer
        Ray r = new Ray(new Point3D(0, 0, 0), new Vector(0, 0, 1)); //p0=0,0,0  v=0,0,1
        Point3D p = new Point3D(0, 1, 1); //p-p0= 1,0,0
        Tube t = new Tube(1d, r);   //
        assertEquals("bad tube normal", new Vector(0, 1, 0), t.getNormal(p));
    }
}