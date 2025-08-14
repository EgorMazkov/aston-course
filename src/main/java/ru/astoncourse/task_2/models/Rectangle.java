package ru.astoncourse.task_2.models;

import ru.astoncourse.task_2.interfaces.Shape;

public class Rectangle implements Shape {
    private final int lengthRectangle;
    private final int widthRectangle;
    private final String fillColor;
    private final String borderColor;

    public Rectangle(int lengthRectangle, int widthRectangle, String fillColor, String borderColor) {
        this.lengthRectangle = lengthRectangle;
        this.widthRectangle = widthRectangle;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * (lengthRectangle + widthRectangle);
    }

    @Override
    public double getArea() {
        return lengthRectangle * widthRectangle;
    }

    public void info() {
        System.out.println(getPerimeter() + ", " + getArea() + ", " + fillColor + ", " + borderColor);
    }
}
