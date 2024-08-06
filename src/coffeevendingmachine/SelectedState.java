package coffeevendingmachine;

public class SelectedState implements CoffeeVendingMachineState{

    CoffeeVendingMachine cvm;

    SelectedState( CoffeeVendingMachine theCvm ){
        cvm = theCvm;
    }

    @Override
    public void selectCoffee(ParentCoffee coffee) {
        System.out.println("Filler text at selectCoffee()");
    }

    @Override
    public void completePayment() {
        System.out.println("The product payment is completed");
        cvm.setCurrState(cvm.getDispenseState());
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Filler text at dispenseProduct()");
    }

    @Override
    public void returnChange() {
        System.out.println("Filler text at returnChange()");
    }
}
