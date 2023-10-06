package Patterns.fabricnyiMetod;

public abstract class Factory {
    int flag;

    public Factory(int flag) {
        this.flag = flag;
    }

    abstract Chocolate create() ;
}
