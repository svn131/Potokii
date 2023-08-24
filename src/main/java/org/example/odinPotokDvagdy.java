package org.example;





import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class odinPotokDvagdy {
        public static void main(String[] args) throws InterruptedException {



            long startTime = System.currentTimeMillis();

            int length = 1000;
            Integer[] array = new Integer[length];

            Thread thread1 = new Thread(() -> {
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

            Thread thread2 = new Thread(() -> {
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

            Thread thread3 = new Thread(() -> {
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

            Thread thread4 = new Thread(() -> {
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

            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();


            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();


            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            System.out.println(executionTime + " миллисекунд");


/////////////////////////////////////////////////////
//
//        long startTime = System.currentTimeMillis();
//
//        int length = 1000;
//        Integer[] array = new Integer[length];
//
//        for (int i = 0; i < length; i++) {
//            if(i % 2 == 0) {
//                for (int y = 0; y < 10000000; y++) {
//                    if (y == 980007) {
//                        array[i] = y;
//                    } else {
//                        array[i] = 8;
//                    }
//                }
//            }
//            else {
//                for (int y = 0 ; y < 10000000 ; y++){
//                    if(y == 980005) {
//                        array[i]= y; }
//                    else {
//                        array[i]= 8;
//                    }
//                }
//
//            }
//        }
//
//        long endTime = System.currentTimeMillis();
//        long executionTime = endTime - startTime;
//
//        System.out.println(executionTime + " милисекунд");


        }
    }


