package org.example;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTack2 {



        public static void main(String[] args) {
            // Создаем Callable объект, который будет выполняться асинхронно
            Callable<Integer> callable = () -> {
                Thread.sleep(2); // Имитация длительной операции
                return 42;
            };

            // Создаем FutureTask, обертывая Callable объект
            FutureTask<Integer> futureTask = new FutureTask<>(callable);

            // Запускаем выполнение задачи в отдельном потоке
            Thread thread = new Thread(futureTask);
            thread.start();

            // Проверяем статус выполнения задачи
            if (futureTask.isDone()) {
                try {
                    // Получаем результат выполнения задачи
                    Integer result = futureTask.get();
                    System.out.println("Результат: " + result);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Задача все еще выполняется...");
            }
        }
    }

