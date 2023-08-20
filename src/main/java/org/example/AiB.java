package org.example;

public class AiB {


        public static void main(String[] args) {
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
                    System.out.println("Поток B запущен");
                    lock.notify(); // Возобновление потока A
                }
            });

            threadA.start(); // Запуск потока A
            try {
                Thread.sleep(1000); // Приостановка главного потока на 1 секунду
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadB.start(); // Запуск потока B
        }

    }


