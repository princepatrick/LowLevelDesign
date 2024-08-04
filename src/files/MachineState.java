package files;

public interface MachineState {

    //Only in Default state - once product is selected - move to the readyToReceiveCash state
    public void addProduct( Product product);

    //Only in ReadyToReceiveCashAndDispense state - once the cash is entered and dispense product button is clicked - then move to ProvideChange state
    public void insertCoin( Coin coin);

    public void insertNote( Note note);

    public void getProduct();

    //Only in ProvideChange state - the cash provided is calculated and the product price is deducted
    public void getRemainingChange();

}
