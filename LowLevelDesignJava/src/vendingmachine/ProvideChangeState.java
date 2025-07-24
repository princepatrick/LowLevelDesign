package vendingmachine;

public class ProvideChangeState implements MachineState{

    private VendingMachine vendingMachine;

    public ProvideChangeState(VendingMachine theVendingMachine){
        vendingMachine = theVendingMachine;
    }

    @Override
    public void addProduct(Product product) {
        System.out.println("The product is already selected collect the remaining change!!");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("The payment is already completed. collect the remaining change!!");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("The payment is already completed. collect the remaining change!!");
    }

    @Override
    public void getProduct() {
        System.out.println("The product is dispersed. collect the remaining change!!");
    }

    @Override
    public void getRemainingChange() {

        System.out.println("Receiving the remaining change");

        double paidAmount = vendingMachine.getCurrentPaidAmount();
        double cost = vendingMachine.getSelectedProduct().getProductPrice();
        double theChange = paidAmount - cost;

        System.out.println("The paid amount is " + paidAmount + " , the cost is " + cost + ", and the remaining change is : " + theChange );

        if( theChange > 0 ){
            System.out.println("The change of " + theChange + " has been dispersed");
        }

        vendingMachine.setMachineState(vendingMachine.getDefaultState());
        vendingMachine.updateCurrentPaidAmount(0.0);
    }
}
