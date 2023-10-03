package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zadacha {
    public static void main(String[] args) {


        Zadacha zadacha = new Zadacha();
        zadacha.run();

    }

    public void run(){

        int [][] dvuhMasiv = new int[4][5]; // 4 х вниз   - у 5ть у в бок

        dvuhMasiv[0] = new int[]{1, 1, 1, 1, 0};
        dvuhMasiv[1] = new int[]{1, 1, 0, 1, 0};
        dvuhMasiv[2] = new int[]{1, 1, 0, 0, 0};
        dvuhMasiv[3] = new int[]{0, 0, 0, 0, 0};

//        dvuhMasiv[0][0]= 1;
//        dvuhMasiv[0][1]= 1;
//        dvuhMasiv[0][2]= 1;
//        dvuhMasiv[0][3]= 1;
//        dvuhMasiv[0][4]= 0;
//
//
//        dvuhMasiv[1][0]= 1;
//        dvuhMasiv[1][1]= 1;
//        dvuhMasiv[1][2]= 0;
//        dvuhMasiv[1][3]= 1;
//        dvuhMasiv[1][4]= 0;
//
//
//        dvuhMasiv[2][0]= 1;
//        dvuhMasiv[2][1]= 1;
//        dvuhMasiv[2][2]= 0;
//        dvuhMasiv[2][3]= 0;
//        dvuhMasiv[2][4]= 0;
//
//
//
//        dvuhMasiv[3][0]= 0;
//        dvuhMasiv[3][1]= 0;
//        dvuhMasiv[3][2]= 0;
//        dvuhMasiv[3][3]= 0;
//        dvuhMasiv[3][4]= 0;

        vicheslenya(dvuhMasiv);







    }

    public void  vicheslenya (int[][] dvuhMasiv){

        List<Ostrov> vseOstrova = new ArrayList<>();

        for (int x = 0; x < dvuhMasiv.length; x++) {
            for (int y = 0; y < dvuhMasiv[x].length; y++) {

                boolean nashlas = false ;


                if(dvuhMasiv[x][y]== 1){



                 for(Ostrov ostrov : vseOstrova) {
                     for (Map<Integer, Integer> odnaIzCordinat : ostrov.getKordinatyOstrova()) {

                         for (Map.Entry<Integer, Integer> tochka : odnaIzCordinat.entrySet()) {
                             int key = tochka.getKey();
                             int value = tochka.getValue();

                             for (int i = -1; i <= 1; i++) {
                                 for (int j = -1; j <= 1; j++) {

//                                 if(j==0&&i==0) continue;
                                     if (x == 1 && y == 0)
                                         System.out.println((x + i) + " and " + (y + j) + " flag1 " + (x + i == key) + " flag2 " + (y + j == value));

                                     if (x + i == key && y + j == value) {
                                         nashlas = true;
                                         ostrov.put(x, y); // todo можно флагом облегчить процесс
                                         System.out.println(x + "--" + y);
                                     }


                                 }

                             }



                         }

                     }
                 }

                 if(!nashlas ){
               Ostrov ostrov = new Ostrov(x,y);
                     vseOstrova.add(ostrov);
                 }


             }


            }
        }

        System.out.println(vseOstrova.size());

    }


    public class Ostrov{

        List<Map<Integer,Integer>> kordinatyOstrova =  new ArrayList<>(); //new arayList????


        public Ostrov(int x, int y) {
            add(x,y);
        }


        public List<Map<Integer, Integer>> getKordinatyOstrova() {  // todo MyCuncarent

//            List<Map<Integer,Integer>> kordinatyOstrovaVer1 =  new ArrayList<>();
//
//            kordinatyOstrovaVer1.addAll(kordinatyOstrova);

             return new ArrayList<>(kordinatyOstrova);
        }

        public void put(Integer x, Integer y) {

           boolean moghno = true;
           for (Map<Integer, Integer> odnaIzCordinat : kordinatyOstrova) {
               for (Map.Entry<Integer, Integer> tochka : odnaIzCordinat.entrySet()) {
                   int key = tochka.getKey();
                   int value = tochka.getValue();

                   if (x == key && y == value) moghno = false;

               }
           }

           if (moghno) {
              add(x,y);
           }
       }


       public void add(int x,int y){
           Map <Integer,Integer> kordinata = new HashMap<>();
           kordinata.put(x,y);
           kordinatyOstrova.add(kordinata);
       }

    }
}


