package mediumdifficulty.ATMSystem;

public class ATMSystemDemoRun {

    public static void run(){
        BankSystem bankSystem = BankSystem.getInstance();
        ATMSystem atmSystem = ATMSystem.getInstance( bankSystem );

        bankSystem.addUserAccount( "User 1", "Password 1", 10000000 );
        bankSystem.addUserAccount( "User 2", "Password 2", 1000000 );
        bankSystem.addUserAccount( "User 3", "Password 3", 10000 );
        bankSystem.addUserAccount( "User 4", "Password 4", 10000 );

        atmSystem.login("User 1", "Password 1");

        atmSystem.balanceInquiry();

        atmSystem.withdrawCash();

        atmSystem.depositCash();

        atmSystem.balanceInquiry();
    }




}
