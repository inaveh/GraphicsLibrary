package primitives;

/**
 * class Material for material of geometries
 */
public class Material {
    private final double _kD;
    private final double _kS;
    private final int _nShininess;

    // ****************************** Constructors *****************************//

    /**
     * Material constructor
     *
     * @param _kD         kd
     * @param _kS         ks
     * @param _nShininess shininess
     */
    public Material(double _kD, double _kS, int _nShininess) {
        this._kD = _kD;
        this._kS = _kS;
        this._nShininess = _nShininess;
    }

    // ****************************** Getters *****************************//

    /**
     * material getter
     *
     * @return kD
     */
    public double getKD() {
        return _kD;
    }

    /**
     * material getter
     *
     * @return kS
     */
    public double getKS() {
        return _kS;
    }

    /**
     * material getter
     *
     * @return nShininess
     */
    public int getNShininess() {
        return _nShininess;
    }
}
