package elements;

import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
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
     * test method for camera and sphere
     * {@link elements.CameraIntegrationTest# constructRayThroughPixel(int, int, int, int, double, double, double), findIntersection(Ray)}.
     */
    @Test
    public void firstTestCaseSphere() {
        Sphere sphere = new Sphere(1d, new Point3D(0, 0, 3));
        int Nx = 3;
        int Ny = 3;
        int count = 0;
        for (int i = 0; i < Nx; ++i) {
            for (int j = 0; j < Ny; ++j) {
                Ray ray = cam1.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3);
                List<Point3D> amountOfIntersections = sphere.findIntersections(ray);
                if (amountOfIntersections != null)
                    count += ((List) amountOfIntersections).size();
            }
        }
        assertEquals("Incorrect amount of intersections", 2, count);
    }

    /**
     * test method for camera and sphere
     * {@link elements.CameraIntegrationTest# constructRayThroughPixel(int, int, int, int, double, double, double), findIntersection(Ray)}.
     */
    @Test
    public void secondTestCaseSphere() {
        Sphere sphere = new Sphere(2.5, new Point3D(0, 0, 2.5));
        List<Point3D> amountOfIntersections;
        int count = 0;
        int Nx = 3;
        int Ny = 3;
        for (int i = 0; i < Nx; ++i) {
            for (int j = 0; j < Ny; ++j) {
                amountOfIntersections = sphere.findIntersections(cam2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (amountOfIntersections != null)
                    count += amountOfIntersections.size();
            }
        }
        assertEquals("Incorrect amount of intersections", 18, count);
    }

    /**
     * test method for camera and sphere
     * {@link elements.CameraIntegrationTest# constructRayThroughPixel(int, int, int, int, double, double, double), findIntersection(Ray)}.
     */
    @Test
    public void thirdTestCaseSphere() {
        Sphere sphere = new Sphere(2d, new Point3D(0, 0, 2));
        List<Point3D> amountOfIntersections;
        int count = 0;
        int Nx = 3;
        int Ny = 3;
        for (int i = 0; i < Nx; ++i) {
            for (int j = 0; j < Ny; ++j) {
                amountOfIntersections = sphere.findIntersections(cam2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (amountOfIntersections != null)
                    count += amountOfIntersections.size();
            }
        }
        assertEquals("Incorrect amount of intersections", 10, count);
    }

    /**
     * test method for camera and sphere
     * {@link elements.CameraIntegrationTest# constructRayThroughPixel(int, int, int, int, double, double, double), findIntersection(Ray)}.
     */
    @Test
    public void fourthTestCaseSphere() {
        Sphere sphere = new Sphere(4d, new Point3D(0, 0, 0));
        List<Point3D> amountOfIntersections;
        int count = 0;
        int Nx = 3;
        int Ny = 3;
        for (int i = 0; i < Nx; ++i) {
            for (int j = 0; j < Ny; ++j) {
                amountOfIntersections = sphere.findIntersections(cam1.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (amountOfIntersections != null)
                    count += amountOfIntersections.size();
            }
        }
        assertEquals("Incorrect amount of intersections", 9, count);
    }

    /**
     * test method for camera and sphere
     * {@link elements.CameraIntegrationTest# constructRayThroughPixel(int, int, int, int, double, double, double), findIntersection(Ray)}.
     */
    @Test
    public void fifthTestCaseSphere() {
        Sphere sphere = new Sphere(0.5, new Point3D(0, 0, -1));
        List<Point3D> amountOfIntersections;
        int count = 0;
        int Nx = 3;
        int Ny = 3;
        for (int i = 0; i < Nx; ++i) {
            for (int j = 0; j < Ny; ++j) {
                amountOfIntersections = sphere.findIntersections(cam1.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (amountOfIntersections != null)
                    count += amountOfIntersections.size();
            }
        }
        assertEquals("Incorrect amount of intersections", 0, count);
    }

    /**
     * test method for camera and plane
     * {@link elements.CameraIntegrationTest# constructRayThroughPixel(int, int, int, int, double, double, double), findIntersection(Ray)}.
     */
    @Test
    public void firstTestCasePlane() {
        Plane plane = new Plane(new Point3D(0, 0, 3), new Vector(0, 0, 1));
        List<Point3D> amountOfIntersections;
        int count = 0;
        int Nx = 3;
        int Ny = 3;
        for (int i = 0; i < Nx; ++i) {
            for (int j = 0; j < Ny; ++j) {
                amountOfIntersections = plane.findIntersections(cam1.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (amountOfIntersections != null)
                    count += amountOfIntersections.size();
            }
        }
        assertEquals("Incorrect amount of intersections", 9, count);
    }

    /**
     * test method for camera and plane
     * {@link elements.CameraIntegrationTest# constructRayThroughPixel(int, int, int, int, double, double, double), findIntersection(Ray)}.
     */
    @Test
    public void secondTestCasePlane() {
        Plane plane = new Plane(new Point3D(0.5, -1.5, 2), new Point3D(0, 0, 2.5), new Point3D(0, 1.5, 3));
        List<Point3D> amountOfIntersections;
        int count = 0;
        int Nx = 3;
        int Ny = 3;
        for (int i = 0; i < Nx; ++i) {
            for (int j = 0; j < Ny; ++j) {
                amountOfIntersections = plane.findIntersections(cam1.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (amountOfIntersections != null)
                    count += amountOfIntersections.size();
            }
        }
        assertEquals("Incorrect amount of intersections", 9, count);
    }

    /**
     * test method for camera and plane
     * {@link elements.CameraIntegrationTest# constructRayThroughPixel(int, int, int, int, double, double, double), findIntersection(Ray)}.
     */
    @Test
    public void fourthTestCasePlane() {
        Plane plane = new Plane(new Point3D(0.5, -2, 2), new Point3D(0, 0, 4), new Point3D(0, 2, 6));
        List<Point3D> amountOfIntersections;
        int count = 0;
        int Nx = 3;
        int Ny = 3;
        for (int i = 0; i < Nx; ++i) {
            for (int j = 0; j < Ny; ++j) {
                amountOfIntersections = plane.findIntersections(cam1.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (amountOfIntersections != null)
                    count += amountOfIntersections.size();
            }
        }
        assertEquals("Incorrect amount of intersections", 6, count);
    }

    /**
     * test method for camera and triangle
     * {@link elements.CameraIntegrationTest# constructRayThroughPixel(int, int, int, int, double, double, double), findIntersection(Ray)}.
     */
    @Test
    public void firstTestCaseTriangle() {
        Triangle triangle = new Triangle(new Point3D(0, -1, 2), new Point3D(1, 1, 2), new Point3D(-1, 1, 2));
        List<Point3D> amountOfIntersections;
        int count = 0;
        int Nx = 3;
        int Ny = 3;
        for (int i = 0; i < Nx; ++i) {
            for (int j = 0; j < Ny; ++j) {
                amountOfIntersections = triangle.findIntersections(cam1.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (amountOfIntersections != null)
                    count += amountOfIntersections.size();
            }
        }
        assertEquals("Incorrect amount of intersections", 1, count);
    }

    /**
     * test method for camera and triangle
     * {@link elements.CameraIntegrationTest# constructRayThroughPixel(int, int, int, int, double, double, double), findIntersection(Ray)}.
     */
    @Test
    public void secondTestCaseTriangle() {
        Triangle triangle = new Triangle(new Point3D(0, -20, 2), new Point3D(1, 1, 2), new Point3D(-1, 1, 2));
        List<Point3D> amountOfIntersections;
        int count = 0;
        int Nx = 3;
        int Ny = 3;
        for (int i = 0; i < Nx; ++i) {
            for (int j = 0; j < Ny; ++j) {
                amountOfIntersections = triangle.findIntersections(cam1.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (amountOfIntersections != null)
                    count += amountOfIntersections.size();
            }
        }
        assertEquals("Incorrect amount of intersections", 2, count);
    }
}
