package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static primitives.Util.isZero;

public class Camera {
    private Point3D place;
    private Vector vto;
    private Vector vup;
    private Vector vright;

    // ****************************** Getters *****************************/

    /**
     * Camera getter
     *
     * @return place
     */
    public Point3D getPlace() {
        return place;
    }

    /**
     * Camera getter
     *
     * @return vto
     */
    public Vector getVto() {
        return vto;
    }

    /**
     * Camera getter
     *
     * @return vup
     */
    public Vector getVup() {
        return vup;
    }

    /**
     * Camera getter
     *
     * @return vright
     */
    public Vector getVright() {
        return vright;
    }


    // ****************************** Constructors *****************************/

    public Camera(Point3D _place, Vector _vto, Vector _vup) {
        if (isZero(_vto.dotProduct(_vup))) {
            vright = new Vector(_vto.crossProduct(_vup)).normalized();
            vto = _vto.normalized();
            vup = _vup.normalized();
        } else
            throw new IllegalArgumentException("Illegal args");
    }

    public Ray constructRayThroughPixel(int nX, int nY, int j, int i,
                                        double screenDistance, double screenWidth, double screenHeight) {
        if (isZero(screenDistance)) {
            throw new IllegalArgumentException("distance cannot be 0");
        }

        Point3D Pc = place.add(vto.scale(screenDistance));

        double Ry = screenHeight / nY;
        double Rx = screenWidth / nX;

        double yi = ((i - nY / 2d) * Ry + Ry / 2d);
        double xj = ((j - nX / 2d) * Rx + Rx / 2d);

        Point3D Pij = Pc;

        if (!isZero(xj)) {
            Pij = Pij.add(vright.scale(xj));
        }
        if (!isZero(yi)) {
            //Pij = Pij.subtract(vup.scale(yi));
            Pij.add(vup.scale(-yi));
        }

        Vector Vij = Pij.subtract(place);

        return new Ray(place, Vij);

    }
}