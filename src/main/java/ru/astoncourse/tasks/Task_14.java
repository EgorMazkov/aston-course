package ru.astoncourse.tasks;

import static ru.astoncourse.Validator.readNumbersFromConsole;

public class Task_14 {

    public static void createArrayWithValue() {
        System.out.print("Введите длину массива: ");
        int len = readNumbersFromConsole();
        System.out.print("Введите значение: ");
        int initialValue = readNumbersFromConsole();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}