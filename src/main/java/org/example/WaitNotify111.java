package org.example;

public class WaitNotify111 {
    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();



        int length = 1000;
        Integer[] array = new Integer[length];

        Object lock = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("11111111");


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

                lock.notifyAll();
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("2222222222222222222222");



                for (int i = length / 4; i < length / 2; i++) {
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
                lock.notifyAll();
            }
        });

        Thread thread3 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("3333333333333333333333");

                for (int i = length / 2; i < length * 3 / 4; i++) {
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
                lock.notifyAll();
            }
        });

        Thread thread4 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("4444444444");

                for (int i = length * 3 / 4; i < length; i++) {
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

                lock.notifyAll();
            }
        });

        thread1.start();

        synchronized (lock) {
            lock.wait(1000000);
        }


        thread2.start();

        synchronized (lock) {
            lock.wait(1000000);


        thread3.start();



        }

        synchronized (lock) {
            lock.wait(1000000);
        }

        thread4.start();

//        synchronized (lock) {
//            lock.wait();
//        }
        System.out.println("star234");

        synchronized (lock) {
            lock.notifyAll();
        }
        System.out.println("777777777777777777777777777");

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println("88888888888888888888888888");
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println(executionTime + " миллисекунд");
    }
}

