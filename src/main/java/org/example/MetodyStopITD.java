package org.example;

public class MetodyStopITD {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread is running");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });

        thread.start();

        try {
            Thread.sleep(5000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        Thread.interrupted();
    }

//
//    Thread.currentThread() - это статический метод класса Thread в Java, который возвращает объект Thread, представляющий текущий выполняющийся поток.


}
