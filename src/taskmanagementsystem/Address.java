package taskmanagementsystem;

public class Address {

    String addrLine1;
    String addrLine2;
    String city;
    String state;
    int zipcode;

    public Address( String addr1, String addr2, String theCity, String theState, int postalCode ){
        System.out.println("Creating a new address at Address class");
        addrLine1 = addr1;
        addrLine2 = addr2;
        city = theCity;
        state = theState;
        zipcode = postalCode;
    }

    public String getAddrLine1() {
        return addrLine1;
    }

    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }

    public String getAddrLine2() {
        return addrLine2;
    }

    public void setAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
