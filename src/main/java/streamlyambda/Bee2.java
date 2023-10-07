package streamlyambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Bee2 {


    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5,6,8};
        List<Integer> arrListik = new ArrayList<>();

        arrListik.add(1);
        arrListik.add(2);
        arrListik.add(3);
        arrListik.add(4);
        arrListik.add(5);
        arrListik.add(6);



        Bee2 bee2 = new Bee2();
        System.out.println(bee2.run(arr));
        System.out.println(bee2.runList(arrListik));

        System.out.println("4ka за четверть " + bee2.ocenka4(arr));
    }

    public int run (int[] arr){

       return Arrays.stream(arr)
                .reduce(0 , (a,b) -> a + b);

    }

    public Integer runList(List<Integer> listik){
     return    listik.stream()
                .reduce(0,(a,b) -> a + b);

}



public int runMnogitel(int i){

 return    Stream.of(i)
            .map(x -> x * x)
            .findFirst()
            .orElse(0);



}


public int  runUgadayChislo(int a){


 return    IntStream.of(a)
            .map(x -> x*100 + 90 + 9-x)
            .findFirst()
            .orElse(0);




}


public boolean ocenka4 (int[] arr){
     Long sumChet = Arrays.stream(arr)
                .filter(x -> x % 2 == 0)
//                .reduce(0,(x,y) -> x + y);
             .count();

    Long sumNeChet =   Arrays.stream(arr)
            .filter(x -> x % 2 == 1)
            .count();

    return sumChet > sumNeChet;

}

}
