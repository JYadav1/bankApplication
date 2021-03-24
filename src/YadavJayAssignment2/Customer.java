/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YadavJayAssignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jay Yadav
 */
public class Customer extends Person {

    private ArrayList<Account> accounts = new ArrayList<Account>();

    public Customer(String inName, int inAge, int inSSN) {
        super(inName, inAge, inSSN);
    }

    public Customer() {
        super("Elon Musk", 48, 655443223);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    // MAJOR FUNCTION
    /**
     *
     * @param accountType
     * @param initialDeposit
     */
    public void createAccount(String accountType, double initialDeposit) {
        Random randGen = new Random();
        int accountNumber = randGen.nextInt(10000);
        double rate = randGen.nextDouble() * 9 + 1;
        
        
        accountType = accountType.toLowerCase();
        
        if (accountType.contains("check")) {
            CheckingAccount check = new CheckingAccount(initialDeposit, accountNumber, this, rate, true, new Date(), "Checking");
            accounts.add(check);
        } else if (accountType.contains("sav")) {
            SavingAccount save = new SavingAccount(initialDeposit, accountNumber, this, rate, new Date(), "Savings");
            accounts.add(save);
        } else {
            double fine = randGen.nextDouble() * 9 + 1;
            long dateOfMaturity = randGen.nextLong();
            CD deposit = new CD(initialDeposit, accountNumber, this, rate, fine, new Date(), new Date(dateOfMaturity), "CD");
            accounts.add(deposit);
        }
    }

    //MAJOR FUNCTION
    /**
     *
     * @param fromAccountType
     * @param toAccountType
     * @param amount
     */
    public void transferFunds(Account fromAccount, Account toAccount, double amount) {
        if (fromAccount instanceof CD || toAccount instanceof CD) {
            throw new IllegalArgumentException("You cannot transfer funds from a CD account");
        }

        if (fromAccount instanceof CD) {
            if (new Date().compareTo(((CD) fromAccount).getStopDate()) < 0) { // if current date is before CD's date of maturity
                // incurr fine
                double balance = fromAccount.getBalance() - amount - ((CD) (fromAccount)).getFine();
                fromAccount.setBalance(balance);

                toAccount.setBalance(toAccount.getBalance() + amount);
            }
            return;

        } else if (toAccount instanceof CD) {
            throw new IllegalArgumentException("the to account cannot be a CD");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

    }

    // MAJOR FUNCTION
    /**
     *
     */
    public void transaction(Account acc) {
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("1. Deposit\n2. Withdraw");
        int action = input.nextInt();
        
        if (action == 1) {
            System.out.println("How much money do you want to Deposit: ");
            double depositMoney = input.nextDouble();
            acc.deposit(depositMoney);
            System.out.println("$" + depositMoney + " deposited!");
        } else if (action == 2) {
            System.out.println("How much money do you want to Withdraw: ");
            double withdrawMoney = input.nextDouble();
            acc.withdraw(withdrawMoney);
            System.out.println("$" + withdrawMoney + " withdrawn!");
        } else {
            System.out.println("Try Again");
            action = input.nextInt();
        }
//        else if (accType == 2 && choice == 1) {
//            System.out.println("How much money do you want to Deposit" );
//            double depositMoney = input.nextDouble();
//            
//            save.deposit(depositMoney);
//        }
//        else if (accType == 2 && choice == 2) {
//            System.out.println("How much money do you want to Withdraw");
//            double withdrawMoney = input.nextDouble();
//            
//            save.withdraw(withdrawMoney);
//        }     
    }

    // Major function
    /**
     *this method lists all the account the user has created and makes a easy way for the user to select the options
     * @return the choice which is an integer
     */
    public Account chooseAccounts() {
        
        printSummary(); // calss the method
        int[] choices = new int[accounts.size()];// creates an integer array of choice
        // loops through the array
        for (int i = 0; i < choices.length; i++) {
            choices[i] = i + 1;
        }

        System.out.println("\nChoose one of the following: " + Arrays.toString(choices));
        
        // Scanner object created for accepting the user input
        Scanner input = new Scanner(System.in);
        int accType = input.nextInt();

        Account choice = accounts.get(accType - 1);// after the value has been selected it gets the account type from the array

        return choice;
    }

    /**
     * this method is a toString method
     * @return - the string
     */
    @Override
    public String toString() {
        return super.toString() + " Customer{" + "accounts=" + accounts + '}';
    }

    /**
     * this method is a method that prints the accounts
     */
    void printSummary() {
         for (int i = 0; i < accounts.size(); i++) {

            Account temp = accounts.get(i);
            
            String info = "Type: " + temp.getAccType() + 
                  "   Number: " + temp.getAccountNumber() + 
                  "   Balance: " + temp.getBalance() + 
                  "   Interest Rate: " + temp.getInterestRate();
            
            System.out.println((i + 1) + ") " + info);
        }
    }
}
