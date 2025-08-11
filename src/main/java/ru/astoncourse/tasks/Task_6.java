package ru.astoncourse.tasks;

import static ru.astoncourse.Validator.readNumbersFromConsole;

public class Task_6 {
    public static void printNumberSign() {
        System.out.print("Введите целое число:");
        int num = readNumbersFromConsole();
        if (num >= 0) {
            System.out.println("Положительное\n");
        } else {
            System.out.println("Отрицательно\n");
        }

    }
}
