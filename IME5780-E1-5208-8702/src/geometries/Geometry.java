package geometries;

import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;

/**
 * interface for geometric objects
 */
public abstract class Geometry implements Intersectable {
    protected Color _emission;
    protected Material _material;

    //****************************** Constructors *****************************/

    /**
     * default constructor for Geometry
     */
    public Geometry() {
        this._emission = Color.BLACK;
        _material=new Material(0,0,0);
    }

    /**
     * constructor for Geometry
     *
     * @param _emission emission
     */
    public Geometry(Color _emission) {
        this._emission = _emission;
        _material=new Material(0,0,0);
    }

    /**
     * constructor for Geometry with color and material
     *
     * @param _emission emission
     * @param _material material
     */
    public Geometry(Color _emission, Material _material) {
        this(_emission);
        this._material = _material;
    }

    // ****************************** Getters *****************************//

    /**
     * _emission getter
     *
     * @return emission
     */
    public Color getEmission() {
        return _emission;
    }

    /**
     * Geometry getter
     *
     * @return material
     */
    public Material getMaterial() {
        return _material;
    }

    /**
     * this func receiving a point and providing a normal
     *
     * @param point3D the point
     */
    public abstract Vector getNormal(Point3D point3D);
}
