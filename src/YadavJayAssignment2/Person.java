/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YadavJayAssignment2;

import java.util.ArrayList;

/**
 *
 * @author Jay Yadav
 */
public class Person {
    //field
    
    private String name;
    
    private int age;
    
    private int SSN;

    /**
     * this method is a constructor for person
     * @param inName
     * @param inAge
     * @param inSSN 
     */
    public Person(String inName, int inAge, int inSSN) {
        name = inName;
        age = inAge;
        SSN = inSSN;
    }

    
    
    /**
     * this method gets age 
     * @return - integer age
     */
    public int getAge() {
        return age;
    }

    /**
     * this method sets age to the parameter
     * @param age - integer
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * this method gets the SSN
     * @return SSN integer
     */
    public int getSSN() {
        return SSN;
    }

   /**
    * this method sets the SSN value 
    * @param SSN 
    */
    public void setSSN(int SSN) {
        this.SSN = SSN;
    }
   

    /**
     * this method gets the name of the user
     * @return - the string value of name
     */
    public String getName() {
        return name;
    }

    /**
     * this method sets the name 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * this method is a toString 
     * @return a string of person 
     */
    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + ", SSN=" + SSN + '}';
    }

}
