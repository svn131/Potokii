package org.example;

public class AiBiC {

        public static void main(String[] args) throws InterruptedException {
            Object lock = new Object();

            // Поток A
            Thread threadA = new Thread(() -> {
                synchronized (lock) {
                    try {
                        System.out.println("Поток A ожидает");
                        lock.wait(); // Приостановка потока A
                        System.out.println("Поток A возобновлен");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            // Поток B
            Thread threadB = new Thread(() -> {
                synchronized (lock) {
                    try {
                        System.out.println("Поток B ожидает");
                        lock.wait(); // Приостановка потока B
                        System.out.println("Поток B возобновлен");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            // Поток C
            Thread threadC = new Thread(() -> {
                synchronized (lock) {
                    System.out.println("Поток C запущен");
                    lock.notifyAll(); // Возобновление всех потоков, ожидающих на объекте lock
                }
            });

            threadA.start(); // Запуск потока A
            threadB.start(); // Запуск потока B
                Thread.sleep(1000); // Приостановка главного потока на 1 секунду

            threadC.start(); // Запуск потока C
        }

    }



