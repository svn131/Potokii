package org.example;

public class GlavnuyiProstoy {
    public static void main(String[] args) {
        // Создаем новый поток
        Thread thread = new MyThread();

        // Запускаем поток
        thread.start();

        // Выполняем действия в главном потоке
        for (int i = 0; i < 5; i++) {
            System.out.println("Главный поток: " + i);

            try {
                // Задержка выполнения главного потока на 1 секунду
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Класс, расширяющий класс Thread
    static class MyThread extends Thread {
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Дополнительный поток: " + i);

                try {
                    // Задержка выполнения дополнительного потока на 1 секунду
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}