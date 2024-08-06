package coffeevendingmachine;

public interface CoffeeVendingMachineState {

    public void selectCoffee(ParentCoffee coffee);

    public void completePayment();

    public void dispenseProduct();

    public void returnChange();
}
