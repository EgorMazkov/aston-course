package ru.astoncourse.task_2.models;

import ru.astoncourse.task_2.interfaces.Shape;

public class Triangle implements Shape {
    private int sideA;
    private int sideB;
    private int sideC;
    private final String fillColor;
    private final String borderColor;

    public Triangle(int sideA, int sideB, int sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        // Формула Герона
        // s - semiPerimeter
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    public void info() {
        System.out.println(getPerimeter() + ", " + getArea() + ", " + getBorderColor() + ", " + getFillColor());
    }
}
