import java.util.*;

/**
 * Driver class
 *
 * Daljeet Singh 3169763
 * @author ACS-2947
 */
public class Lab1_Driver {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Commissioned("Elon", "1070", 5310.95, 0.23));
        employees.add(new BasePlusCommission("Musk", "7770", 999.00, 4503.48, 0.1));
        employees.add(new Salaried("Donald", "29472", 1927.32));
        employees.add(new Hourly("Trump", "29473", 14.82, 40));

        Invoice i1 = new Invoice("311", 4, 199.98);
        Invoice i2 = new Invoice("312", 12, 25.30);
        PayWeek thisweek = new PayWeek("January 17, 2025");

        // add invoice payments and only commissioned employees to pay week
        thisweek.addPayment(i1);
        thisweek.addPayment(i2);
        for (Employee e : employees) {
            if (e instanceof Commissioned) {
                thisweek.addPayment(e);
            }
        }
        System.out.println(thisweek);
    }
}
