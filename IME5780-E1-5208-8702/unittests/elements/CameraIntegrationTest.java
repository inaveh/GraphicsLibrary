package elements;

import geometries.*;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Integration Testing for Camera Class with intersections of geometries (plane, sphere, triangle)
 *
 * @author AhronS and IsraelN
 */
public class CameraIntegrationTest {
    Vector v001 = new Vector(0, 0, 1);
    Vector v0_10 = new Vector(0, -1, 0);
    Camera cam1 = new Camera(Point3D.ZERO, v001, v0_10);
    Camera cam2 = new Camera(new Point3D(0, 0, -0.5), v001, v0_10);

    /**
     * @param geo            geometries shape
     * @param Nx             pixels on width
     * @param Ny             pixels on height
     * @param cam            the place of camera
     * @param screenDistance dst from view plane
     * @param screenWidth    screen width
     * @param screenHeight   screen height
     * @return how much intersections
     */
    public int getIntersections(Geometry geo, int Nx, int Ny, Camera cam,
                                double screenDistance, double screenWidth, double screenHeight) {
        int count = 0;
        for (int i = 0; i < Nx; ++i) {
            for (int j = 0; j < Ny; ++j) {
                Ray ray = cam.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3);
                List<Intersectable.GeoPoint> amountOfIntersections = geo.findIntersections(ray);
                if (amountOfIntersections != null) {
                    count += amountOfIntersections.size();
                }
            }
        }
        return count;
    }

    /**
     * test method for camera and sphere
     * {@link elements.CameraIntegrationTest# constructRayThroughPixel(int, int, int, int, double, double, double), findIntersection(Ray)}.
     */
    @Test
    public void testCaseSphere() {
        Sphere sphere1 = new Sphere(1d, new Point3D(0, 0, 3));
        Sphere sphere2 = new Sphere(2.5, new Point3D(0, 0, 2.5));
        Sphere sphere3 = new Sphere(2d, new Point3D(0, 0, 2));
        Sphere sphere4 = new Sphere(4d, new Point3D(0, 0, 0));
        Sphere sphere5 = new Sphere(0.5, new Point3D(0, 0, -1));

        //test case for sphere 1 (2 points)
        assertEquals("Incorrect amount of intersections", 2, getIntersections(sphere1, 3, 3, cam1, 1, 3, 3));
        //test case for sphere 2 (18 points)
        assertEquals("Incorrect amount of intersections", 18, getIntersections(sphere2, 3, 3, cam2, 1, 3, 3));
        //test case for sphere 3 (10 points)
        assertEquals("Incorrect amount of intersections", 10, getIntersections(sphere3, 3, 3, cam2, 1, 3, 3));
        //test case for sphere 4 (9 points)
        assertEquals("Incorrect amount of intersections", 9, getIntersections(sphere4, 3, 3, cam1, 1, 3, 3));
        //test case for sphere 5 (0 points)
        assertEquals("Incorrect amount of intersections", 0, getIntersections(sphere5, 3, 3, cam1, 1, 3, 3));
    }

    /**
     * test method for camera and plane
     * {@link elements.CameraIntegrationTest# constructRayThroughPixel(int, int, int, int, double, double, double), findIntersection(Ray)}.
     */
    @Test
    public void testCasePlane() {
        Plane plane1 = new Plane(new Point3D(0, 0, 3), new Vector(0, 0, 1));
        Plane plane2 = new Plane(new Point3D(0.5, -1.5, 2), new Point3D(0, 0, 2.5), new Point3D(0, 1.5, 3));
        Plane plane3 = new Plane(new Point3D(0.5, -2, 2), new Point3D(0, 0, 4), new Point3D(0, 2, 6));

        //test case for plane 1 (9 points)
        assertEquals("Incorrect amount of intersections", 9, getIntersections(plane1, 3, 3, cam1, 1, 3, 3));
        //test case for plane 2 (9 points)
        assertEquals("Incorrect amount of intersections", 9, getIntersections(plane2, 3, 3, cam1, 1, 3, 3));
        //test case for plane 3 (6 points)
        assertEquals("Incorrect amount of intersections", 6, getIntersections(plane3, 3, 3, cam1, 1, 3, 3));
    }

    /**
     * test method for camera and triangle
     * {@link elements.CameraIntegrationTest# constructRayThroughPixel(int, int, int, int, double, double, double), findIntersection(Ray)}.
     */
    @Test
    public void testCaseTriangle() {
        Triangle triangle1 = new Triangle(new Point3D(0, -1, 2), new Point3D(1, 1, 2), new Point3D(-1, 1, 2));
        Triangle triangle2 = new Triangle(new Point3D(0, -20, 2), new Point3D(1, 1, 2), new Point3D(-1, 1, 2));

        //test case for triangle 1 (1 points)
        assertEquals("Incorrect amount of intersections", 1, getIntersections(triangle1, 3, 3, cam1, 1, 3, 3));
        //test case for triangle 1 (1 points)
        assertEquals("Incorrect amount of intersections", 2, getIntersections(triangle2, 3, 3, cam1, 1, 3, 3));
    }
}