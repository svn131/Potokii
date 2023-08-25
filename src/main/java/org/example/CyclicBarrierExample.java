package org.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        final int numberOfThreads = 3;
        final CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, new BarrierAction());

        Thread thread1 = new Thread(new Worker(barrier, "Поток 1"));
        Thread thread2 = new Thread(new Worker(barrier, "Поток 2"));

        thread1.start();
        thread2.start();

        // Основной поток программы
        System.out.println("Основной поток выполняет действие");
        barrier.await(); // Основной поток ожидает достижения барьера
        System.out.println("Основной поток прошел через барьер");

        thread1.join();
        thread2.join();
    }

    static class BarrierAction implements Runnable {
        @Override
        public void run() {
            System.out.println("Все потоки достигли барьера");
        }
    }

    static class Worker implements Runnable {
        private final CyclicBarrier barrier;
        private final String name;

        public Worker(CyclicBarrier barrier, String name) {
            this.barrier = barrier;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " выполняет действие");
            try {
                barrier.await(); // Поток ожидает достижения барьера
                System.out.println(name + " прошел через барьер");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
