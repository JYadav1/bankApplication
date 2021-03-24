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
public class SavingAccount extends Account{
    
    /**
     * this method is the constructor 
     * @param inBalance
     * @param inAccountNumber
     * @param inAccountHolder
     * @param inInterestRate
     * @param inDateDeposited
     * @param accType 
     */
    public SavingAccount(double inBalance, int inAccountNumber, Customer inAccountHolder, double inInterestRate, Date inDateDeposited, String accType) {
        super(inBalance, inAccountNumber, inAccountHolder, inInterestRate, inDateDeposited, accType);
    }
    
    /**
     * this method withdraws money 
     * @param amount
     * @return the double balance 
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
     * this method deposit money into the account 
     * @param amount
     * @return double balance to the user
     */
     public double deposit(double amount) {
        this.setBalance(this.getBalance() + amount);
        
        return this.getBalance();
    }
    
}
