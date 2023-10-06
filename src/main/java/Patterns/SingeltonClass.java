package Patterns;

public class SingeltonClass {

}
 class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
        // Приватный конструктор
    }

    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
//     В этом примере класс ThreadSafeSingleton имеет приватный конструктор, чтобы предотвратить создание экземпляров класса извне. Статическое поле instance является волатильным и хранит единственный экземпляр класса.
//        Метод getInstance() реализует потокобезопасность с помощью двойной проверки блокировки. При первом вызове метода, если instance равно null, происходит блокировка синхронизированного блока. Затем происходит повторная проверка instance внутри блока для обеспечения потокобезопасности. Если instance все еще равно null, создается новый экземпляр класса.
//        Использование ключевого слова volatile для поля instance гарантирует, что изменения этого поля будут видны всем потокам, что важно для корректной работы двойной проверки блокировки.
//        Таким образом, этот потокобезопасный паттерн Singleton гарантирует создание только одного экземпляра класса в многопоточной среде.