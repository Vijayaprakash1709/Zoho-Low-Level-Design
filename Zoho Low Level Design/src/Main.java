import java.util.*;
import java.util.stream.Collector;

public class Main {
    public static int customerId=2;
    public static long accountNumber=12345678;
    public static String Encrypt(String password){
        String encryptedPass="";
        for(int i=0;i<password.length();i++){
            encryptedPass=encryptedPass+(password.charAt(i)+'A');
        }
        return encryptedPass;
    }
    public static String Decrypt(String password){
        String decryptedPass="";
        for(int i=0;i<password.length();i++){
            decryptedPass=decryptedPass+(password.charAt(i)-'A');
        }
        return decryptedPass;
    }
    public static boolean checkComplexity(String pass){
        if(pass.length()<6){
            return false;
        }
        int l=0,u=0,n=0;
        for(int i=0;i<pass.length();i++){
            if(pass.charAt(i)>=65 && pass.charAt(i)<=92){
                u++;
            }
            else if(pass.charAt(i)>=97 && pass.charAt(i)<=122){
                l++;
            }
            else if(pass.charAt(i)>=47 && pass.charAt(i)<=58){
                n++;
            }
        }
        if(l>=2 && u>=2 && n>=2){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Banking System");
        Bank bank = new Bank();
        Scanner sc=new Scanner(System.in);
        int n=1;
        while(n==1){
            System.out.println("1.Banker Login \n 2.Customer Login \n 3.Exit");
            int t=sc.nextInt();
            if(t==1){
                System.out.println("Enter Your Account Number");
                long accountNumber=sc.nextLong();
                System.out.println("Enter Your Password");
                sc.nextLine();
                String password=sc.nextLine();
                if(accountNumber==1234567890 && password.equals("Bank@123")){
                    while(true){
                        System.out.println("1.Add Customer  2.View Customer 3.Top N Customers 4.Edit Customer 5.Exit");
                        int choice=sc.nextInt();
                        if(choice==1){

                            ++customerId;
                            ++accountNumber;
                            System.out.println("Enter Customer Name");
                            sc.nextLine();
                            String customerName=sc.nextLine();
                            String password1,password2;
                            while(true) {
                                System.out.println("Enter Password");
                                password1 = sc.nextLine();
                                System.out.println("Re-type Password");
                                password2 = sc.nextLine();
                                if (!password2.equals(password1)) {
                                    System.out.println("Retype Password Correctly or type 1");
                                    int t1=sc.nextInt();
                                    if(t1==1){
                                        break;
                                    }
                                }
                                
                                else{
                                    break;
                                }
                            }
                            String pass=Encrypt(password1);
                            bank.customers.add(new Customer(customerId,accountNumber,customerName,pass));

                            bank.Opening(accountNumber,0);
                            System.out.println("Customer Added Successfully");
                        }
                        else if(choice==2){
                            for(Customer customer:bank.customers){
                                System.out.println("Customer Name : "+customer.getCustomerName());
                      System.out.println("Account Number : "+customer.getAccountNumber());
                                System.out.println("Balance : "+customer.getBalance());
                                System.out.println("Password : "+customer.getEncryptedPassword());
                            }
                        }
                        else if(choice==3){
                            System.out.println("Enter the Number of Customers to Display");
                            int number=sc.nextInt();

                            List<Customer> customers=bank.customers;
                            Collections.sort(customers, new Comparator<Customer>() {
                                @Override
                                public int compare(Customer o1, Customer o2) {
                                    return (int) (o1.getBalance()-o2.getBalance());
                                }
                            });
                            System.out.println("Top "+number+" Customers");
                            int temp=1;
//                            Collections.reverse(customers);
                            for(Customer cust: customers){
                                System.out.println("S.No : "+(temp++));
                                System.out.println("Customer Name : "+cust.getCustomerName()+"   ");
                                System.out.println("Customer Account Number "+cust.getAccountNumber()+"   ");
;                                System.out.println("Customer Balance : "+cust.getBalance());
                            }
                        }
                        else if(choice==4){
                            System.out.println("Enter Customer Account Number :");
                            long accountn=sc.nextLong();
                            if(bank.checkValid(accountn)){
                                System.out.println("Enter New Password");
                                sc.nextLine();
                                String pas=sc.nextLine();
                                if(!checkComplexity(pas)){
                                    System.out.println("Enter 2 Lower Case, 2 Upper Case, 2 Number in password");
                                }
                                else{
                                pas=Encrypt(pas);
                                if(bank.changePassword(accountn,pas)){
                                    System.out.println("Password Changed Successfully");
                                }
                                else{
                                    System.out.println("Wrong Account Number");
                                }}
                            }
                        }
                        else{
                            break;
                        }


                    }
                }
            }
            else if(t==2){
                System.out.println("Customer Login :");
                System.out.println("Enter Your Account Number : ");
                long accNum=sc.nextLong();
                sc.nextLine();
                String pass=bank.getPassword(accNum);
                System.out.println("Enter Your Password :");
                String userPassword=sc.nextLine();
                if(pass.equals(Encrypt(userPassword))) {
                    System.out.println("Login Successful");
                    System.out.println("1.Deposit 2.Withdraw 3.Transfer 4.View Balance 5.View Transactions 6.Exit");
                    int ch=sc.nextInt();
                    switch(ch){
                        case 1:
                            System.out.println("Enter Amount to be Deposited");
                            double amount=sc.nextDouble();
                            if(bank.deposit(accNum,amount)){
                                System.out.println("Amount Deposited Successfully");
                            }
                            else{
                                System.out.println("Invalid Account Number");
                            }
                            break;
                        case 2:
                            System.out.println("Enter Amount to be Withdrawn");
                            double amount1=sc.nextDouble();
                            if(bank.withDraw(accNum,amount1)){
                                System.out.println("Amount Withdrawn Successfully");
                            }
                            else{
                                System.out.println("Invalid Amount Entered , Amount less than minimum balance ");
                            }
                            break;
                        case 3:
                            System.out.println("Enter Account Number to which amount is to be transferred");
                            long accNum1=sc.nextLong();
                            if(bank.checkValid(accNum1)){
                                System.out.println("Enter the amount to be transferred");
                                double amount2=sc.nextDouble();
                                if(bank.withDraw(accNum,amount2)){
                                    bank.deposit(accNum1,amount2);
                                    bank.transfer(accNum,accNum1,amount2);
                                    System.out.println("Amount Transferred Successfully");
                                }
                                else{
                                    System.out.println("Invalid Amount Entered , Amount less than minimum balance ");
                                }
                            }
                            else{
                                System.out.println("Enter Valid Account Number");
                            }
                            break;
                        case 4:
                            for(Customer customer:bank.customers){
                                if(customer.getAccountNumber()==accNum){
                                    System.out.println("Balance : "+customer.getBalance());
                                }
                            }
                            break;
                        case 5:
                            for(Transaction transaction:bank.transactions){
                                if(transaction.getAccountNumber()==accNum){
                                    System.out.println("Transaction Id : "+transaction.getTransactionId());
                                    System.out.println("Transaction Type : "+transaction.getTransactionType());
                                    System.out.println("Amount : "+ transaction.getAmount());
                                    System.out.println("Balance : "+transaction.getBalance());
                                }
                            }
                            break;
                        case 6:
                            break;
                        default:
                            System.out.println("Invalid Choice");

                    }
                }
                else{
                    System.out.println("Invalid Password");
                }

            }
            else{
                n=0;
            }
        }

    }
}