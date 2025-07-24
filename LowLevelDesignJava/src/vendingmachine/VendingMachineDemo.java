package vendingmachine;

public class VendingMachineDemo {

    public static void run(){
        //Creating the instance of Vending Machine - This marks our interaction with the Vending Machine
        VendingMachine vendingMachine = VendingMachine.getVendingMachine();

        //This marks the creation of Products - Hoodie, Pants, Shirts
        Product coke = new Product("Coke", 2);
        Product chips = new Product("Chips", 1.5);
        Product fanta = new Product("Fanta", 2.5);

        //All the products are added into the inventory
        vendingMachine.getInventory().addProductToInventory(coke, 3);
        vendingMachine.getInventory().addProductToInventory(chips, 5);
        vendingMachine.getInventory().addProductToInventory(fanta, 8);

        //The pant is bought from the inventory
        vendingMachine.getInventory().buyProduct(chips);

        //Finding the billing amount
        vendingMachine.findBillingAmount(chips);

        //Paying the machine
        vendingMachine.getCurrentState().insertCoin(Coin.TEN);
        vendingMachine.getCurrentState().insertCoin(Coin.TEN);
        vendingMachine.getCurrentState().insertCoin(Coin.TEN);
        vendingMachine.getCurrentState().insertCoin(Coin.TEN);
        vendingMachine.getCurrentState().insertCoin(Coin.TEN);

        vendingMachine.getCurrentState().insertNote(Note.ONE);

        //All the processes to receive the product should be logged now

        //Display the remaining products
        vendingMachine.currentInventoryStatus();

        //Buying the product 2
        vendingMachine.getInventory().buyProduct(coke);


        //Paying the machine
        vendingMachine.getCurrentState().insertNote(Note.FIVE);

        //All the processes to receive the product should be logged now and with the return change

    }


}
