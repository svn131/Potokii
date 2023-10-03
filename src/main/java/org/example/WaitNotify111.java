package org.example;

public class WaitNotify111 {
    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();



        int length = 1000;
        Integer[] array = new Integer[length];

        Object cat = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (cat) {
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

                cat.notifyAll();

                try {
                    cat.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("PPPPPPPPPPPPPPPPPPPPPPP");

            }

        });

        Thread thread2 = new Thread(() -> {
            synchronized (cat) {
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
                cat.notifyAll();
            }
        });

        Thread thread3 = new Thread(() -> {
            synchronized (cat) {
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
                cat.notifyAll();
            }
        });

        Thread thread4 = new Thread(() -> {
            synchronized (cat) {
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

                cat.notifyAll();
            }
        });

        thread1.start();

        synchronized (cat) {
            cat.wait(1000000);
        }


        thread2.start();

        synchronized (cat) {
            cat.wait(1000000);


        thread3.start();



        }

        synchronized (cat) {
            cat.wait(1000000);
        }

        thread4.start();

//        synchronized (lock) {
//            lock.wait();
//        }
        System.out.println("star234");

        synchronized (cat) {
            cat.notifyAll();
        }
        System.out.println("777777777777777777777777777");

        thread1.join();
        System.out.println("Первый поток закончился");
        thread2.join();
        System.out.println("Второй поток закончился");
        thread3.join();
        System.out.println("Трей поток закончился");
        thread4.join();
        System.out.println("четвертый поток закончился");

        System.out.println("88888888888888888888888888");
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println(executionTime + " миллисекунд");
    }

}




//В данном примере потоки выполняються поочередно