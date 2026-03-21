/**
 * ACS-2947
 * Daljeet Singh 3169763
 * Lab 1
 * Class representing a Commissioned Employee
 *
 * @author ACS-2947
 */
public class Commissioned extends Employee {

    protected double grossSales;        // gross sales
    protected double commissionRate;    // rate of commission

    /**
     * Constructs a commissioned employee with specified name, sin, gross sales
     * and commission rate
     *
     * @param name name of employee
     * @param sin social insurance number of employee
     * @param sales gross sales made by employee
     * @param rate commission rate of employee
     */
    public Commissioned(String name, String sin,
            double sales, double rate) {
        super(name, sin);
        this.grossSales = sales;
        this.commissionRate = rate;
    }

    /**
     * Constructs a default commissioned employee
     */
    public Commissioned() {                // *note: implicit call to super()
        this.grossSales = 0.0;
        this.commissionRate = 0.0;
    }

    /**
     * Gets the commissioned employee's amount of pay
     *
     * @return returns the payment amount of this commissioned employee
     */
    @Override
    public double getPaymentAmount() {
        return commissionRate * grossSales;
    }

    //returns the employee group
    @Override
    public String getEmployeeGroup() {
        return "Commissioned Employee";
    }

    //returns the toString of the class.
    @Override
    public String toString(){
        return "Employee# " + this.getSin() + ": $" + this.getPaymentAmount() + " (" + this.getEmployeeGroup() + ")";
    }
}
