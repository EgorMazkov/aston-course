package ru.astoncourse.tasks;

import static ru.astoncourse.Validator.readNumbersFromConsole;

public class Task_9 {
    public static void isLeapYear() {
        System.out.print("Введите год, котороый хотите проверить: ");
        int year = readNumbersFromConsole();
        System.out.println(year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
        System.out.println();

    }
}
