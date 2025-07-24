package vendingmachine;

public class ReadyToReceiveCashAndDispense implements MachineState{

    private VendingMachine vendingMachine;

    public ReadyToReceiveCashAndDispense( VendingMachine theVendingMachine ){
        vendingMachine = theVendingMachine;
    }


    @Override
    public void addProduct(Product product) {
        System.out.println("The product is added in to the cart. Please proceed to payment and dispersal!!");
    }

    @Override
    public void insertCoin(Coin coin) {

        System.out.println("Inserting the coin of value " + coin.getValue() );

        if( vendingMachine.getCurrentPaidAmount() >=
                vendingMachine.getSelectedProduct().getProductPrice() ){
            System.out.println("The payment is completed. Please collect your bottle, and collect the change");
        } else {
            double coinValue = coin.getValue();

            double paidAmount = vendingMachine.getCurrentPaidAmount();

            paidAmount += coinValue;

            vendingMachine.updateCurrentPaidAmount(paidAmount);
        }

        if( vendingMachine.getCurrentPaidAmount() >=
                vendingMachine.getSelectedProduct().getProductPrice() ){
            System.out.println("The amount is paid now!!!");

            System.out.println("The product is going to be dispersed");
            getProduct();
        }

    }

    @Override
    public void insertNote(Note note) {

        System.out.println("Inserting the coin of value " + note.getValue() );

        if( vendingMachine.getCurrentPaidAmount() >=
                vendingMachine.getSelectedProduct().getProductPrice() ){
            System.out.println("The payment is completed. Please collect your bottle, and collect the change");
        } else {
            double noteValue = note.getValue();

            double paidAmount = vendingMachine.getCurrentPaidAmount();

            paidAmount += noteValue;

            vendingMachine.updateCurrentPaidAmount(paidAmount);
        }

        if( vendingMachine.getCurrentPaidAmount() >=
                vendingMachine.getSelectedProduct().getProductPrice() ){
            System.out.println("The amount is paid now!!!");

            System.out.println("The product is going to be dispersed");
            getProduct();
        }
    }

    @Override
    public void getProduct() {
        System.out.println("Inside the getProduct() to disperse the product to the end-user");

        System.out.println("The product is dispersed");
        vendingMachine.setMachineState(vendingMachine.getProvideChangeState());
        vendingMachine.getCurrentState().getRemainingChange();
    }

    @Override
    public void getRemainingChange() {
        System.out.println("Please proceed to the payment section and dispersal");
    }


}
