package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Geometries implements Intersectable {
    private List<Intersectable> listOfGeometries;


    // ****************************** Constructors *****************************/

    /**
     * Geometries def constructor
     */
    public Geometries() {
        this.listOfGeometries = new LinkedList<>();
    }

    /**
     * Geometries constructor
     *
     * @param _geometries .
     */
    public Geometries(Intersectable... _geometries) {
        add(_geometries);
    }

    /**
     * add geometry to list
     *
     * @param _geometries .
     */
    public void add(Intersectable... _geometries) {
        this.listOfGeometries.addAll(Arrays.asList(_geometries));
    }

    /**
     * Test method for
     * {@link geometries.Geometries #findIntersections(Ray)}.
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> intersections = null;

        for (Intersectable geo : listOfGeometries) {
            List<Point3D> tempIntersections = geo.findIntersections(ray);
            if (tempIntersections != null) {
                if (intersections == null)
                    intersections = new ArrayList<>();
                intersections.addAll(tempIntersections);
            }
        }
        return intersections;
    }
}
