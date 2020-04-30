package elements;

import org.junit.Test;
import primitives.*;
import geometries.*;

import java.util.List;

import static org.junit.Assert.assertEquals;

class CameraIntegrationTest {
    Camera cam1 = new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0));
    Camera cam2 = new Camera(new Point3D(0, 0, -0.5), new Vector(0, 0, 1), new Vector(0, -1, 0));

    @Test
    void constructRayThroughPixelWithSphere1() {
        //TO DO
        Sphere sph =  new Sphere((double) 1, new Point3D(0, 0, 3));

        int count = 0;
        int Nx =3;
        int Ny =3;
        for (int i = 0; i < Nx; ++i) {
            for (int j = 0; j < Ny; ++j) {
                Ray ray = cam1.constructRayThroughPixel(3,3,j,i,1,3,3);
                List<Point3D> results = sph.findIntersections(ray);
                if (results != null)
                    count += results.size();
            }
        }

        assertEquals("too bad",2,count);
        System.out.println("count: "+count);

    }
    @Test
    void constructRayThroughPixelWithSphere2() {
        Sphere sph =  new Sphere(2.5, new Point3D(0, 0, 2.5));

        List<Point3D> results;
        int count = 0;
        // TODO explanations
        int Nx =3;
        int Ny =3;

        // TODO explanations
        for (int i = 0; i < Nx; ++i) {
            for (int j = 0; j < Ny; ++j) {
                results = sph.findIntersections(cam2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    count += results.size();
            }
        }

        assertEquals("too bad",18,count);
        System.out.println("count: "+count);
    }
}