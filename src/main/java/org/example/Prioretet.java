package org.example;

public class Prioretet {

//    public static void main(String[] args) {
//        Thread thread1 = new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                System.out.println("Thread 1 executing");
//            }
//        });
//
//        Thread thread2 = new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                System.out.println("Thread 2 executing");
//            }
//        });
//
//        thread1.setPriority(Thread.MIN_PRIORITY); // Установка минимального приоритета
//        thread2.setPriority(Thread.MAX_PRIORITY); // Установка максимального приоритета
//
//        thread1.start();
//        thread2.start();
//    }


    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                System.out.println("Thread 1 executing");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                System.out.println("Thread 2 executing");
            }
        });

        thread1.setPriority(5); // Установка минимального приоритета
//        thread2.setPriority(5); // Установка максимального приоритета

        thread1.start();
        thread2.start();
    }
}

