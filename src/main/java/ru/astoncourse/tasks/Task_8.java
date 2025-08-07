package ru.astoncourse.tasks;

import static ru.astoncourse.Validator.readNumbersFromConsole;
import java.util.Scanner;

public class Task_8 {
    public static void printStringMultipleTimes() {
        String line;
        int counter = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите строку: ");
        line = sc.nextLine();
        System.out.print("Введите число: ");
        counter = readNumbersFromConsole();
        for (int i = 0; i < counter; i++) {
            System.out.println(line);
        }
    }
}
