package vendingmachine;

public class Default implements MachineState{

    private VendingMachine vendingMachine;

    public Default( VendingMachine theVendingMachine ){
        vendingMachine = theVendingMachine;
    }


    @Override
    public void addProduct(Product product) {

        System.out.println("Trying to add the product " + product.getName() + " into the shopping cart!!");

        Inventory inventoryRecords = vendingMachine.getInventory();

        if( inventoryRecords.isProductAvailable(product) &&
                inventoryRecords.getNumberOfProductsAvailable(product) > 0 ){
            vendingMachine.getInventory().buyProduct( product );
            vendingMachine.setMachineState(vendingMachine.getReadyToReceiveCashAndDispenseState());
        } else {
            System.out.println("The product is not available. Try another product, please.");
        }

    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select the product before attempting to insert coin");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please select the product before attempting to insert note");
    }

    @Override
    public void getProduct() {
        System.out.println("Please select the product before requesting for dispersal");
    }

    @Override
    public void getRemainingChange() {
        System.out.println("Please select the product before requesting for change");
    }
}
