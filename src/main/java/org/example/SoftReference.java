package org.example;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class SoftReference {
    public static void main(String[] args) {
        // Пример строгого владения объектом
        String strongReference = new String("Strong Reference");
        System.out.println("Strong Reference: " + strongReference);

        // Пример мягкого владения объектом
        ReferenceQueue<String> softReferenceQueue = new ReferenceQueue<>();
        String softReference = new String("Soft Reference");
        Reference<String> softRef = new java.lang.ref.SoftReference<>(softReference, softReferenceQueue);
        softReference = null; // Удаляем сильную ссылку на объект
        System.gc(); // Запускаем сборщик мусора
        System.out.println("Soft Reference: " + softRef.get());

        // Пример фантомной ссылки
        ReferenceQueue<String> phantomReferenceQueue = new ReferenceQueue<>();
        String phantomReference = new String("Phantom Reference");
        Reference<String> phantomRef = new PhantomReference<>(phantomReference, phantomReferenceQueue);
        phantomReference = null; // Удаляем сильную ссылку на объект
        System.gc(); // Запускаем сборщик мусора
        System.out.println("Phantom Reference: " + phantomRef.get());
    }
}
