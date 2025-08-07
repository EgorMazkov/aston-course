package ru.astoncourse.tasks;

import java.util.Arrays;

public class Task_13 {
    public static void fillMainDiagonalWithOnes() {
        int n = 5;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i][i] = 1;
            arr[n-i-1][i] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();

        }
    }
}
