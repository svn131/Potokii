package org.example;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicInteger;

public class VolotailClass {

//    public static void main(String[] args) {
//        // Создаем объект для анализа
//        MyClass myObject = new MyClass();
//
//        // Получаем класс объекта
//        Class<?> objectClass = myObject.getClass();
//
//        // Получаем все поля объекта
//        Field[] fields = objectClass.getDeclaredFields();
//        System.out.println("Поля объекта:");
//        for (Field field : fields) {
//            System.out.println(field.getName());
//        }
//
//        // Получаем все методы объекта
//        Method[] methods = objectClass.getDeclaredMethods();
//        System.out.println("Методы объекта:");
//        for (Method method : methods) {
//            System.out.println(method.getName());
//        }
//    }
//}
//
//class MyClass {
//    private int myField;
//
//    public void myMethod() {
//        // Код метода
//    }
//}

//    private volatile boolean flag = false;
//
//
//    public static void main(String[] args) {
//
//
//        AtomicInteger i = new AtomicInteger();
//        VolotailClass main = new VolotailClass();
//
//        // Поток 1 устанавливает значение переменной flag в true
//        Thread thread1 = new Thread(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            main.setFlag(true);
//
//
//            i.set(10);
//
//            System.out.println("Поток 1: Значение переменной flag установлено в true");
//        });
//
//        // Поток 2 проверяет значение переменной flag
//        Thread thread2 = new Thread(() -> {
//            while (main.isFlag()) {
//                // Ждем, пока значение переменной flag не станет true
//            }
//            System.out.println("Поток 2: Значение переменной flag изменилось на true");
//        });
//
//        thread1.start();
//        thread2.start();
//    }
//
//    public synchronized boolean isFlag() {
//        return flag;
//    }
//
//
//
//    public synchronized void setFlag(boolean flag) {
//        this.flag = flag;
//    }




  //      private AtomicInteger counter = new AtomicInteger(0);
        volatile  int counter = 0;
        public static void main(String[] args) {
            VolotailClass main = new VolotailClass();

            Thread thread1 = new Thread(() -> {
                for (int i = 0; i < 1000000; i++) {
                    main.incrementCounter();
                }
            });

            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < 1000000; i++) {
                    main.incrementCounter();
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

            System.out.println("Counter value: " + main.getCounter());
        }
    // synchronized
      private  void incrementCounter() {

          System.out.println(Thread.currentThread().getName());

        counter++;
        }

      private  int getCounter() {

        return counter;
        }
    }










