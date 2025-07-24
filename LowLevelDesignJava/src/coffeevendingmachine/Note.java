package coffeevendingmachine;

public enum Note {

    ONE(1),
    TEN(10),
    FIVE(5),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100);

    public double getValue() {
        return value;
    }

    double value;

    Note( double theValue){
        value = theValue;
    }

}


