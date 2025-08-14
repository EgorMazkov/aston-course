package ru.astoncourse.task_2.interfaces;

public interface Shape {
    String getFillColor();
    String getBorderColor();

    default double getArea() {
        throw new UnsupportedOperationException("Расчет периметра не выполнен");
    };
    default double getPerimeter() {
        throw new UnsupportedOperationException("Расчет площади не выполнен");
    };
}
