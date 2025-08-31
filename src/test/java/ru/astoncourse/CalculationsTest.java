package ru.astoncourse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculationsTest {

    @Test
    @DisplayName("testArithmetic")
    void testArithmetic() {
        assertEquals(5, ArithmeticOperations.addition(2, 3));
        assertEquals(-1, ArithmeticOperations.subtraction(2, 3));
        assertEquals(6, ArithmeticOperations.multiplication(2, 3));
        assertEquals(1, ArithmeticOperations.division(2, 2));

         assertThrows(ArithmeticException.class, () -> ArithmeticOperations.addition(Integer.MAX_VALUE, 3));
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.subtraction(Integer.MIN_VALUE, 1));
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.division(11, 0));
    }

    @Test
    @DisplayName("TestFactorial")
    void testFactorial() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1));
        assertEquals(1, Factorial.factorial(0));
        assertEquals(3628800, Factorial.factorial(10));
        assertThrows(ArithmeticException.class, () -> Factorial.factorial(13));
    }

    @Test
    @DisplayName("testTriangleArea")
    void testTriangleArea() {
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.triangleArea(0, 1));
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.triangleArea(21, 0));
        assertEquals(0.5, TriangleArea.triangleArea(1, 1));
    }

    @Test
    @DisplayName("testCompare")
    void testCompare() {
        assertEquals(true, Compare.compare(1, 1));
        assertEquals(false, Compare.compare(1, -2));
    }
}
