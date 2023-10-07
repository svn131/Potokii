package Patterns.AbstractFabrica;

public class AbstractFactoryTutorial  {
    public static void main(String[] args) {

        AbstractFactory factoryChocolate = new ChocolatFactory();

        Cake cake = factoryChocolate.getCake();
        Coctail coctail = factoryChocolate.getCoctail();

        cake.printName();
        cake.PrintPrise();







    }
}


interface AbstractFactory {
    Cake getCake();
    Coctail getCoctail();
}

class ChocolatFactory implements AbstractFactory {// Шоколадная абстрактная фабрика
    @Override
    public Cake getCake() {
        return new ChocolateCake();
    }

    @Override
    public Coctail getCoctail() {
        return new ChocolateCoctail();
    }


}









//ПИРОЖЕНЫЕ
interface Cake {
    void printName();
    void PrintPrise();

 }

 class ChocolateCake implements  Cake {


     @Override
     public void printName() {
         System.out.println("ChocolateCake");
     }

     @Override
     public void PrintPrise() {
         System.out.println("50");
     }
 }
class CreamCake implements  Cake {


    @Override
    public void printName() {
        System.out.println("CreamCake ");
    }

    @Override
    public void PrintPrise() {
        System.out.println("35");
    }
}



/////////////////////////
//КОКТЕЛИ
interface   Coctail {

    void printName();
    void PrintPrise();

}

class ChocolateCoctail implements  Coctail {


    @Override
    public void printName() {
        System.out.println("ChocolateCoctail");
    }

    @Override
    public void PrintPrise() {
        System.out.println("25");
    }
}
class CreamCoctail implements  Coctail {


    @Override
    public void printName() {
        System.out.println("CreamCoctail");
    }

    @Override
    public void PrintPrise() {
        System.out.println("20");
    }
}