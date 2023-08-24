package org.example;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExutorsPotoki {




        public static void main(String[] args) {
            long startTime = System.currentTimeMillis();

            int length = 1000;
            Integer[] array = new Integer[length];

            ExecutorService executorService = Executors.newFixedThreadPool(4);

            for (int i = 0; i < length; i++) {
                final int index = i;
                executorService.execute(() -> {
                    if (index % 2 == 0) {
                        for (int y = 0; y < 10000000; y++) {
                            if (y == 980007) {
                                array[index] = y;
                            } else {
                                array[index] = 8;
                            }
                        }
                    } else {
                        for (int y = 0; y < 10000000; y++) {
                            if (y == 980005) {
                                array[index] = y;
                            } else {
                                array[index] = 8;
                            }
                        }
                    }
                });
            }

            executorService.shutdown();

            while (!executorService.isTerminated()) {
                // Ожидание завершения всех задач
            }

            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            System.out.println(executionTime + " миллисекунд");
        }
    }




