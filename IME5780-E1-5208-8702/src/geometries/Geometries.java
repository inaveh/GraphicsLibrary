package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Geometries implements Intersectable {
    private List<Intersectable> list;

    public Geometries() {
        this.list = new LinkedList<Intersectable>();
    }

    ;

    public Geometries(Intersectable... geometries) {
        this.list = new LinkedList<Intersectable>();
        for (int i = 0; i < geometries.length; i++)
            this.list.add(geometries[i]);
    }

    ;

    public void add(Intersectable... geometries) {
        for (int i = 0; i < geometries.length; i++)
            this.list.add(geometries[i]);
    }


    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> intersections = null;

        for (Intersectable geo : list) {
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
