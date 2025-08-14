package ru.astoncourse.task_2.models;

import ru.astoncourse.task_2.interfaces.Shape;

public class Circle implements Shape {
    private final double radius;
    private final String fillColor;
    private final String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void info() {
        System.out.println(getPerimeter() + ", " + getArea() + ", " + fillColor + ", " + borderColor);
    }
}
