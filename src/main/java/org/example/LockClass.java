package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockClass {

    private int count = 0;
    private Lock lock = new ReentrantLock();

    Object obj = new Object();

    public void increment() {
synchronized (obj){

}
    }

    public int getCount() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }
}




