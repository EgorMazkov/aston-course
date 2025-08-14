package ru.astoncourse.task_2;

import ru.astoncourse.task_2.models.Circle;
import ru.astoncourse.task_2.models.Rectangle;
import ru.astoncourse.task_2.models.Triangle;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(10, "Red", "Black");
        circle.info();

        Rectangle rectangle = new Rectangle(10, 20, "Blue", "Red");
        rectangle.info();

        Triangle triangle = new Triangle(10, 20, 15, "Red", "Blue");
        triangle.info();
    }
}
