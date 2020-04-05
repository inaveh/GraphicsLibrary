package primitives;

import org.junit.Test;

import static java.lang.System.out;
import static org.junit.Assert.*;
import static primitives.Util.isZero;

/**
 * Unit tests for Vector class
 *
 * @author AhronS and IsraelN
 */
public class VectorTest {

    /**
     * Test method for
     * {@link primitives.Vector#add(primitives.Vector)}.
     */
    @Test
    public void testAdd() {

        // ============ Equivalence Partitions Tests ==============
        // Test that add() return the correct answer
        assertEquals("ERROR: Point + Vector does not work correctly", new Vector(2, 2, 2), new Vector(1, 1, 1).add(new Vector(1, 1, 1)));
    }

    /**
     * Test method for
     * {@link primitives.Vector#subtract(primitives.Vector)}.
     */
    @Test
    public void testSubtract() {
        // ============ Equivalence Partitions Tests ==============
        // Test that sub() return the correct answer
        assertEquals("ERROR: Vector - Vector does not work correctly", new Vector(2, 2, 2), new Vector(3, 4, 5).subtract(new Vector(1, 2, 3)));
    }

    /**
     * Test method for
     * {@link primitives.Vector#scale(double)}.
     */
    @Test
    public void testScale() {
        // ============ Equivalence Partitions Tests ==============
        // Test that dotProduct() return the correct answer
        assertEquals("ERROR: Scalar * Vector does not work correctly", new Vector(5, 5, 5), new Vector(1, 1, 1).scale(5));

        // =============== Boundary Values Tests ==================
        // Test tha vector mul with scalar 0
        try {
            new Vector(2, 2, 2).scale(0);
            fail("ERROR: create zero vector need to throw exception");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test method for
     * {@link primitives.Vector#dotProduct(primitives.Vector)}.
     */
    @Test
    public void testDotProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(-1, -2, -3);
        Vector v3 = new Vector(0, 3, -2);

        // ============ Equivalence Partitions Tests ==============
        // Test that dotProduct() return the correct answer
        assertEquals("dotProduct() wrong value", 14d, v1.dotProduct(v1), 0.00001);

        //Test of vectors with obtuse angle and vectors on same line
        assertEquals("dotProduct() wrong result when work with obtuse angle", -14d, v1.dotProduct(v2), 0.0001);

        // =============== Boundary Values Tests ==================
        // Test of 2 orthogonal vectors
        assertEquals("dotProduct() for orthogonal vectors is not zero", 0d, v1.dotProduct(v3), 0.00001);
    }

    /**
     * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
     */
    @Test
    public void testCrossProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(-2, -4, -6);
        Vector v3 = new Vector(0, 3, -2);
        Vector vr = v1.crossProduct(v3);

        //============ Equivalence Partitions Tests ==============
        //Test that length of cross-product is proper (orthogonal vectors taken for simplicity)
        assertEquals("crossProduct() wrong result length", v1.length() * v3.length(), vr.length(), 0.00001);

        //Test cross-product result orthogonality to its operands
        assertTrue("crossProduct() result is not orthogonal to 1st operand", isZero(vr.dotProduct(v1)));
        assertTrue("crossProduct() result is not orthogonal to 2nd operand", isZero(vr.dotProduct(v3)));

        //=============== Boundary Values Tests ==================
        //test zero vector from cross-product of co-lined vectors
        try {
            v1.crossProduct(v2);
            fail("crossProduct() for parallel vectors does not throw an exception");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    /**
     * Test method for
     * {@link Vector#lengthSquared()}.
     */
    @Test
    public void testLengthSquared() {

        //============ Equivalence Partitions Tests ==============
        // test LengthSquared() return the correct answer
        assertEquals("ERROR: lengthSquared() wrong value", 14d, new Vector(1, 2, 3).lengthSquared(), 0.0001);
    }

    /**
     * Test method for
     * {@link primitives.Vector#length()}.
     */
    @Test
    public void testLength() {
        //============ Equivalence Partitions Tests ==============
        //Test that length() return the correct answer
        assertEquals("length() wrong value", 5d, new Vector(0, 3, 4).length(), 0.00001);
    }

    /**
     * Test method for
     * {@link primitives.Vector#normalize()}.
     */
    @Test
    public void testNormalize() {
        Vector v = new Vector(0, 0, 3);
        Vector vCopy = new Vector(v);
        Vector vCopyNormalize = vCopy.normalize();
        Vector unit = new Vector(0, 0, 1);

        //============ Equivalence Partitions Tests ==============
        //Test that the normalize() func changes the orig vec
        assertEquals("ERROR: normalize() function creates a new vector", vCopyNormalize, vCopy);

        //Test that normalize() really normalized the vector
        if (!isZero(vCopyNormalize.length() - 1) || (!v.normalize().equals(unit)))
            fail("ERROR: normalize() result is not a unit vector");

        //we don't know if we need check here the ability of create vector zero???
        /*=============== Boundary Values Tests ==================
        //Test that normalize a zero vector

        try {
            new Vector(0,0,0).normalize();
            fail("ERROR can't normalize vector 0");
        } catch (IllegalArgumentException e) { //to catch for create zero vector
            assertTrue(true);
        } catch (ArithmeticException e) { //to catch normalize zero vector
            assertTrue(true);
        }

         */
    }

    /**
     * Test method for
     * {@link primitives.Vector#normalized()}.
     */
    @Test
    public void testNormalized() {
        Vector v = new Vector(1, 2, 3);

        //============ Equivalence Partitions Tests ==============
        //Test that the normalized() func not changes the orig vec
        assertNotEquals("ERROR: normalized() function does not create a new vector", new Vector(v.normalized()), v);
    }
}