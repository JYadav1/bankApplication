/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YadavJayAssignment2;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jay Yadav
 */

// 5 MAJOR FUNCTIONS USED IN THE TEST HARNESS
// createAccount - creates an account for the customer
// transferFunds - transfers money from one account to another account type 
// transaction - uses withdraw and deposit methods to transact 
// chooseAccount - displays all the account for the user to pick from 
// processChecks - function that the employee can perform to accept checks from a customer


public class BankApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        
        // Diplays the following to the user
        System.out.println("Hey Welcome to Yadav Bank\n");
        System.out.println("Select from the following options");
        System.out.println("1: Employee");
        System.out.println("2: Customer");
        int userInput = input.nextInt(); // takes in the user input value
        input.nextLine();
        
        // Display information to the user
        System.out.println("What is your name?");
        String name = input.nextLine(); //  local variable for name
        System.out.println("What is your age?");
        int age = input.nextInt(); // local variable for age
        System.out.println("What is your Social Security Number?");
        int SSN = input.nextInt(); // local variable for SSN

        // This case is for Employee access
        if (userInput == 1) {
            
            // Generate a Random number for empyID
            Random randGen = new Random();
            int empyID = randGen.nextInt() * 10000 + 100000;
            // Call the employee constructor
            Employee empy = new Employee(name, age, SSN, empyID);
            System.out.println("Welcome " + name + " you are now an employee of Yadav Bank!!");
            System.out.println("This is your Employee ID and the information you have entered\n" + empy.toString());
            System.out.println("You can now process checks!!! In fact here's a customer who wants their check processed!\n"
                    + "Hit enter to process Elon Musk's check");
            System.in.read();
     
            Customer elon = new Customer(); // create a new customer 
            elon.createAccount("Checking", 999989); // Elon has 999989 (You can change the value if you want)
            System.out.println("Elon Musk's current balance is $" + elon.getAccounts().get(0).getBalance()); // display the current balance
       
            Customer notElon = new Customer(); // create another customer in order to process checks
            notElon.setName("Mike Tyson");
            notElon.createAccount("Checking", 10); // Mike Tyson has 10 dollars (you can change the value if you want)
            System.out.println("Mike Tyson's current balance is $" + notElon.getAccounts().get(0).getBalance());
            
            // try and catch statement in order to handle erro in the check processing
            try {
                empy.processCheck(elon, notElon, 10);
            } catch (Exception e) {
                System.out.println("Looks like Mike Tyson is short on money");
            }
            
            // statements that show the check has been processed and display balance.
            System.out.println("Check processed correctly!");
            System.out.println("Elon Musk's checking account is now $" + elon.getAccounts().get(0).getBalance());
            System.out.println("Mike Tyson's checking account has been depleted to $" + notElon.getAccounts().get(0).getBalance());
        } 
        
        // This is for the actions that an Customer can perform
        else if (userInput == 2) {
            System.out.println("Welcome " + name + " to Yadav Bank");
     
            Customer cust = new Customer(name, age, SSN); // call the customer constructor
            System.out.println("Would you like to create an account with an initial deposit?(Y/N)");
            char response = input.next().toLowerCase().charAt(0); // stores the users response in a character 
    
            if (response == 'y' || response == 'Y') {
                System.out.println("what kind of account would you like to create? (CD, Savings, Checking) TYPE AS STATED");
                input.nextLine();
                String accType = input.nextLine().toLowerCase();
                
                System.out.println("How much would you like to put in");
                double amount = input.nextDouble(); // enter an intial deposit value
               
                cust.createAccount(accType, amount); // create the customer account with given information
                System.out.println("You have succesfully created an account in Yadav Bank");
                
                // This loop checks until user choice hits 4
                int choice = 0;
                while (choice != 4) {
                    System.out.println("Hey " + name + " now you can withdraw, deposit and transfer money to accounts");
                    
                    // shows the menu, so that the customer can select given optinos
                    displayMenu(); // calls the display menu method
                    choice = input.nextInt(); // scanner for entering user choice value
                    
                    // checks user choice based on the users input value
                    if (choice == 1) {
                        Account c = cust.chooseAccounts();
                        cust.transaction(c); // calls the transaction method with account c
                    } else if (choice == 2) {
                        // checks if customer account is 2 or more in order to continue with choice 3
                        if (cust.getAccounts().size() < 2) {
                            cust.chooseAccounts(); // calls the choseAccount method
                            System.out.println("You first need to create another account\n");
                            continue; // loop goes on 
                        }
                        // continues choice 3 after the creation of two or more accounts
                        System.out.println("What account do you want to transfer from?");
                        Account fromAccount = cust.chooseAccounts(); // creating a fromAccount to store in chooseAccount
                        System.out.println("What Account do you want to transfer to?");
                        Account toAccount = cust.chooseAccounts(); // creating a toAccount to store in chosseAccount
                        System.out.println("How much would you like to transfer to your " + toAccount.getAccType() + "?");
                        cust.transferFunds(fromAccount, toAccount, input.nextDouble()); // calls the customer method for transfering funds
                        cust.printSummary(); // calls the print summary method
                    } else if(choice == 3) {
                        System.out.println("what kind of account would you like to create? (CD, Savings, Checking)");
                        input.nextLine();
                        String accTyp = input.nextLine().toLowerCase(); // create a scanner to store accTyp
                
                        // goes in for choice 3 which is creating another account
                        System.out.println("How much would you like to put in");
                        double a = input.nextDouble(); // 
                        cust.createAccount(accTyp,a);// calls the create account
                        System.out.println("You have sucssefully created another account in Yadav Bank");
                        cust.getAccounts().size();
                        System.out.println("Here is your account information " + cust.toString());
                    } else if (choice == 4) {
                        break;
                    }
                }
            }
        }

    }

    /**
     * Displays the startup menu
     */
    public static void displayMenu() {
        System.out.println("1: withdraw/deposit");
        System.out.println("2: Transfer funds between accounts");
        System.out.println("3: Create another account");
        System.out.println("4: QUIT");
    }

}
