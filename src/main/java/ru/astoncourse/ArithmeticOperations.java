package ru.astoncourse;

public class ArithmeticOperations {
    public static int addition(int a, int b) {
        return Math.addExact(a, b);
    }


    public static int subtraction(int a, int b) {
        return Math.subtractExact(a, b);
    }

    public static int multiplication(int a, int b) {
        return Math.multiplyExact(a, b);
    }

    public static int division(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Нельзя делить на 0");
        }
        return a / b;
    }
}
