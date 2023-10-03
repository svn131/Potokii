package org.example;

public class VolotileRealPrimer {

    private volatile boolean flag = false;

    public void setFlag(boolean value) {
        flag = value;
    }

    public void printFlag() {
        System.out.println("Flag: " + flag);
    }


    public static void main(String[] args) {
        VolotileRealPrimer example = new VolotileRealPrimer();

        // Поток 1
        Thread thread1 = new Thread(() -> {
            System.out.println("Поток 1 начал работу");
//            try {
//                thread2.join();
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
            while (!example.flag) {

                // Ожидание, пока флаг не станет true до этого времени поток просто крутит пустой цикл из которого не может выйти
            }
            System.out.println("Поток 1 завершил работу");
        });

        // Поток 2
        Thread thread2 = new Thread(() -> {
            System.out.println("Поток 2 начал работу");
            try {
//            thread1.join();
                Thread.sleep(2000); // Задержка на 2 секунды
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            example.setFlag(true); // Установка флага в true
            System.out.println("Поток 2 изменил флаг");
        });


        thread2.start();
        thread1.start();
    }


    }

//    А почему если я убираю волотайл то последняя строчка Поток 1 завершил работу не выводиться вообще ??? Потому что volatile boolean flag в хиппе так и остаеться фолсе и в строке где он меняеться на тру example.setFlag(true); это остаеться просто в кеше второго потока ?
//
//Да, вы правильно заметили. Если вы уберете ключевое слово volatile из объявления переменной flag, то изменения этой переменной могут остаться только в кэше потока, и другие потоки могут не увидеть эти изменения.
//        Когда переменная объявлена как volatile, ее значения всегда записываются и считываются напрямую из памяти, а не из кэша потока. Это гарантирует, что изменения, сделанные одним потоком, будут немедленно видны другим потокам.
//        В вашем примере, если вы уберете volatile из объявления переменной flag, то значение flag может остаться в кэше потока, и поток thread1 будет продолжать ожидать изменения значения flag, даже после выполнения строки example.setFlag(true) в потоке thread2.
//        Использование volatile обеспечивает корректную видимость изменений переменной между потоками и предотвращает такие проблемы. Поэтому, чтобы гарантировать, что изменения переменной flag будут видны другим потокам, вам следует использовать ключевое слово volatile при объявлении переменной.

