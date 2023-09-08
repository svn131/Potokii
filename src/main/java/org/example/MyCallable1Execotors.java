package org.example;

import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;

public class MyCallable1Execotors {
    public static void main(String[] args) {


        Callable<String> myCallable = new MyCallable();
//        Создайте экземпляр ExecutorService с помощью класса Executors.Вы можете выбрать один из вариантов
//        пула потоков, например, newFixedThreadPool, newCachedThreadPool, newSingleThreadExecutor и т.д.:
//        java
//        Copy code


        ExecutorService executor = Executors.newFixedThreadPool(1); // Например, пул из одного потока
//        Используйте метод submit для запуска вашей задачи Callable:
//        java
//        Copy code
        Future<String> futureResult = executor.submit(myCallable);
//        Чтобы получить результат выполнения задачи, вы можете использовать методы объекта Future:
//        java
//        Copy code
        try {
            String result = futureResult.get(); // Блокирующий вызов, ожидание завершения задачи и получение результата
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

// Не забудьте закрыть ExecutorService после завершения всех задач
        executor.shutdown();
    }
}