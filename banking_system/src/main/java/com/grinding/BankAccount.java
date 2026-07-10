package com.grinding;

import java.util.Scanner;
class BankAccount{
     private double balance;
     public double getBalance(){
        return balance;
     }
     public void setBalance(double balance){
        this.balance = balance;
     }
     BankAccount(double initialbalance){
        this.balance = initialbalance;""
     }

    public void deposit(double amount){
         setBalance(this.balance + amount);
    }
    public void withdraw(double amount){
        setBalance(this.balance - amount);
    }
    public static void main(String[] args){
        double amount;
        Scanner sc = new Scanner(System.in);
        SavingsAccount BA = new SavingsAccount(500);
        while(true){
        System.out.println("withdraw or deposit or check balance(cb) or interest");
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
        else if(choice.equals("interest")){
            BA.addInterest(); 
            System.out.println("Balance with interest: " + BA.getBalance());
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
//Contructor(used to give multiple values to an object) - provided an initial balance 
// Inheritance(used to use methods of one class into another class)- Implementing savings account
 class SavingsAccount extends BankAccount{
    SavingsAccount(double initialbalance){
        super(initialbalance);
    }
    public void addInterest(){
        double extra;
        extra = (this.getBalance() * (0.05));
        this.setBalance(this.getBalance() + extra);
    }
    @Override
        public void withdraw(double amount){
            if(this.getBalance() - amount <100){
                System.out.println("A minimum balance of 100 is required in the BankAccount");
            }
            else{
                super.withdraw(amount);
            }
        }
}
//IMPLEMENTED METHOD OVERRIDING 