package org.example;

import java.util.concurrent.Phaser;

public class PhaserExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3); // Создаем Phaser с 3 участниками

        // Создаем и запускаем потоки-участники
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new Participant(phaser));
            thread.start();
        }
    }

    static class Participant implements Runnable {
        private final Phaser phaser;

        public Participant(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            System.out.println("Поток " + Thread.currentThread().getName() + " начал выполнение.");

            // Выполняем некоторую работу

            phaser.arriveAndAwaitAdvance(); // Сообщаем о достижении фазы и ожидаем других участников

            System.out.println("Поток " + Thread.currentThread().getName() + " завершил выполнение.");
        }
    }
}

