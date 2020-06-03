package geometries;

import primitives.Ray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * class Geometries all geometries in the collect
 */
public class Geometries implements Intersectable {
    // hold the collect of the geometries
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
        listOfGeometries = new LinkedList<>();
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

    @Override
    public List<GeoPoint> findIntersections(Ray ray) {
        List<GeoPoint> intersections = null;

        for (Intersectable geo : listOfGeometries) {
            List<GeoPoint> tempIntersections = geo.findIntersections(ray);
            if (tempIntersections != null) {
                if (intersections == null)
                    intersections = new LinkedList<>();
                intersections.addAll(tempIntersections);
            }
        }
        return intersections;
    }
}
