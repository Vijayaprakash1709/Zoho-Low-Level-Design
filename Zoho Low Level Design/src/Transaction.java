import java.util.*;
public class Transaction {
    private int transactionId;
    private long accountNumber;
    private String transactionType;
    private double balance;
    private double amount;
    public Transaction(int transactionId,long accountNumber,String transactionType,double balance,double amount){
        this.transactionId=transactionId;
        this.accountNumber=accountNumber;
        this.transactionType=transactionType;
        this.balance=balance;
        this.amount=amount;
    }
    public long getAccountNumber(){
        return accountNumber;
    }
    public String getTransactionType(){
        return transactionType;
    }
    public double getBalance(){
        return balance;
    }
    public double getAmount(){
        return amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

}
