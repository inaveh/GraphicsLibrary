package renderer;

import elements.Camera;
import geometries.Intersectable;
import primitives.Point3D;
import primitives.Ray;
import scene.Scene;

import java.util.List;

/**
 * class for create color matrix by scene
 *
 * @author AhronS, IsraelN
 */

public class Render {
    private ImageWriter _imageWriter;
    private Scene _scene;

    public Render(ImageWriter _imageWriter, Scene _scene) {
        this._imageWriter = _imageWriter;
        this._scene = _scene;
    }

    /**
     *
     */
    public void renderImage() {
        Camera camera = _scene.getCamera();
        Intersectable geometries = _scene.getGeometries();
        java.awt.Color background = _scene.getBackground().getColor();

        int nX = _imageWriter.getNx();
        int nY = _imageWriter.getNy();

        double width = _imageWriter.getWidth();
        double height = _imageWriter.getHeight();
        double distance = _scene.getDistance();

        Ray ray;

        for (int row = 0; row < nX; ++row)
            for (int column = 0; column < nY; ++column) {
                ray = camera.constructRayThroughPixel(nX, nY, column, row, distance, width, height);
                List<Point3D> intersectionPoints = geometries.findIntersections(ray);
                if (intersectionPoints == null) {
                    _imageWriter.writePixel(column, row, background);
                } else {
                    Point3D closestPoint = getClosestPoint(intersectionPoints);
                    _imageWriter.writePixel(column, row, calcColor(closestPoint));
                }
            }
    }

    /**
     * @param p
     */
    public void calcColor(Point3D p) {

    }

    /**
     * this func return closest points to the camera (from points list)
     *
     * @param points list of points
     * @return the point
     */
    public Point3D getClosestPoint(List<Point3D> points) {
        if (points == null) {
            throw new IllegalArgumentException("The list of points cannot be empty");
        }

        double minDistance = Double.MAX_VALUE;
        Point3D result = null;
        Point3D P0 = new Point3D(_scene.getCamera().getPlace());

        for (Point3D p : points) {
            double distance = P0.distance(p);

            if (P0.distance(p) < minDistance) {
                result = p;
                minDistance = distance;
            }
        }
        return result;
    }

    public void printGrid(int interval, java.awt.Color color) {

    }

    public void writeToImage() {
        _imageWriter.writeToImage();
    }
}
