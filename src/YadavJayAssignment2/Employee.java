/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YadavJayAssignment2;

/**
 *
 * @author Jay Yadav
 */
public class Employee extends Person{
    // fields
    private int empyID;
    private int hoursWorkedPerWeek;
    private double hourlyRate;
    
    /**
     * this method is the constructor for the employee
     * @param inName
     * @param inAge
     * @param inSSN
     * @param inEmpyID 
     */
    public Employee(String inName, int inAge, int inSSN, int inEmpyID) {
        super(inName, inAge, inSSN);
        empyID = inEmpyID;
    }

    /**
     * this method gets the employee id
     * @return empyID
     */
    public int getEmpyID() {
        return empyID;
    }

    /**
     * this method sets the employee id
     * @param empyID 
     */
    public void setEmpyID(int empyID) {
        this.empyID = empyID;
    }

    /**
     * this method gets the employee hours
     * @return int hours worked
     */
    public int getHoursWorkedPerWeek() {
        return hoursWorkedPerWeek;
    }

  /**
   * this method sets the hours worked
   * @param hoursWorkedPerWeek 
   */
    public void setHoursWorkedPerWeek(int hoursWorkedPerWeek) {
        this.hoursWorkedPerWeek = hoursWorkedPerWeek;
    }

    /**
     * this method gets the hourly rate 
     * @return double hourly Rate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * this method sets the hourly rate
     * @param hourlyRate 
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * this method is a toString method
     * @return 
     */
    @Override
    public String toString() {
        return  super.toString() + "Employee{" + "empyID=" + empyID + '}';
    }
    
    
    
    
    
    /**
     * MAJOR FUNCTION.
     * @param toCust Customer who wants check processed
     * @param fromCust Customer who signed check
     * @param amount dollars on check to be added to customer's account
     */
    public void processCheck(Customer toCust, Customer fromCust, double amount) throws Exception {
        boolean hasCheckingAccount = false;
        Account toCustCheckingAcc = new Account();
        Account fromCustCheckingAcc = new Account();
        
        for (Account acc : toCust.getAccounts()) {
            if (acc instanceof CheckingAccount) {
                hasCheckingAccount = true;
                toCustCheckingAcc = acc;
                break;
            }
        }
        
        if (!hasCheckingAccount) {
            throw new IllegalArgumentException("Customer must first create a checking account");
        }
        
        hasCheckingAccount = false;
        for (Account acc : fromCust.getAccounts()) {
            if (acc instanceof CheckingAccount) {
                hasCheckingAccount = true;
                fromCustCheckingAcc = acc;
                break;
            }
        }
        
        if (!hasCheckingAccount) {
            throw new IllegalArgumentException("Customer must first create a checking account");
        }
        
        if (fromCustCheckingAcc.getBalance() < amount) {
            throw new Exception("Signer does not have enough funds!");
        }
        
        fromCustCheckingAcc.withdraw(amount);
        toCustCheckingAcc.deposit(amount);
    }
    
    
    
}
