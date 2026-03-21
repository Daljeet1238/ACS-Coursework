/**
 * Write a description of class Driver here.
 * Daljeet Singh 3169763
 * 5th November, 2024
 */

import java.time.LocalDate;
import java.util.Arrays;

public class PrimeMinister implements Comparable<PrimeMinister>{

    private String firstName;
    private String lastName;
    private LocalDate[] electedDate;
    
    public PrimeMinister(){
        this.firstName = "unknown";
        this.lastName = "unknown";
        this.electedDate = new LocalDate[]{};
    }

    public PrimeMinister(String firstName, String lastName, LocalDate[] electedDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.electedDate = electedDate;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstname){
        this.firstName = firstname;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public LocalDate[] getElectedDate(){
        return electedDate;
    }

    public void setElectedDate(LocalDate[] electedDate){
        this.electedDate = electedDate;
    }

    public String getYear(){
        return Arrays.toString(getElectedDate()).substring(0,4);
    }

    public int compareTo(PrimeMinister pm) {
        return this.electedDate[0].compareTo(pm.electedDate[0]);
    }

    @Override
    public String toString(){
        return firstName + " " +  lastName + ": " + Arrays.toString(electedDate);
    }

    public LocalDate getRecent(){
        return electedDate[electedDate.length - 1];
    }
}