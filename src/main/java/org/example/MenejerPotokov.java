package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MenejerPotokov {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        int length = 1000;
        Integer[] array = new Integer[length];

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(() -> {
            for (int i = 0; i < length / 4; i++) {
                if(i % 2 == 0) {
                    for (int y = 0; y < 10000000; y++) {
                        if (y == 980007) {
                            array[i] = y;
                        } else {
                            array[i] = 8;
                        }
                    }
                }
                else {
                    for (int y = 0 ; y < 10000000 ; y++){
                        if(y == 980005) {
                            array[i]= y; }
                        else {
                            array[i]= 8;
                        }
                    }
                }
            }
        });

        executorService.submit(() -> {
            for (int i = length / 4; i < length / 2; i++) {
                if(i % 2 == 0) {
                    for (int y = 0; y < 10000000; y++) {
                        if (y == 980007) {
                            array[i] = y;
                        } else {
                            array[i] = 8;
                        }
                    }
                }
                else {
                    for (int y = 0 ; y < 10000000 ; y++){
                        if(y == 980005) {
                            array[i]= y; }
                        else {
                            array[i]= 8;
                        }
                    }
                }
            }
        });

        executorService.submit(() -> {
            for (int i = length / 2; i < length * 3 / 4; i++) {
                if(i % 2 == 0) {
                    for (int y = 0; y < 10000000; y++) {
                        if (y == 980007) {
                            array[i] = y;
                        } else {
                            array[i] = 8;
                        }
                    }
                }
                else {
                    for (int y = 0 ; y < 10000000 ; y++){
                        if(y == 980005) {
                            array[i]= y; }
                        else {
                            array[i]= 8;
                        }
                    }
                }
            }
        });

        executorService.submit(() -> {
            for (int i = length * 3 / 4; i < length; i++) {
                if(i % 2 == 0) {
                    for (int y = 0; y < 10000000; y++) {
                        if (y == 980007) {
                            array[i] = y;
                        } else {
                            array[i] = 8;
                        }
                    }
                }
                else {
                    for (int y = 0 ; y < 10000000 ; y++){
                        if(y == 980005) {
                            array[i]= y; }
                        else {
                            array[i]= 8;
                        }
                    }
                }
            }
        });

        executorService.shutdown();

            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);


        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println(executionTime + " миллисекунд");
    }
}
//    В этом примере мы используем ExecutorService и его метод submit() для отправки задач на выполнение в пуле потоков. Метод awaitTermination() ждет завершения всех задач в пуле потоков. Затем мы рассчитываем время выполнения и выводим его на консоль. Обратите внимание, что вам не нужно явно вызывать метод start() и join() для потоков - это управляется ExecutorService.