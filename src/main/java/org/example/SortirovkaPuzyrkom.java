package org.example;

import java.util.Arrays;

public class SortirovkaPuzyrkom {

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Меняем местами элементы
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 12, 1, 6};
        System.out.println("Исходный массив: " + Arrays.toString(array));

        bubbleSort(array);

        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }
}

