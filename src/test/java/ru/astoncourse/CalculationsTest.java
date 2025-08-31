package ru.astoncourse;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculationsTest {

    @Test
    void testArithmetic() {
        Assert.assertEquals(5, ArithmeticOperations.addition(2, 3));
        Assert.assertEquals(-1, ArithmeticOperations.subtraction(2, 3));
        Assert.assertEquals(6, ArithmeticOperations.multiplication(2, 3));
        Assert.assertEquals(1, ArithmeticOperations.division(2, 2));

        try {
            ArithmeticOperations.addition(Integer.MAX_VALUE, 3);
            Assert.fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
        }

        try {
            ArithmeticOperations.subtraction(Integer.MIN_VALUE, 1);
            Assert.fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
        }

        try {
            ArithmeticOperations.division(11, 0);
            Assert.fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
        }
    }

    @Test
    void testFactorial() {
        Assert.assertEquals(1, Factorial.factorial(0));
        Assert.assertEquals(3628800, Factorial.factorial(10));

        try {
            Factorial.factorial(-1);
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }

        try {
            Factorial.factorial(13);
            Assert.fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
        }

    }

    @Test
    void testTriangleArea() {
        Assert.assertEquals(0.5, TriangleArea.triangleArea(1, 1));
        try {
            TriangleArea.triangleArea(0, 1);
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }

        try {
            TriangleArea.triangleArea(21, 0);
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void testCompare() {
        Assert.assertEquals(true, Compare.compare(1, 1));
        Assert.assertEquals(false, Compare.compare(1, -2));
    }
}
