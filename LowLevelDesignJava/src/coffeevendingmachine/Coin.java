package coffeevendingmachine;

public enum Coin {

    ONE_CENT(0.01),
    TEN_CENT(0.1),
    FIVE_CENT(0.05),
    QUARTER(0.25);

    public double getValue() {
        return value;
    }

    double value;

    Coin( double theValue ){
        value = theValue;
    }
}
