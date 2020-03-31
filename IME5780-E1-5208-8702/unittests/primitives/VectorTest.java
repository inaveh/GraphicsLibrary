package primitives;

import org.junit.Test;

import static java.lang.System.out;
import static org.junit.Assert.*;
import static primitives.Util.isZero;

/**
 * Unit tests for primitives.Vector class
 *
 * @author AhronS and IsraelN
 */
public class VectorTest {

    /**
     * Test method for {@link primitives.Vector#add(primitives.Vector)}.
     */
    @Test
    public void testAdd() {
        // ============ Equivalence Partitions Tests ==============
        // Test that add() return the correct answer
        assertEquals("ERROR: Point + Vector does not work correctly", new Vector(2,2,2), new Vector(1,1,1).add(new Vector(1,1,1)));
        // =============== Boundary Values Tests ==================
        // Test that try to add vector to his negative and create vector zero
        try {
          new Vector(1, 2, 3).add(new Vector(-1, -2, -3));
            fail("Add v plus -v must throw exception");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test method for {@link primitives.Vector#subtract(primitives.Vector)}.
     */
    @Test
    public void testSubtract() {
        // ============ Equivalence Partitions Tests ==============
        // Test that sub() return the correct answer
        assertEquals("ERROR: Vector - Vector does not work correctly", new Vector(2,2,2), new Vector(3,4,5).subtract(new Vector(1,2,3)));
        // =============== Boundary Values Tests ==================
        // Test that try to sub vector from himself and create vector zero
        try {
            new Vector(1, 2, 3).subtract(new Vector(1, 2, 3));
            fail("Sub v from v must throw exception");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }


    /**
     *  Test method for {@link primitives.Vector#scale(double)}.
     */
    @Test
    public void testScale() {
        // ============ Equivalence Partitions Tests ==============
        // Test that dotProduct() return the correct answer

        // =============== Boundary Values Tests ==================
        // Test

    }

    /**
     * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
     */
    @Test
    public void testDotProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(3, 2, 1);
        // ============ Equivalence Partitions Tests ==============
        // Test that dotProduct() return the correct answer
        assertEquals("dotProduct() wrong value", 10d, v1.dotProduct(v2), 0.00001);

        // =============== Boundary Values Tests ==================
        // Test
        Vector v3 = new Vector(0, 3, -2);
        assertEquals("dotProduct() for orthogonal vectors is not zero", 0d, v1.dotProduct(v3), 0.00001);

    }


    /**
     * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
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

    /**
     * Test method for {@link primitives.Vector#lengthSquared()}.
     */
    @Test
    public void testLengthSquared() {
        Vector v1 = new Vector(1, 2, 3);
        //============ Equivalence Partitions Tests ==============
        // test LengthSquared() return the correct answer
        assertEquals("ERROR: lengthSquared() wrong value", 14d, new Vector(1, 2, 3).lengthSquared(), 0.0001);

        //=============== Boundary Values Tests ==================
        //Test that lengthSquared a zero vector
        try {
            Vector vec = new Vector(0.0, 0.0, 0.0);
            vec.lengthSquared();
            fail("ERROR can't calculate length sqr of vector 0");
        } catch (IllegalArgumentException e) { //to catch for create zero vector
            assertTrue(true);
        } catch (ArithmeticException e) { //to catch normalize zero vector
            assertTrue(true);
        }
    }

    /**
     * Test method for {@link primitives.Vector#length()}.
     */
    @Test
    public void testLength() {
        Vector v1 = new Vector(1, 2, 3);
        //============ Equivalence Partitions Tests ==============
        //Test that length() return the correct answer
        assertEquals("length() wrong value", 5d, new Vector(0, 3, 4).length(), 0.00001);

        //        if (!isZero(new Vector(0, 3, 4).length() - 5))
        //            out.println("ERROR: length() wrong value");
        //=============== Boundary Values Tests ==================

    }

    /**
     * Test method for {@link primitives.Vector#normalize()}.
     */
    @Test
    public void testNormalize() {
        Vector v = new Vector(0, 0, 3);
        Vector vCopy = new Vector(v);
        Vector vCopyNormalize = vCopy.normalize();
        Vector unit = new Vector(0, 0, 1);

        //============ Equivalence Partitions Tests ==============
        //Test that the normalize() func changes the orig vec
        if (vCopy != vCopyNormalize)
            fail("ERROR: normalize() function creates a new vector");

        //Test that normalize() really normalized the vector
        if (!isZero(vCopyNormalize.length() - 1) || (!v.normalize().equals(unit)))
            fail("ERROR: normalize() result is not a unit vector");

        //=============== Boundary Values Tests ==================
        //Test that normalize a zero vector
        try {
            Vector vec = new Vector(0.0, 0.0, 0.0);
            vec.normalize();
            fail("ERROR can't normalize vector 0");
        } catch (IllegalArgumentException e) { //to catch for create zero vector
            assertTrue(true);
        } catch (ArithmeticException e) { //to catch normalize zero vector
            assertTrue(true);
        }
    }

    /**
     * Test method for {@link primitives.Vector#normalized()}.
     */
    @Test
    public void testNormalized() {
        Vector v = new Vector(1, 2, 3);

        //============ Equivalence Partitions Tests ==============

        //Test that the normalized() func not changes the orig vec
        Vector u = v.normalized();
        if (u == v)
            fail("ERROR: normalized() function does not create a new vector");

        //=============== Boundary Values Tests ==================
        //Test that normalized a zero vector
        try {
            Vector vec = new Vector(0.0, 0.0, 0.0);
            vec.normalized();
            fail("ERROR can't normalize vector 0");
        } catch (IllegalArgumentException e) { //to catch for create zero vector
            assertTrue(true);
        } catch (ArithmeticException e) { //to catch normalize zero vector
            assertTrue(true);
        }
    }
}