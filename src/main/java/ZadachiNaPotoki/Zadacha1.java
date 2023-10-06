package ZadachiNaPotoki;

import java.util.concurrent.*;

public class Zadacha1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int seredkaMassiva = arr.length / 2;

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> pervayaTaska = executorService.submit(() -> {
        int sum = 0;
        for (int i = 0; i < seredkaMassiva; i++) {
            sum += arr[i];
        }
        return sum;
    });


        Future<Integer> vtorayaTaska = executorService.submit(() -> {
            int sum = 0;
            for (int i = seredkaMassiva; i < arr.length; i++) {
                sum += arr[i];
            }
            return sum;


                });


        int totalRess = pervayaTaska.get() + vtorayaTaska.get();

        System.out.println(totalRess);

        executorService.shutdown(); // без этого поток майн не останавливаеться из за потоков екзекутора которые продолжают работать



//        executorService.execute(() -> { // годиться только для вывода - так как нет доступа  к результату из вне потока
//            int sum = 0;
//            for (int i = 0; i < seredkaMassiva; i++) {
//                sum += arr[i];
//            }
//
//        });
//
//        executorService.execute(() -> {
//                    int sum = 0;
//                    for (int i = seredkaMassiva; i < arr.length; i++) {
//                        sum += arr[i];
//                    }
//                }
//
//
//
//        );
//
//        executorService.shutdown(); //Метод shutdown() в классе ExecutorService служит для корректного завершения работы пула потоков. Когда вы вызываете shutdown(), пул потоков перестает принимать новые задачи и начинает завершать выполнение уже запущенных задач. Он дожидается завершения всех текущих задач, а затем останавливает все потоки в пуле.





    }
}

//    class Tread1 implements Callable<Integer> {
//
//        @Override
//        public Integer call() throws Exception {
//           ;
//        }
//    }


