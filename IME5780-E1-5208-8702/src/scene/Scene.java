package scene;

import elements.AmbientLight;
import elements.Camera;
import geometries.Geometries;
import geometries.Intersectable;
import primitives.Color;

/**
 * class for scene for build scene
 *
 * @author AhronS, IsraelN
 */
public class Scene {
    private String _name;
    private Color _background;
    private AmbientLight _ambientLight;
    private Geometries _geometries;
    private Camera _camera;
    private double _distance;

    // ****************************** Constructors *****************************/
    public Scene(String name) {
        _name = name;
        _geometries = new Geometries();
    }

    // ****************************** Getters *****************************/

    /**
     * Scene getter
     *
     * @return _name value
     */
    public String getName() {
        return _name;
    }

    /**
     * Scene getter
     *
     * @return _background value
     */
    public Color getBackground() {
        return _background;
    }

    /**
     * Scene getter
     *
     * @return _ambientLight value
     */
    public AmbientLight getAmbientLight() {
        return _ambientLight;
    }

    /**
     * Scene getter
     *
     * @return _geometries value
     */
    public Geometries getGeometries() {
        return _geometries;
    }

    /**
     * Scene getter
     *
     * @return _camera value
     */
    public Camera getCamera() {
        return _camera;
    }

    /**
     * Scene getter
     *
     * @return _distance value
     */
    public double getDistance() {
        return _distance;
    }

    // ****************************** Setters *****************************/

    /**
     * Scene setter for background
     */
    public void setBackground(Color _background) {
        this._background = _background;
    }

    /**
     * Scene setter for ambientLight
     */
    public void setAmbientLight(AmbientLight _ambientLight) {
        this._ambientLight = _ambientLight;
    }

    /**
     * Scene setter for camera
     */
    public void setCamera(Camera _camera) {
        this._camera = _camera;
    }

    /**
     * Scene setter for distance
     */
    public void setDistance(double _distance) {
        this._distance = _distance;
    }

    /**
     * add func for new geometries
     *
     * @param geometries geo
     */
     public void addGeometries(Intersectable... geometries) {
        _geometries.add(geometries);
    }
}
