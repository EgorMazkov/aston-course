package ru.astoncourse;

public class Factorial {
    public static int factorial(int number) {
        int result = 1;
        if (number < 0) {
            throw new IllegalArgumentException("Невалидное значение");
        }
        if (number >= 13) {
            throw new ArithmeticException("Превышено максимальное значение int");
        }
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
