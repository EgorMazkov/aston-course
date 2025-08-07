package ru.astoncourse;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
    public static int readNumbersFromConsole() {
        int num;
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                num = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Ошибка! Введите целое число:");
                sc.next();
            }
        }
        return num;
    }
}
