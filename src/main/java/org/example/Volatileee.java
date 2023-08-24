package org.example;

public class Volatileee {


        static volatile int data = 0;
        static volatile boolean run = true;
        public static void main(String[] args) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println("поток запущен");
                    data = 1;
                    run = false;
                }
            }).start();

            while (run) {/*NOP*/};
            System.out.println(data);
        }
    }

