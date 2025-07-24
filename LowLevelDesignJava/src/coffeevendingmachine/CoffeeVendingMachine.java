package coffeevendingmachine;

import java.util.ArrayList;

public class CoffeeVendingMachine {

    ArrayList<ParentCoffee> menuList;
    IdleState idleState = new IdleState(this);
    DispenseState dispenseState = new DispenseState(this);
    ReturnChangeState returnChangeState = new ReturnChangeState(this);
    SelectedState selectedState = new SelectedState(this);
    ParentCoffee selectedCoffee = null;

    CoffeeVendingMachineState currState;
    double currentPayment;

    public static CoffeeVendingMachine cvm;

    public CoffeeVendingMachine(){
        menuList = new ArrayList<ParentCoffee>();
        currState = idleState;
        currentPayment = 0.0;
    }

    public void addCoffee( ParentCoffee coffee ){
        menuList.add(coffee);
    }

    public static CoffeeVendingMachine getInstance(){
        if( cvm == null ){
            cvm = new CoffeeVendingMachine();
        }

        return cvm;
    }

    public ArrayList<ParentCoffee> getMenu(){
        return menuList;
    }

    public ParentCoffee search( ParentCoffee  coffee ){
        System.out.println("The expected coffee is searched using search()");

        for( ParentCoffee coffeeCup : menuList ){
            if( coffeeCup == coffee && coffeeCup.numOfCups > 0 ){
                return coffee;
            }
        }

        return null;
    }

    public void buyCoffee( ParentCoffee coffee ){
        System.out.println("The coffee is added to cart in buyCoffee()");
        idleState.selectCoffee(coffee);
    }

    public void setIdleState(IdleState idleState) {
        this.idleState = idleState;
    }

    public void setDispenseState(DispenseState dispenseState) {
        this.dispenseState = dispenseState;
    }

    public void setReturnChangeState(ReturnChangeState returnChangeState) {
        this.returnChangeState = returnChangeState;
    }

    public void setSelectedState(SelectedState selectedState) {
        System.out.println("Getting the setSelectedState() state");
        this.selectedState = selectedState;
    }

    public DispenseState getDispenseState() {
        System.out.println("Getting the getDispenseState() state");
        return dispenseState;
    }

    public ReturnChangeState getReturnChangeState() {
        System.out.println("Getting the getReturnChangeState() state");
        return returnChangeState;
    }

    public SelectedState getSelectedState() {
        System.out.println("Getting the getSelectedState() state");
        return selectedState;
    }

    public IdleState getIdleState() {
        System.out.println("Getting the getIdleState state");
        return idleState;
    }

    public CoffeeVendingMachineState getCurrState() {
        System.out.println("Getting the getCurrState state");
        return currState;
    }

    public void setCurrState(CoffeeVendingMachineState currState) {
        System.out.println("Changing the current state");
        this.currState = currState;
    }

    public void insertCoin( Coin coin ){
        System.out.println("Inserting coin of value " + coin.getValue());
        double value = coin.getValue();
        currentPayment += value;

        if( currentPayment >= selectedCoffee.getPrice() ){
            cvm.currState.completePayment();
        }
    }

    public void insertNote( Note note ){
        System.out.println("Inserting note of value " + note.getValue());
        double value = note.getValue();
        currentPayment += value;

        if( currentPayment >= selectedCoffee.getPrice() ){
            cvm.currState.completePayment();
        }
    }

    public void dispenseProduct(){
        System.out.println("The product is dispensed in dispenseProduct()");
        for( ParentCoffee coffee : menuList ){
            if( selectedCoffee == coffee ){
                coffee.setNumOfCups(coffee.getNumOfCups()-1);
            }
            cvm.currState.dispenseProduct();
            break;
        }
    }

    public void returnChange(){
        double remChange = currentPayment - selectedCoffee.getPrice();

        System.out.println("The remaining change is " + remChange);

        cvm.currState.returnChange();
    }



}
