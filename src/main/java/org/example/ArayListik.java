package org.example;

import java.util.ArrayList;
import java.util.List;

public class ArayListik {
    public static void main(String[] args) {

        List<Integer> listik = new ArrayList<>();

        Integer a = 0;
        Integer b = 1;
        Integer c = 2;

        Integer d = 33;

        listik.add(a);
        listik.add(b);
        listik.add(c);

        listik.add(1,d);



        for (Integer integer : listik) {
            System.out.println(integer);
        }



    }
}
