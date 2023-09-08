package org.example;

public class RaceConditoin {


        volatile static int counter = 0;

        public static void main(String[] args) {
            Thread thread1 = new Thread(() -> {
                for (int i = 0; i < 100000; i++) {
                    counter++; //@todo он допустим взял counter коогда он был 5 и затем добавил 1 и стал каунтер 6
                }
            });

            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < 100000; i++) {
                    counter++; //@todo это тоже взял ее когда она была 5 и так же добавил ей 1 и она стала 6 в итоге оба инкремента прибавили всего 1
                }
            });

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Counter value: " + counter);
        }
    }

    // 193274 За счет чтения такое просиходит и потомучто не атомарно.



//    private static int counter = 0;
//
//    public static synchronized void incrementCounter() {
//        counter++;
//    }
//
//    public static void main(String[] args) {
//        Thread thread1 = new Thread(() -> {
//            for (int i = 0; i < 100000; i++) {
//                incrementCounter();
//            }
//        });
//
//        Thread thread2 = new Thread(() -> {
//            for (int i = 0; i < 100000; i++) {
//                incrementCounter();
//            }
//        });
//
//        thread1.start();
//        thread2.start();
//
//        try {
//            thread1.join();
//            thread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Значение счетчика: " + counter);
//    }
//}


