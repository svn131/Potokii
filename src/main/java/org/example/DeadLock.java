package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock{
    private static final Lock lockA = new ReentrantLock();
    private static final Lock lockB = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            lockA.lock();
            System.out.println("Thread 1 acquired lock A");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lockB.lock();
            System.out.println("Thread 1 acquired lock B");
            lockB.unlock();
            lockA.unlock();
        });

        Thread thread2 = new Thread(() -> {
            lockA.lock();
            System.out.println("Thread 2 acquired lock A");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lockB.lock();
            System.out.println("Thread 2 acquired lock B");
            lockB.unlock();
            lockA.unlock();
        });

        thread1.start();
        thread2.start();
    }
}


