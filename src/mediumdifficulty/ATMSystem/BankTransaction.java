package mediumdifficulty.ATMSystem;

public class BankTransaction {

    private UserAccount ownedUserAccount;
    private Long transactionTime;
    private TransactionType transactionType;
    private double transAmount;

    public BankTransaction( UserAccount theUserAcc, TransactionType theTransType, double amount ){
        ownedUserAccount = theUserAcc;
        transactionType = theTransType;
        transactionTime = System.currentTimeMillis();
        transAmount = amount;
    }

    public void printTransaction(){
           System.out.println("The User account is " + ownedUserAccount.getUserCredential().getUsername()
           + " transaction time is " + transactionTime
                   +" and transaction type is " + transactionType.toString()
                    + " and the amount of transaction is " + transAmount
           + " and the balance is " + ownedUserAccount.getBankBalance() );
    }

}
