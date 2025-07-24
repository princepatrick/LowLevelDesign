package vendingmachine;

public enum Note {

    ONE(1),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100);

    private int value;

    Note( int amount ){
        value = amount;
    }

    public int getValue(){
        return value;
    }


}
