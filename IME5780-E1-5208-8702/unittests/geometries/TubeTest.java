package geometries;

import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.*;

public class TubeTest {

    @Test
    public void getNormal() {
        Ray r = new Ray(new Point3D(0, 0, 0), new Vector(1, 1, 1)); //p0=0,0,0  v=1,1,1
        Point3D p = new Point3D(1, 0, 0); //p-p0= 1,0,0  - 1,1,1=0,-1,-1
        Tube t = new Tube(1d, r);   //1,0,0* 1,1,1= 1d   0,0,0= 1,1,1   1(1,1,1)
        assertEquals("",new Vector(0,-1,-1).normalize(),t.getNormal(p));
    }
}