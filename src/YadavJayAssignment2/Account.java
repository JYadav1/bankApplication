/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YadavJayAssignment2;

import java.util.Date;


/**
 *
 * @author yogeshyadav
 */
public class Account {
    //fields
    private double balance;
    private int accountNumber;
    private Customer accountHolder;
    private double interestRate;
    private Date dateDeposited;
    private String accType;

    public Account(double inBalance, int inAccountNumber, Customer inAccountHolder, double inInterestRate, Date inDateDeposited, String inAccType) {
        balance = inBalance;
        accountNumber = inAccountNumber;
        accountHolder = inAccountHolder;
        interestRate = inInterestRate;
        dateDeposited = inDateDeposited;
        accType = inAccType;
    }

    /**
     * default null constructor for account
     */
    public Account() {
        this(0, 0, null, 0, null, null);
    }
    
    /**
     * this method gets the interest rate
     * @return - interest Rate
     */
    public double getInterestRate() {
        return interestRate;
    }
    
    /**
     * this method sets the InterestRate
     * @param interestRate - this is setting the interest rate
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * this method gets the account holder info
     * @return - accountHolder customer
     */
    public Customer getAccountHolder() {
        return accountHolder;
    }

    /**
     * this method sets the account holder information in accountHolder
     * @param accountHolder - holds the account holder
     */
    public void setAccountHolder(Customer accountHolder) {
        this.accountHolder = accountHolder;
    }

    /**
     * this method gets the balance
     * @return - the balance double
     */
    public double getBalance() {
        return balance;
    }

    /**
     * this method sets the balance
     * @param balance - takes in balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * this method sets the accountNumber 
     * @return the account number integer
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * this method sets your account number 
     * @param accountNumber - takes in the account number
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * this method gets the account type
     * @return account type string
     */
    public String getAccType() {
        return accType;
    }

    /**
     * this method sets the account type
     * @param accType - takes in account type
     */
    public void setAccType(String accType) {
        this.accType = accType;
    }
    
    /**
     * this method deposit money in to account
     * @param amount - takes in double amount value 
     * @return balance to the user
     */
    public double deposit(double amount) {
        this.setBalance(this.getBalance() + amount);
        
        return this.getBalance();
    }
 
   /**
    * this method withdraws money from an account
    * @param amount - takes in double amount from the user
    * @return balance to the user
    */
    public double withdraw(double amount) {
        
        if (this.getBalance() < amount) {
            System.out.println("Error! Insufficent balance.");
        }
        else {

             this.setBalance(this.getBalance() - amount);
        }
            return this.getBalance();
    }
    
   /**
    * this method gets all the account information and narrows it into a string to display
    * @return account info to the suer
    */
    public String getAccountInfo() {
        
        String info = "";
        
        info += "Type: " + this.getAccType();
        info += "   Number: " + this.getAccountNumber();
        info += "   Balance: " + this.getBalance();
        info += "   Interest Rate: " + this.getInterestRate();
        
        return info;
    }

    /**
     * this method is a to string for the account class
     * @return account type 
     */
    @Override
    public String toString() {
        return accType;
    }
}
