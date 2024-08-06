package coffeevendingmachine;

public class IdleState implements CoffeeVendingMachineState{

    CoffeeVendingMachine cvm;

    IdleState( CoffeeVendingMachine theCvm ){
        cvm = theCvm;
    }

    @Override
    public void selectCoffee(ParentCoffee coffee) {
        cvm.selectedCoffee = coffee;
        cvm.setCurrState(cvm.getSelectedState());
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
        System.out.println("Filler text at returnChange()");
    }
}
