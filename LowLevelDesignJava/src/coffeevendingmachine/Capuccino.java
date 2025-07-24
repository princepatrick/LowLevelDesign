package coffeevendingmachine;

public class Capuccino extends ParentCoffee{

    public Capuccino( double thePrice, String theRecipe, int cupCount ){
        System.out.println("Making the capuccino");
        price = thePrice;
        recipe = theRecipe;
        numOfCups = cupCount;
    }

}
