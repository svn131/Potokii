package org.example;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int troechka = 3;
        CountDownLatch latch = new CountDownLatch(troechka);

        // Создаем и запускаем потоки-участники
        for (int i = 0; i < troechka; i++) {
            Thread thread = new Thread(new Participant(latch));
            thread.start();
        }

        // Ожидаем, пока счетчик не станет равным нулю
        latch.await();

        System.out.println("Все потоки завершили выполнение");
    }

    static class Participant implements Runnable {
        private final CountDownLatch latch;

        public Participant(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("Поток " + Thread.currentThread().getName() + " начал выполнение.");

            // Выполняем некоторую работу

            latch.countDown(); // Уменьшаем счетчик на 1

            System.out.println("Поток " + Thread.currentThread().getName() + " завершил выполнение.");
        }
    }
}
