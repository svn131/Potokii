package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ZadachaStrimIlymbda {

        public static void main(String[] args) {
            Zadacha zadacha = new Zadacha();
            zadacha.run();
        }

        public void run() {
            int[][] dvuhMasiv = new int[4][5];

            dvuhMasiv[0] = new int[]{1, 1, 1, 1, 0};
            dvuhMasiv[1] = new int[]{1, 1, 0, 1, 0};
            dvuhMasiv[2] = new int[]{1, 1, 0, 0, 0};
            dvuhMasiv[3] = new int[]{0, 0, 0, 0, 0};

            vicheslenya(dvuhMasiv);
        }

        public void vicheslenya(int[][] dvuhMasiv) {
            List<Ostrov> vseOstrova = new ArrayList<>();

            for (int x = 0; x < dvuhMasiv.length; x++) {
                for (int y = 0; y < dvuhMasiv[x].length; y++) {
                    if (dvuhMasiv[x][y] == 1) {
                        final int copyX = x;
                        final int copyY = y;

                        boolean nashlas = vseOstrova.stream()
                                .flatMap(ostrov -> ostrov.getKordinatyOstrova().stream())
                                .flatMap(odnaIzCordinat -> odnaIzCordinat.entrySet().stream())
                                .anyMatch(tochka -> {
                                    int key = tochka.getKey();
                                    int value = tochka.getValue();

                                    return IntStream.rangeClosed(-1, 1)
                                            .flatMap(i -> IntStream.rangeClosed(-1, 1).map(j -> copyX + i == key && copyY + j == value ? 1 : 0))
                                            .sum() > 0;
                                });

                        if (!nashlas) {
                            Ostrov ostrov = new Ostrov(x, y);
                            vseOstrova.add(ostrov);
                        }
                    }
                }
            }

            System.out.println(vseOstrova.size());
        }

        public class Ostrov {
            List<Map<Integer, Integer>> kordinatyOstrova = new ArrayList<>();

            public Ostrov(int x, int y) {
                add(x, y);
            }

            public List<Map<Integer, Integer>> getKordinatyOstrova() {
                return new ArrayList<>(kordinatyOstrova);
            }

            public void put(Integer x, Integer y) {
                boolean moghno = kordinatyOstrova.stream()
                        .flatMap(odnaIzCordinat -> odnaIzCordinat.entrySet().stream())
                        .noneMatch(tochka -> x.equals(tochka.getKey()) && y.equals(tochka.getValue()));

                if (moghno) {
                    add(x, y);
                }
            }

            public void add(int x, int y) {
                Map<Integer, Integer> kordinata = new HashMap<>();
                kordinata.put(x, y);
                kordinatyOstrova.add(kordinata);
            }
        }
    }


