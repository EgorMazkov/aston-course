package ru.astoncourse.tasks;

import static ru.astoncourse.Validator.readNumbersFromConsole;

public class Task_7 {
    public static void printBooleanNumberSign() {
        System.out.print("Введите целое число:");
        int num = readNumbersFromConsole();
        System.out.println(num >= 0);
        System.out.println();
    }
}
