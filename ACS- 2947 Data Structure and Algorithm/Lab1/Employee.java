/**
 * ACS-2947
 * Daljeet Singh 3169763
 * Lab1
 */

public abstract class Employee implements Payable {
    private String name;
    private String sin;

    //non arg constructor
    Employee(){
        this.name = "unknown";
        this.sin = "unknown";
    }

    /**
     * 
     * @param name name of the employee
     * @param sin sin of the employee
     */
    Employee(String name, String sin){
        this.name = name;
        this.sin = sin;
    }

    //getters
    public String getSin(){
        return sin;
    }

    public String getName(){
        return name;
    }

    //abstract employee group method
    public abstract String getEmployeeGroup();

    //abstract get payment method.
    public abstract double getPaymentAmount();
}
