package ZadachiNaPotoki;

import java.util.concurrent.*;

public class Zadacha2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int seredkaMassiva = arr.length / 2;
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> futureTask = executorService.submit(() -> {
            int sum = 0;
            for (int i = 0; i < seredkaMassiva; i++) {
                sum += arr[i];
            }
            return sum;
        });


        Future<Integer> futureTask2 = executorService.submit(() -> {
            int sum = 0;
            for (int i = seredkaMassiva; i < arr.length; i++) {
                sum += arr[i];
            }
            return sum;
        });

        executorService.shutdown();

        System.out.println(futureTask2.get() + futureTask.get());
    }
}