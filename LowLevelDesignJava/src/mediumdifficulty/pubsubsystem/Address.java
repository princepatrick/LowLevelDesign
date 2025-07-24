package mediumdifficulty.pubsubsystem;

public class Address {

    String streetName1;
    String streetName2;
    String cityName;
    String stateName;
    int zipcode;

    public Address( String theStreet1, String theStreet2, String city, String state, int postcode ){
        System.out.println("Creating the Address");
        streetName1 = theStreet1;
        streetName2 = theStreet2;
        cityName = city;
        stateName = state;
        zipcode = postcode;
    }
}
