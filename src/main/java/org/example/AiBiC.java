package org.example;

public class AiBiC {

        public static void main(String[] args) throws InterruptedException {
            Object lock = new Object();
            Object lock1 = new Object();
            Integer u = Integer.valueOf(500);
            Integer ee = Integer.valueOf(500);

//            ee.wait();

            // Поток A
            Thread threadA = new Thread(() -> {
                synchronized (u) {
                    try {
                        System.out.println("Поток A ожидает");
                        u.wait(); // Приостановка потока A
                        System.out.println("Поток A возобновлен");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            // Поток B
            Thread threadB = new Thread(() -> {
                synchronized (u) {
                    try {
                        System.out.println("Поток B ожидает");
                        u.wait(); // Приостановка потока B
                        System.out.println("Поток B возобновлен");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            // Поток C
            Thread threadC = new Thread(() -> {
                synchronized (u) {
                    System.out.println("Поток C запущен");
//                    lock.notifyAll(); // Возобновление всех потоков, ожидающих на объекте lock
                    u.notifyAll();
                }
            });

            threadA.start(); // Запуск потока A
            threadB.start(); // Запуск потока B
                Thread.sleep(1000); // Приостановка главного потока на 1 секунду

            threadC.start(); // Запуск потока C
        }

    }



