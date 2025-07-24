package coffeevendingmachine;

public class CoffeeVendingMachineDemo {

    public static void run(){

        CoffeeVendingMachine cvm = CoffeeVendingMachine.getInstance();

        /*
            Positive Case:
            1. Add all the prices and recipe for each coffee
            2. Add all the coffee in the Menu
            3. Search for the expected coffee in the Menu - Idle to Selected state
            4. Start paying money - coins and notes - once payment done Selected to Disperse state
            5. Click disperse - disperse to return change state
            6. Click return change - return change to idle state, selected product is null, and paid amount is 0
        * */

        //new Espresso( 3.5, "Recipe A");
        Espresso espresso = new Espresso( 3.5, "Recipe A", 10);

        cvm.addCoffee(  (ParentCoffee)  espresso );

        Capuccino capuccino = new Capuccino( 4.5, "Recipe B", 20 );

        cvm.addCoffee(  (ParentCoffee)  capuccino );

        Latte latte = new Latte( 5, "Recipe C", 15 );

        cvm.addCoffee( (ParentCoffee)  latte);

        //Idle state before this
        ParentCoffee selectedCoffee = cvm.search( (ParentCoffee) espresso);

        cvm.buyCoffee( selectedCoffee );

        //Payment state starts
        cvm.insertCoin( Coin.QUARTER );

        cvm.insertCoin( Coin.QUARTER );

        cvm.insertNote( Note.FIVE );

        //Payment crosses threshold - now goes to disperse state

        cvm.dispenseProduct();

        //Now dispensal state is completed - reached Return change state

        cvm.returnChange();



    }
}
