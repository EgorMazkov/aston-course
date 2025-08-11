package ru.astoncourse.tasks;

import java.util.Arrays;

public class Task_10 {
    public static void invertBinaryArray() {
        int [] mass = {1,0,1,0,1,1,1,1,1,0,0,1,0,1,0,1,0,1,1};
        System.out.println(Arrays.toString(mass));
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] == 0) {
                mass[i] = 1;
            } else {
                mass[i] = 0;
            }
        }
        System.out.println(Arrays.toString(mass) + '\n');
    }
}
