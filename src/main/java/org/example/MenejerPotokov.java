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
// @todo ExecutorService executorService = Executors.newFixedThreadPool(4); создает ExecutorService пул потоков, который может одновременно выполнять 4 потока. Метод newFixedThreadPool() из фабрики Executors создает ExecutorService, использующий пул потоков с фиксированным размером.
//
//@todo  executorService.submit(() -> { /* код задачи */ }); отправляет задачу на выполнение в ExecutorService. В данном случае, используется лямбда-выражение для определения задачи, которая будет выполнена в отдельном потоке. Метод submit() возвращает объект Future, который может быть использован для получения результата выполнения задачи или для проверки состояния выполнения.
//
//@todo  executorService.shutdown(); останавливает ExecutorService после завершения всех ранее отправленных задач. Этот вызов гарантирует, что ExecutorService больше не будет принимать новые задачи на выполнение.
//
//@todo  executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS); ожидает завершения всех задач в ExecutorService. Метод awaitTermination() блокирует текущий поток до тех пор, пока все задачи в ExecutorService не завершатся или не истечет указанный временной интервал. В данном случае, используется максимальное значение Long.MAX_VALUE и временная единица TimeUnit.NANOSECONDS, что позволяет ожидать завершения задач практически неограниченное время. Этот вызов гарантирует, что программа не завершится, пока все задачи не будут полностью выполнены.