package org.example;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureTask1 {
    public static void main(String[] args) {


        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            public String call() throws Exception {
                // Выполнение асинхронной задачи
                return "Результат задачи";
            }
        });

// Запуск задачи
        new Thread(futureTask).start();

        try {
            String result = futureTask.get(); // Получение результата
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//import java.util.concurrent.Callable;
//        import java.util.concurrent.ExecutionException;
//        import java.util.concurrent.FutureTask;
//
//public class FutureTaskExample {
//    public static void main(String[] args) {
//        Callable<String> callable = () -> {
//            // Код выполнения задачи
//            return "Task is running";
//        };
//
//        FutureTask<String> futureTask = new FutureTask<>(callable);
//
//        Thread thread = new Thread(futureTask);
//        thread.start();
//
//        try {
//            String result = futureTask.get(); // Получение результата
//            System.out.println(result);
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//    }
//}

