package Patterns.fabricnyiMetod;

public class BlackChocolate implements Chocolate{

    private final int prise = 10;
    @Override
    public void printPrise() {
        System.out.println(prise);
    }
}
