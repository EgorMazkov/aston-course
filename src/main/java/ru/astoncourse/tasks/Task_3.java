package ru.astoncourse.tasks;

public class Task_3 {
    public static void printColor() {
        int value = 120;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
}
