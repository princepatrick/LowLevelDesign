package coffeevendingmachine;

public class Latte extends ParentCoffee{

    public Latte( double thePrice, String theRecipe, int cupCount ){
        System.out.println("Making the latte");
        price = thePrice;
        recipe = theRecipe;
        numOfCups = cupCount;
    }

}
