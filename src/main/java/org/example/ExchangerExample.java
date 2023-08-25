package org.example;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String message = "Hello from Thread 1";
                    System.out.println("Thread 1 sends: " + message);
                    String receivedMessage = exchanger.exchange(message); // @ todo В классе Exchanger каждый поток блокируется при вызове метода exchange(), пока другой поток не вызовет этот же метод. Когда оба потока вызывают exchange(), они обмениваются своими сообщениями.
                    System.out.println("Thread 1 received: " + receivedMessage);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String message = "Hello from Thread 2";
                    System.out.println("Thread 2 sends: " + message);
                    String receivedMessage = exchanger.exchange(message);
                    System.out.println("Thread 2 received: " + receivedMessage);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

