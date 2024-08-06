package coffeevendingmachine;

public class ReturnChangeState implements CoffeeVendingMachineState{

    CoffeeVendingMachine cvm;

    ReturnChangeState( CoffeeVendingMachine theCvm ){
        cvm = theCvm;
    }

    @Override
    public void selectCoffee(ParentCoffee coffee) {
        System.out.println("Filler text at selectCoffee()");
    }

    @Override
    public void completePayment() {
        System.out.println("Filler text at completePayment()");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Filler text at dispenseProduct()");
    }

    @Override
    public void returnChange() {
        System.out.println("The change is returned to the end-user");
        cvm.setCurrState(cvm.getIdleState());
        cvm.selectedCoffee = null;
        cvm.currentPayment = 0.0;
    }
}
