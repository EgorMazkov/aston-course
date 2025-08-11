package ru.astoncourse.tasks;

import static ru.astoncourse.Validator.readNumbersFromConsole;

public class Task_5 {
    public static void isSumInRange() {
        int a, b;

        System.out.print("Введите первое число:");
        a = readNumbersFromConsole();
        System.out.print("Введите второе число:");
        b = readNumbersFromConsole();

        System.out.println(a + b >= 10 && a + b <= 20);
        System.out.println();
    }
}
