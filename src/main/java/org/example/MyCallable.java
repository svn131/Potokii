package org.example;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        // Ваш код выполнения задачи в потоке
        return "Результат выполнения задачи";
    }
}