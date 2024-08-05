package vendingmachine;

public class VendingMachine {


    private Inventory inventory;
    private Default defaultState;
    private MachineState currentState;
    private ReadyToReceiveCashAndDispense readyToReceiveCashAndDispenseState;
    private ProvideChangeState provideChangeState;
    private double currentPaidAmount;
    private Product selectedProduct;

    private static VendingMachine vendingMachine;

    private VendingMachine(){
        inventory = new Inventory(this);
        defaultState = new Default(this);
        readyToReceiveCashAndDispenseState = new ReadyToReceiveCashAndDispense(this);
        provideChangeState = new ProvideChangeState(this);
        currentState = defaultState;

    }

    public static synchronized VendingMachine getVendingMachine(){
        if( vendingMachine == null ){
            vendingMachine = new VendingMachine();
        }

        return vendingMachine;
    }

    public double getCurrentPaidAmount(){
        return currentPaidAmount;
    }

    public void updateCurrentPaidAmount( double amount ){
        currentPaidAmount = amount;
    }

    public Product getSelectedProduct(){
        return selectedProduct;
    }

    public void setSelectedProduct( Product product ){
        selectedProduct = product;
    }

    public MachineState getCurrentState(){
        return currentState;
    }

    public void setMachineState( MachineState machineState ){
        currentState = machineState;
    }

    public Default getDefaultState(){
        return defaultState;
    }

    public ProvideChangeState getProvideChangeState(){
        return provideChangeState;
    }

    public ReadyToReceiveCashAndDispense getReadyToReceiveCashAndDispenseState(){
        return readyToReceiveCashAndDispenseState;
    }

    public Inventory getInventory(){
        return inventory;
    }



    public void findBillingAmount(Product product){
        double billingAmount = product.getProductPrice();
        double paidAmount = getCurrentPaidAmount();

        System.out.println("The total billing amount is " + billingAmount
                + " and the paid amount is " + paidAmount +
                " and the remaining bill is " + (billingAmount - paidAmount) );
    }

    public void currentInventoryStatus(){
        vendingMachine.getInventory().displayAvailableProducts();
    }



}
