package files;

public enum Coin {

    QUARTER(0.25),
    FIVE(0.05),
    TEN(0.10),
    CENT(0.01);

    private double value;

    Coin( double amount ){
        value = amount;
    }

    public double getValue(){
        return value;
    }

}
