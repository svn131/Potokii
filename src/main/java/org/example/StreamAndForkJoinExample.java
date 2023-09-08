package org.example;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class StreamAndForkJoinExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Создание ForkJoinPool с использованием common pool
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        // Параллельное вычисление с использованием Stream API и ForkJoinPool
        int sum = forkJoinPool.submit(() ->
                Arrays.stream(numbers)
                        .parallel()
                        .map(StreamAndForkJoinExample::processNumber)
                        .sum()
        ).join();

        System.out.println("Sum: " + sum);
    }

    private static int processNumber(int number) {
        // Пример обработки числа
        return number * 2;
    }
}

