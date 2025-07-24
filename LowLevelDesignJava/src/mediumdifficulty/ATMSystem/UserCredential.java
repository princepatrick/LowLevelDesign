package mediumdifficulty.ATMSystem;

public class UserCredential {


    private String username;
    private String password;

    public UserCredential( String theUsername, String thePassword ){
        username = theUsername;
        password = thePassword;
    }

    public boolean validateCredential( String enteredUserName, String enteredPassword ){
        if( username.equals(enteredUserName) && password.equals(enteredPassword) ){
            return true;
        }

        return false;
    }

    public String getUsername() {
        return username;
    }


}
