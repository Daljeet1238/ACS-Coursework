/**
 * ACS-2947
 * Daljeet Singh 3169763
 * Lab1
 */

public class BasePlusCommission extends Commissioned {
    private double baseSalary;

    //non argumrent constructor for the class
    BasePlusCommission(){
        super();                //implicit class the super class.
        this.baseSalary = 0.0;
    }

    /**
     * 
     * @param name name of the employee
     * @param sin sin of the employee
     * @param baseSalary base salary of the employee
     * @param grossSales gross sales of the employee
     * @param commissioinRate commission rate of the employee
     */
    BasePlusCommission( String name, String sin, double baseSalary, double grossSales, double commissioinRate){
        super(name, sin, grossSales, commissioinRate);
        this.baseSalary = baseSalary;
    }

    //returns the payment amount
    @Override
    public double getPaymentAmount(){
        return baseSalary + grossSales * commissionRate;
    }

    //returns the employee group
    @Override
    public String getEmployeeGroup(){
        return "Base-plus-commission Employee";
    }

    // returns the toString
    @Override
    public String toString(){
        return "Employee# " + this.getSin() + ": $" + this.getPaymentAmount() + " (" + this.getEmployeeGroup() + ")";
    }

}
