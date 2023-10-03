package org.example;
import java.util.concurrent.Semaphore;


public class SimoforsPonyatnoe {



        public static void main(String[] args) {
            Semaphore mySemaphore = new Semaphore(1); // Создаем семафор с 2 разрешениями

            // Поток A
            Thread threadA = new Thread(() -> {
                try {
                    mySemaphore.acquire(); // Запрашиваем разрешение у семафора эскваер
                    System.out.println("Поток A получил разрешение");
                    Thread.sleep(2000); // Выполняем некоторую работу (2 секунды)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mySemaphore.release(); // Освобождаем разрешение
                    System.out.println("Поток A освободил разрешение");
                }
            });

            // Поток B
            Thread threadB = new Thread(() -> {
                try {
                    mySemaphore.acquire(); // Запрашиваем разрешение у семафора
                    System.out.println("Поток B получил разрешение");
                    Thread.sleep(3000); // Выполняем некоторую работу (3 секунды)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mySemaphore.release(); // Освобождаем разрешение
                    System.out.println("Поток B освободил разрешение");
                }
            });

            // Поток C
            Thread threadC = new Thread(() -> {
                try {
                    mySemaphore.acquire(); // Запрашиваем разрешение у семафора
                    System.out.println("Поток C получил разрешение");
                    Thread.sleep(1000); // Выполняем некоторую работу (1 секунда)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mySemaphore.release(); // Освобождаем разрешение
                    System.out.println("Поток C освободил разрешение");
                }
            });

            threadA.start(); // Запуск потока A
            threadB.start(); // Запуск потока B
            threadC.start(); // Запуск потока C
        }

    }



