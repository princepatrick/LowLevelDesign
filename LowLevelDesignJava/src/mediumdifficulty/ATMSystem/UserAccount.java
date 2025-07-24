package mediumdifficulty.ATMSystem;

import java.util.ArrayList;
import java.util.List;

public class UserAccount {

    private UserCredential userCredential;
    private double bankBalance;
    List<BankTransaction> bankTransactionList;

    public UserAccount( String userName, String passWord, double intialAmount ){
        userCredential = new UserCredential( userName, passWord );
        bankBalance = intialAmount;
        bankTransactionList = new ArrayList<>();
    }

    public void postCreationProcess(){
        BankTransaction bankTransaction = new BankTransaction( this, TransactionType.ACCOUNT_CREATION, bankBalance );
        bankTransaction.printTransaction();
        bankTransactionList.add( bankTransaction );
    }

    public UserCredential getUserCredential() {
        return userCredential;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }

    public void balanceInquiry(){
        System.out.println("The user: " + userCredential.getUsername()
                + " has the following bank balance: " + bankBalance );

        System.out.println("The recent 5 transactiosn are: " );
        int i = bankTransactionList.size() - 5;

        if( i < 0 ) i = 0;

        for( ; i < bankTransactionList.size() ; i++ ){
            BankTransaction bankTransaction = bankTransactionList.get(i);
            bankTransaction.printTransaction();
        }

        BankTransaction bankTransaction = new BankTransaction( this, TransactionType.BALANCE_INQUIRY, 0 );
        bankTransactionList.add(bankTransaction);

        System.out.println("The most recent registered transaction is ");
        bankTransaction.printTransaction();
    }

    public boolean validateCredentials( String username, String password ){
        return userCredential.validateCredential(username, password );
    }

    public void updateBalance( double amountChange, boolean isWithdrawal ){
        TransactionType transType = isWithdrawal ? TransactionType.CASH_WITHDRAWAL : TransactionType.CASH_DEPOSIT;
        BankTransaction bankTransaction = new BankTransaction( this, transType, amountChange );
        bankTransactionList.add(bankTransaction);
        bankBalance += amountChange;

        System.out.println("The most recent registered transaction is ");
        bankTransaction.printTransaction();
    }


}
