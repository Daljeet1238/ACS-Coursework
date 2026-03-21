/**
 * ACS-2947
 * Daljeet Singh 3169763
 * Lab1
 */

public class Hourly extends Employee {
    private double wage;
    private double hours;

    //Non Argument Constructor
    public Hourly(){
        super();
        this.wage = 0.0;
        this.hours = 0.0;
    }

    /**
     * 
     * @param name name of the employee
     * @param sin sin of the employee
     * @param wage wage of the employee
     * @param hours hours of the employee
     * full argument constructor
     */
    public Hourly(String name, String sin, double wage, double hours){
        super(name, sin);
        this.wage = wage;
        this.hours = hours;
    }

    //returns the employee group
    @Override
    public String getEmployeeGroup() {
        return "Hourly Employee";
    }

    //return the payment amount
    @Override
    public double getPaymentAmount() {
        return wage * hours;
    }

    //retiurn the toString of the class.
    @Override
    public String toString(){
        return "Employee # " + this.getSin() + ": $" + this.getPaymentAmount() + " (" + this.getEmployeeGroup() + ")";
    }
}
