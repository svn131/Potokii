package Patterns.fabricnyiMetod;

public class WhiteChocolate implements Chocolate{

    private final int prise = 15;
    @Override
    public void printPrise() {
        System.out.println(prise);
    }
}
