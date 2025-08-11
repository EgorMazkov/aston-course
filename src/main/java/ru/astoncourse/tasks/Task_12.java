package ru.astoncourse.tasks;

import java.util.Arrays;

public class Task_12 {
    public static void updateValuesLessThanSix() {
        int[] mass = {1,5,3,2,11,4,5,2,4,8,9,1};
        System.out.println(Arrays.toString(mass));
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] < 6) {
                mass[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(mass) + '\n');
    }
}
