import java.util.ArrayList;
/**
 * Class representing a pay week
 * Daljeet Singh 3169763
 *
 * @author ACS-2947
 */
public class PayWeek {

    private String weekEnding;              // last day of pay week
    private ArrayList<Payable> payments;    // list of payable items

    /**
     * Constructs a pay week with specified week ending date as String
     *
     * @param weekEnding last day of pay week
     */
    public PayWeek(String weekEnding) {
        this.weekEnding = weekEnding;
        payments = new ArrayList<>();
    }

    /**
     * Adds new payment to the payable list
     *
     * @param payment item
     */
    public void addPayment(Payable p) {
        payments.add(p);
    }

    /**
     * Produces a string representation of a pay week, including all payable
     * items
     *
     * @return textual representation of a pay week
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Payments for the week ending " + weekEnding + ": \n");
        for (Payable p : payments) {
            sb.append(p + "\n");
        }
        return sb.toString();
    }
}
