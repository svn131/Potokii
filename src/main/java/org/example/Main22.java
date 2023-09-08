package org.example;

public class Main22 {


    public static void staticMetod() {

        synchronized (Main22.class){

        }


    }


    public void noStaticMetod() {


        synchronized (this){

        }
    }









}
