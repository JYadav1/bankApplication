/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YadavJayAssignment2;

import java.util.Date;


/**
 *
 * @author Jay Yadav
 */
public class CheckingAccount extends Account {
    // global variable 
    private boolean hasDebitCard;
 
    
    /**
     * this method is the constructor for the CheckingAccount class
     * @param inBalance - takes in a double balance
     * @param inAccountNumber - takes in an int account number
     * @param inAccountHolder - takes in Customer account holder
     * @param inInterestRate - takes in double interest Rate
     * @param inHasDebitCard - takes in true or false fo has card
     * @param inDateDeposited - takes in a date value
     * @param inAccType  - takes in a string account type
     */
    public CheckingAccount(double inBalance, int inAccountNumber, Customer inAccountHolder,
        double inInterestRate, boolean inHasDebitCard, Date inDateDeposited, String inAccType) {
        super(inBalance, inAccountNumber, inAccountHolder, inInterestRate, inDateDeposited, inAccType);
        hasDebitCard = inHasDebitCard;
    }
    
    /**
     * this method returns if the user has a card or not 
     * @return hasDebitCard
     */
    public boolean isHasDebitCard() {
        return hasDebitCard;
    }

    /**
     * this method is for debit card
     * @param hasDebitCard 
     */
    public void setHasDebitCard(boolean hasDebitCard) {
        this.hasDebitCard = hasDebitCard;
    }
    
    /**
     * this method takes in deposit for checking class
     * @param amount -  takes in a double amount value
     * @return the balance to the user
     */
    public double deposit(double amount) {
        this.setBalance(this.getBalance() + amount);
        
        return this.getBalance();
    }

    /**
     * this method is a toString method
     * @return the string checking
     */
    @Override
    public String toString() {
        return "Checking";
    }
    
}
