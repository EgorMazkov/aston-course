package ru.astoncourse;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        printThreeWords(); // Task_1
        checkSumSing(); // Task_2
        printColor(); // Task_3
        compareNumbers(); // Task_4
        isSumInRange(2, 5); // Task_5
        printNumberSign(13); // Task_6
        printBooleanNumberSign(-12); // Task_7
        printStringMultipleTimes("Hello", 10); // Task_8
        isLeapYear(1964); // Task_9
        invertBinaryArray(); // Task_10
        fillArrayWithSequence(); // Task_11
        updateValuesLessThanSix(); // Task_12
        fillMainDiagonalWithOnes(); // Task_13
        createArrayWithValue(10, 1); // Task_14
    }

    private static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    private static void checkSumSing() {
        int a = 1206;
        int b = 123;
        if (a + b >= 0) {
            System.out.println("Сумма положительная\n");
        } else {
            System.out.println("Сумма отрицательная\n");
        }
    }

    private static void printColor() {
        int value = 120;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    private static void compareNumbers() {
        int a = 300;
        int b = 20;
        if (a >= b) {
            System.out.println("a >= b\n");
        } else {
            System.out.println("a < b\n");
        }
    }

    private static boolean isSumInRange(int firstNum, int secondNum) {
        return(firstNum + secondNum >= 10 && firstNum + secondNum <= 20);
    }

    private static void printNumberSign(int num) {
        if (num >= 0) {
            System.out.println("Положительное\n");
        } else {
            System.out.println("Отрицательное\n");
        }
    }

    private static boolean printBooleanNumberSign(int num) {
        return (num < 0);
    }

    private static void printStringMultipleTimes(String line, int quantity) {
        for (int i = 0; i < quantity; i++) {
            System.out.println(line);
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }

    private static void invertBinaryArray() {
        int[] mass = {1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1};
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] == 0) {
                mass[i] = 1;
            } else {
                mass[i] = 0;
            }
        }
    }

    private static void fillArrayWithSequence() {
        int[] mass = new int[100];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = i + 1;
        }
    }

    private static void updateValuesLessThanSix() {
        int[] mass = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] < 6) {
                mass[i] *= 2;
            }
        }
    }

    private static void fillMainDiagonalWithOnes() {
        int n = 5;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i][i] = 1;
            arr[n - i - 1][i] = 1;
        }
    }

    private static int[] createArrayWithValue(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
            System.out.print(array[i] + " ");
        }
        return array;
    }


}
