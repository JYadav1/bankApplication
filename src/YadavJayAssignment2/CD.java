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
public class CD extends Account {
    //fields
    private double fine;
    private Date stopDate; // Date of maturity
    
    /**
     * this method is a constructor for the CD object 
     * @param inBalance
     * @param inAccountNumber
     * @param inAccountHolder
     * @param inInterestRate
     * @param inFine
     * @param inDateDeposited
     * @param inStopDate
     * @param accType 
     */
    public CD(double inBalance, int inAccountNumber, Customer inAccountHolder, double inInterestRate, double inFine, Date inDateDeposited, Date inStopDate, String accType) {
        super(inBalance, inAccountNumber, inAccountHolder, inInterestRate, inDateDeposited, accType);
        fine = inFine;
        stopDate = inStopDate;
    }

    /**
     * this method gets the fine 
     * @return  double fine value
     */
    public double getFine() {
        return fine;
    }

    /**
     * this method sets the fine 
     * @param fine 
     */
    public void setFine(double fine) {
        this.fine = fine;
    }

    /**
     * this method gets the stope date 
     * @return date
     */
    public Date getStopDate() {
        return stopDate;
    }

    /**
     * this method sets the stop date 
     * @param stopDate 
     */
    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }
    
}
