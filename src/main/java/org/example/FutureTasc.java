package org.example;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTasc {
    public static void main(String[] args) {
            // Создаем Callable объект, который будет выполняться асинхронно
            Callable<Integer> callable = () -> {
                Thread.sleep(2000); // Имитация длительной операции
                return 42;
            };

            // Создаем FutureTask, обертывая Callable объект
            FutureTask<Integer> futureTask = new FutureTask<>(callable);

            // Запускаем выполнение задачи в отдельном потоке
            Thread thread = new Thread(futureTask);
            thread.start();

            // Делаем другую работу в основном потоке

            try {
                // Блокируем текущий поток и ожидаем завершения задачи
                Integer result = futureTask.get();
                System.out.println("Результат: " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }


