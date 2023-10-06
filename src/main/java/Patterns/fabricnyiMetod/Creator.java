package Patterns.fabricnyiMetod;

public class Creator extends Factory{
    public Creator(int flag) {
        super(flag);
    }

    @Override
    Chocolate create()  {
       if(flag == 0)
          return new WhiteChocolate();

        if(flag == 1)
            return new BlackChocolate();


        return null;
    }
}
