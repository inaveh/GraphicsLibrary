package primitives;

import org.junit.Test;

import static java.lang.System.out;
import static org.junit.Assert.*;
import static primitives.Util.isZero;
/**
  * Unit tests for primitives.Vector class
  * @author AhronS and IsraelN
 * */
public class VectorTest {

    @Test
    public void testAdd() {
    }

    @Test
    public void testSubtract() {
    }

    @Test
    public void testScale() {
    }

    @Test
    public void testDotProduct() {
    }


    /**
     * * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
     */
    @Test
    public void testCrossProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(-2, -4, -6);

        //============ Equivalence Partitions Tests ==============
        Vector v3 = new Vector(0, 3, -2);
        Vector vr = v1.crossProduct(v3);

        //Test that length of cross-product is proper (orthogonal vectors taken for simplicity)
        assertEquals("crossProduct() wrong result length", v1.length() * v3.length(), vr.length(), 0.00001);

        //Test cross-product result orthogonality to its operands
        assertTrue("crossProduct() result is not orthogonal to 1st operand", isZero(vr.dotProduct(v1)));
        assertTrue("crossProduct() result is not orthogonal to 2nd operand", isZero(vr.dotProduct(v3)));

        //=============== Boundary Values Tests ==================
        //test zero vector from cross-productof co-lined vectors
        try {
            v1.crossProduct(v2);
            fail("crossProduct() for parallel vectors does not throw an exception");
        } catch (Exception e) {
        }
    }

    @Test
    public void testLengthSquared() {
    }

    @Test
    public void testLength() {
    }

    @Test
    public void testNormalize() {
       // Vector v1 = new Vector(1, 2, 3);
        //Vector v2 = new Vector(-2, -4, -6);
        //Vector v3 = new Vector(0, 3, -2);

        Vector v = new Vector(1, 2, 3);
        Vector vCopy = new Vector(v);
        Vector vCopyNormalize = vCopy.normalize();
        Vector vec = new Vector(0,0,3);
        Vector unit = new Vector(0,0,1);

        //============ Equivalence Partitions Tests ==============
        //Test that the normalize() func changes the orig vec
        if (vCopy != vCopyNormalize)
            fail("ERROR: normalize() function creates a new vector");

        //Test that normalize() really normalized the vector
        if (!isZero(vCopyNormalize.length() - 1) && !(vec.normalize().equals(unit)))
            fail("ERROR: normalize() result is not a unit vector");

        //assertEquals("ERROR: normalize() result is not a unit vector", vec.normalize(),unit);

        //Test that the normalize() func changes the orig vec to the correct

        //=============== Boundary Values Tests ==================

    }




    @Test
    public void testNormalized() {
        //Test that the normalize() func changes the orig vec
//        Vector u = v.normalized();
//        if (u == v)
//            out.println("ERROR: normalizated() function does not create a new vector");

    }
}