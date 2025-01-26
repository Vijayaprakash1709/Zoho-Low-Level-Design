import java.util.*;
public class Bank{
    public List<Customer> customers;
    public List<Transaction> transactions;
    public static int transactionId=0;
    public Bank(){
        customers=new ArrayList<Customer>();
        transactions=new ArrayList<Transaction>();
        customers.add(new Customer(1,1234567890,"Bank","Bank@123"));
    }
    public String getPassword(long accNum){
        for(Customer customer:customers){
            if(customer.getAccountNumber()==accNum){
                return customer.getEncryptedPassword();
            }
        }
        return "";

    }
    public boolean deposit(long accNum,double amount){
        for(Customer customer: customers){
            if(customer.getAccountNumber()==accNum){
                customer.setBalance(customer.getBalance()+amount);
                transactions.add(new Transaction(++transactionId,accNum,"Deposit",customer.getBalance(),amount));
                return true;
            }
        }
        return false;
    }
    public boolean Opening(long accNum,double amount){
        for(Customer customer: customers){
            if(customer.getAccountNumber()==accNum){
                customer.setBalance(customer.getBalance()+amount);
                transactions.add(new Transaction(++transactionId,accNum,"Opening",customer.getBalance(),amount));
                return true;
            }
        }
        return false;
    }
    public void transfer(long accNum,long accNum2,double amount){
        for(Customer customer: customers){
            if(customer.getAccountNumber()==accNum){
                transactions.add(new Transaction(++transactionId,accNum,"Transfer to "+accNum2,customer.getBalance(),amount));

            }
            if(customer.getAccountNumber()==accNum2){
                transactions.add(new Transaction(++transactionId,accNum2,"Transfer from "+accNum,customer.getBalance(),amount));

            }
        }
//        transactions.add(new Transaction(++transactionId,accNum,"Transfer",customer.getBalance(),amount));
    }
    public boolean withDraw(long accNum,double amount){
        for(Customer customer: customers){
            if(customer.getAccountNumber()==accNum){
                double bal=0;
                bal=customer.getBalance();
                if(bal-amount<1000){
                    return false;
                }
                else{
                    customer.setBalance(customer.getBalance()-amount);
                    transactions.add(new Transaction(++transactionId,accNum,"WithDraw",customer.getBalance(),amount));
                }
            }
        }
        return true;
    }
    public boolean checkValid(long accNum){
        for(Customer customer: customers){
            if(customer.getAccountNumber()==accNum){
                return true;
            }
        }
        return false;
    }
    public boolean changePassword(long accountn,String pas){
        for(Customer customer: customers){
            if(customer.getAccountNumber()==accountn){
                customer.setEncryptedPassword(pas);
                return true;
            }
        }
        return false;
    }

}