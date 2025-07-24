package coffeevendingmachine;

public class DispenseState implements CoffeeVendingMachineState{

    CoffeeVendingMachine cvm;

    DispenseState( CoffeeVendingMachine theCvm ){
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
        System.out.println("The product is dispensed");
        cvm.setCurrState(cvm.getReturnChangeState());
    }

    @Override
    public void returnChange() {
        System.out.println("Filler text at returnChange()");
    }
}
