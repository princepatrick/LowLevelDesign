package taskmanagementsystem;

public class UserProfile {

    private String name;
    private String designation;
    private String companyOrSchool;
    private Address address;

    public UserProfile( String theName, String theDesig, String theCompany, Address addr ){
        System.out.println("Creating a new user profile");
        name = theName;
        designation = theDesig;
        companyOrSchool = theCompany;
        address = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCompanyOrSchool() {
        return companyOrSchool;
    }

    public void setCompanyOrSchool(String companyOrSchool) {
        this.companyOrSchool = companyOrSchool;
    }

}
