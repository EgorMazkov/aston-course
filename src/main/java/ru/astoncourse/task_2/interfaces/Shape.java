package ru.astoncourse.task_2.interfaces;

public interface Shape {
    double getArea();
    default double getPerimeter() {
        throw new UnsupportedOperationException("Расчет площади не выполнен");
    };
}
