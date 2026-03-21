/**
 * ACS-2947
 * Daljeet Singh 3169763
 * Lab1
 */

public class Salaried extends Employee {
    private double weeklySalary;

    //non arg constructor
    Salaried(){
        this.weeklySalary = 0.0;
    }

    /**
     * 
     * @param name name of the employee
     * @param sin sin of the employee
     * @param weeklySalary weekly salary of the employee
     */
    Salaried(String name, String sin, double weeklySalary){
        super(name, sin);
        this.weeklySalary = weeklySalary;
    }

    //return the payment amount
    @Override
    public double getPaymentAmount() {
        return weeklySalary;
    }

    //return the employee group
    @Override
    public String getEmployeeGroup() {
        return "Salaried Employee";
    }

    //return toString
    @Override
    public String toString(){
        return "Employee# " + this.getSin() + ": $" + this.getPaymentAmount() + " (" + this.getEmployeeGroup() + ")";
    }

}
