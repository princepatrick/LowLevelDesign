package mediumdifficulty.ATMSystem;

import java.util.ArrayList;
import java.util.List;

public class BankSystem {

    private static BankSystem bankSystem;

    private List<UserAccount> userAccountList;

    private BankSystem(){
        userAccountList = new ArrayList<>();
    }

    public static BankSystem getInstance(){
        if( bankSystem == null ){
            bankSystem = new BankSystem();
        }

        return bankSystem;
    }

    public void addUserAccount( String username, String password, double initialAmount ){
        UserAccount userAccount = new UserAccount( username, password, initialAmount );
        userAccount.postCreationProcess();
        userAccountList.add(userAccount);
    }

    public UserAccount login( String username, String password ){

        for( UserAccount userAcc : userAccountList ){
            if( userAcc.getUserCredential().validateCredential( username, password ) ){
                return userAcc;
            }
        }

        return null;
    }

}
