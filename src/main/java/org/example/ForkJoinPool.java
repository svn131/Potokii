package org.example;

import java.util.concurrent.RecursiveAction;


public class ForkJoinPool {


        public static void main(String[] args) {
            long startTime = System.currentTimeMillis();

            int length = 1000;
            Integer[] array = new Integer[length];

            java.util.concurrent.ForkJoinPool forkJoinPool = new java.util.concurrent.ForkJoinPool();
            forkJoinPool.invoke(new ArrayUpdateTask(array, 0, length));

            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            System.out.println(executionTime + " миллисекунд");
        }

        static class ArrayUpdateTask extends RecursiveAction {
            private final Integer[] array;
            private final int start;
            private final int end;

            ArrayUpdateTask(Integer[] array, int start, int end) {
                this.array = array;
                this.start = start;
                this.end = end;
            }

            @Override
            protected void compute() {
                if (end - start <= 1) {
                    for (int i = start; i < end; i++) {
                        if (i % 2 == 0) {
                            for (int y = 0; y < 10000000; y++) {
                                if (y == 980007) {
                                    array[i] = y;
                                } else {
                                    array[i] = 8;
                                }
                            }
                        } else {
                            for (int y = 0; y < 10000000; y++) {
                                if (y == 980005) {
                                    array[i] = y;
                                } else {
                                    array[i] = 8;
                                }
                            }
                        }
                    }
                } else {
                    int mid = (start + end) / 2;
                    ArrayUpdateTask leftTask = new ArrayUpdateTask(array, start, mid);
                    ArrayUpdateTask rightTask = new ArrayUpdateTask(array, mid, end);
                    invokeAll(leftTask, rightTask);
                }
            }
        }
    }
