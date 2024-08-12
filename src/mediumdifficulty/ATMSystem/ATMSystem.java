package mediumdifficulty.ATMSystem;

import java.util.Scanner;

public class ATMSystem {

    private static ATMSystem atmSystem;

    BankSystem  bankSystem;
    UserAccount currentUser;

    private ATMSystem( BankSystem theBankSystem ){
        bankSystem = theBankSystem;

    }

    public static ATMSystem getInstance( BankSystem theBankSystem ){
        if( atmSystem == null ){
            atmSystem = new ATMSystem(theBankSystem);
        }

        return atmSystem;
    }

    public void login( String username, String password ){
        currentUser = bankSystem.login( username, password );

        if(currentUser == null ){
            System.out.println("The user is not found");
        }
    }

    public void balanceInquiry(){
        currentUser.balanceInquiry();
    }

    public void withdrawCash(){
        System.out.println("Enter the amount you wish to withdraw");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();

        double currentBalance = currentUser.getBankBalance();

        if( amount < currentBalance ){
            currentUser.updateBalance( -amount, true);
        } else {
            System.out.println("There is no available balance to withdraw this amount. Please reduce.");
        }
    }

    public void depositCash(){
        System.out.println("Enter the amount you wish to deposit");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();

        double currentBalance = currentUser.getBankBalance();

        currentUser.updateBalance( amount, true);

    }
}
