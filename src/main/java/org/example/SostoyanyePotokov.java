package org.example;
//
//public class SostoyanyePotokov {
//
//
//
//        public static void main(String[] args) throws InterruptedException {
//            Thread thread = new Thread(() -> {
//                System.out.println("Поток запущен");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//            });
//
//            System.out.println("Состояние потока до его запуска: " + thread.getState());
//
//            thread.start();
//
//            System.out.println("Состояние потока после его запуска: " + thread.getState());
//
//            Thread.sleep(500);
//
//            System.out.println("Состояние потока через 500 миллисекунд: " + thread.getState());
//
//            thread.join();
//
//            System.out.println("Состояние потока после его завершения: " + thread.getState());
//        }
//    }
//
//
//
//

public class SostoyanyePotokov {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Поток запущен");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        System.out.println("Состояние потока до его запуска: " + thread.getState());

        thread.start();

        System.out.println("Состояние потока после его запуска: " + thread.getState());

        Thread.sleep(500);

        System.out.println("Состояние потока через 500 миллисекунд: " + thread.getState());

        // Добавлен вывод состояния "Running" перед ожиданием завершения потока
        System.out.println("Состояние потока перед остановкой по времени: " + thread.getState());

        thread.join();

        System.out.println("Состояние потока после его завершения: " + thread.getState());
    }
}
