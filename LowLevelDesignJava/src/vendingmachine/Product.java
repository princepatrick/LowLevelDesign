package vendingmachine;

public class Product {

    String name;
    double price;

    public Product( String theName, double thePrice ){
        System.out.println("The product details are Name: " + theName + " and Price: " + thePrice );
        name = theName;
        price = thePrice;
    }

    public double getProductPrice(){
        return price;
    }

    public void updateProductPrice( double theNewPrice){
        System.out.println( "The product's price is updated to " + theNewPrice );
        price = theNewPrice;
    }

    public String getName(){
        return name;
    }

    public void updateName( String theNewName ){
        System.out.println( "The product's name is updated to " + theNewName );
        name = theNewName;
    }

}
