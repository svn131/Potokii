package org.example;

public class SynchronizationExample {

    // Класс, в котором используется статическая синхронизация
    public static class StaticSynchronization {
        private static int count = 0;

        public static synchronized void increment() {
            for (int i = 0; i < 5; i++) {
                System.out.println( Thread.currentThread().getName());
                System.out.println("Static: " + count++);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Класс, в котором используется обычная синхронизация
//    public static class InstanceSynchronization {
//        private int count = 0;
//
//        public synchronized void increment() {
//            for (int i = 0; i < 5; i++) {
//                System.out.println("Instance: " + count++);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    public static void main(String[] args) throws InterruptedException {
        StaticSynchronization staticSync = new StaticSynchronization();

        Thread staticThread1 = new Thread(() -> staticSync.increment());
        Thread staticThread2 = new Thread(() -> staticSync.increment());

        staticThread1.start();
        staticThread2.start();


            staticThread1.join();
            staticThread2.join();


//        System.out.println("----------------------");
//
//        InstanceSynchronization instanceSync1 = new InstanceSynchronization();
//        InstanceSynchronization instanceSync2 = new InstanceSynchronization(); //@todo обратить внимание что ниже используються два разных объекта instanceSync1 , instanceSync2
//
//        Thread instanceThread1 = new Thread(() -> instanceSync1.increment());
//        Thread instanceThread2 = new Thread(() -> instanceSync2.increment());
//
//        instanceThread1.start();
//        instanceThread2.start();
//
//        try {
//            instanceThread1.join();
//            instanceThread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
