package Patterns.fabricnyiMetod;

import java.util.ArrayList;
import java.util.List;

public class FabricnyiMetodClass {
    public static void main(String[] args) {


        List<Chocolate> chocolateList = new ArrayList<>();

        Factory factory = new Creator(1); // 0 или 1 определяет что будем создавать белый или черный шаколад
        Chocolate chocolate = factory.create();
        chocolate.printPrise();


    }
}

//https://www.youtube.com/watch?v=fC83ITS_NHQ
