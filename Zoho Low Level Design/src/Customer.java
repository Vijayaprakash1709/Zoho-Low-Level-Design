public class Customer {
    private int customerId;
    private long accountNumber;
    private String customerName;
    private double balance=10000;
    private String encryptedPassword;
    private String[] passwordHistory=new String[3];
    public Customer(int customerId,long AccountNumber,String CustomerName,String encryptedPassword){
        this.accountNumber=AccountNumber;
        this.customerName=CustomerName;
        this.encryptedPassword=encryptedPassword;
        this.customerId=customerId;
    }
    public long getAccountNumber(){
        return accountNumber;
    }
    public String getCustomerName(){
        return customerName;
    }
    public double getBalance(){
        return balance;
    }
    public String getEncryptedPassword(){
        return encryptedPassword;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
    public void setEncryptedPassword(String encryptedPassword){
        this.encryptedPassword=encryptedPassword;
    }


}
