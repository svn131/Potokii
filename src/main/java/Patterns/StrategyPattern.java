package Patterns;

public class StrategyPattern {
    public static void main(String[] args) {

        Door door = new Door();

        Strategy open = new Open();
        door.setStrategy(open);
        door.move();



        Strategy close = new Close();
        door.setStrategy(close);
        door.move();
    }
}
class Door {

    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void move(){
        strategy.openClose();
    }
}

interface Strategy {
    void openClose();
}



class Open implements Strategy{

    @Override
    public void openClose() {
        System.out.println("Дверь открыта");
    }
}
class Close implements Strategy{

    @Override
    public void openClose() {
        System.out.println("Дверь закрыта");
    }
}