import java.util.Scanner;
class BankAccount{
     private double balance;
     public double getBalance(){
        return balance;
     }
     public void setBalance(double balance){
        this.balance = balance;
     }
}
    public void deposit(double amount){
        BankAccount BA = new BankAccount();

         BA.setBalance(balance + amount);
    }
    public void withdraw(double amount){
        BankAccount BA = new BankAccount();
        BA.setBalance(balance - amount);
    }
    public static void main(String[] args){
        double amount;
        Scanner sc = new Scanner(System.in);
        BankAccount BA = new BankAccount();
        while(true){
        System.out.println("withdraw or deposit or check balance(cb)");
        String choice = sc.nextLine();
        if(choice.equals("cb")){
            System.out.println("Balance:" + BA.getBalance()); 
        }
        else if(choice.equals ("deposit")){
        System.out.println("Enter amount to deposit: ");
        amount = sc.nextDouble();
        sc.nextLine();
        BA.deposit(amount);
        System.out.println("Balance: " + BA.getBalance());
        }
        else if(choice.equals("withdraw")){
        System.out.println("Enter amount to withdraw: ");
        amount = sc.nextDouble();
        sc.nextLine();
        BA.withdraw(amount);
        }
        else{
            System.out.println("Invalid Choice");
        }
    
        System.out.println("Do you want to continue (y/n)");
        String continuechoice = sc.nextLine();
        System.out.println("CHOICE ENTRY: [" + continuechoice + "]");
        if(continuechoice.equals("y")){
            continue;
        }
        else if(continuechoice.equals("n")){
            System.out.println("Thanks for using The Banking System ;) ");
            break;
        }
        else{
            System.out.println("Please enter only (y/n)");
        }
        
    }
    sc.close();
}
}
//Encapsulation - accessing private data using methods with the help of getters and setters
//Made the variable(balance) private 