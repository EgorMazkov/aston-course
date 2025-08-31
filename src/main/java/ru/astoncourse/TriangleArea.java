package ru.astoncourse;

public class TriangleArea {
    public static double triangleArea(double theLengthOfTheBase, double height) {
        if (theLengthOfTheBase <= 0 || height <= 0) {
            throw new IllegalArgumentException("Невалидное значение");
        }
        return (theLengthOfTheBase * height) / 2;
    }
}
