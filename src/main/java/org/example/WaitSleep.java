package org.example;

public class WaitSleep {



    public static void main(String[] args) throws Exception{


        Integer integer = 5;

        try {
            integer.wait();
        } catch (Exception e) {
            System.out.println("Произошел эксепшен");
        }




        Thread thread1 = new Thread(() -> {



            synchronized (integer) {

//                try {
//                    integer.wait(); // тормозит выполнение этого потока и освобождает монитор
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }




                for (int i = 0; i < 1000_000; i++) {

                }
                System.out.println("Tread1");
            }
        });


        Thread thread2 = new Thread(() -> {

            synchronized (integer) {
                System.out.println("Tread2");



//                integer.notify();
            }
        });


        thread1.start();
        thread2.start();



    }
}
