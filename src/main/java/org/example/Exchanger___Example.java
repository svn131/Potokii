package org.example;

import java.util.concurrent.Exchanger;

public class Exchanger___Example {


    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread threadA = new Thread(() -> {
            try {
                String dataA = "Data from Thread A";
                System.out.println("Thread A is sending: " + dataA);
                String receivedData = exchanger.exchange(dataA);
                System.out.println("Thread A received: " + receivedData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                String dataB = "Data from Thread B";
                System.out.println("Thread B is sending: " + dataB);
                String receivedData = exchanger.exchange(dataB);
                System.out.println("Thread B received: " + receivedData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
    }
}


