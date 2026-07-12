package com.grinding.BankAccount_Api;

class BankAccount{
     private double balance;
     public double getBalance(){
        return balance;
     }
     public void setBalance(double balance){
        this.balance = balance;
     }
     BankAccount(double initialbalance){
        this.balance = initialbalance;
     }

    public void deposit(double amount){
         setBalance(this.balance + amount);
    }
    public void withdraw(double amount){
        setBalance(this.balance - amount);
    }
//Encapsulation - accessing private data using methods with the help of getters and setters
//Made the variable(balance) private 
//Contructor(used to give multiple values to an object) - provided an initial balance 
// Inheritance(used to use methods of one class into another class)- Implementing savings account
 static class SavingsAccount extends BankAccount{
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
                throw new RuntimeException("A minimum balance of 100 is required in the BankAccount. ");
            }
            else{
                super.withdraw(amount);
            }
        }
}}
//IMPLEMENTED METHOD OVERRIDING 