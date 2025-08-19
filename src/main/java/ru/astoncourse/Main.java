package ru.astoncourse;

import ru.astoncourse.exceptions.MyArrayDataException;
import ru.astoncourse.exceptions.MyArraySizeException;

public class Main {
    public static void main(String[] args) {

        String[][] array = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "F", "16"}
        };

        validatorArraySize(array);
        generateAndCatchArrayIndexOutOfBounds();
    }

    private static void generateAndCatchArrayIndexOutOfBounds() {
        int[] array = new int[4];
        try {
            array[5] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private static void validatorArraySize(String[][] array) {
        int sumArray = 0;
        for (int i = 0, j = 0; i < array.length; i++) {
                if (array[i].length != 4) {
                    throw new MyArraySizeException("Ошибка: Неверный размер массива");
                }
                for (j = 0; j < array[i].length; j++) {
                    try {
                        sumArray += getParseInt(i, j, array);
                    } catch (MyArrayDataException e) {
                        e.printStackTrace();
                    }
                }
                if (i == 4 && j == 4) {
                    System.out.println("Сумма элементов: " + sumArray);
                }
        }
    }

    private static int getParseInt(int i, int j, String[][] array) throws MyArrayDataException {
        try {
            return Integer.parseInt(array[i][j]);
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("Ошибка: Обнаружен спец. символ или буква [ " + i + " ][ " + j + " ]");
        }
    }
}