package ru.astoncourse.tasks;

import java.util.Arrays;

public class Task_11 {
    public static void fillArrayWithSequence() {
        int[] mass = new int[100];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = i+1;

        }
        System.out.println(Arrays.toString(mass));
    }
}
