package coffeevendingmachine;

public class Espresso  extends ParentCoffee{

    public Espresso( double thePrice, String theRecipe, int cupCount ){
        System.out.println("Making the espresso");
        price = thePrice;
        recipe = theRecipe;
        numOfCups = cupCount;
    }



}
