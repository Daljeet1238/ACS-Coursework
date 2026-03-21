/**
 * ACS-2947
 * Daljeet Singh 3169763
 * Lab 1
 * Class representing an Invoice
 *
 * @author ACS-2947
 */
public class Invoice implements Payable {

    private String invoiceNumber;   // invoice number
    private int quantity;           // quantity of items 
    private double pricePerItem;    // price per item

    /**
     * Constructs an invoice with specified invoice number, quantity and price
     * per item
     *
     * @param number invoice number
     * @param count quantity of items
     * @param price price per item
     */
    public Invoice(String number, int count,
            double price) {
        invoiceNumber = number;
        quantity = count;
        pricePerItem = price;
    }

    /**
     * Constructs an invoice with default values
     */
    public Invoice() {               // use of this keyword to call constructor
        this("unknown", 0, 0.0);
    }

    /**
     * Gets the payment amount of the invoice
     *
     * @return returns the invoice payment amount
     */
    public double getPaymentAmount() {
        return quantity * pricePerItem;
    }

    /**
     * Produces a string representation of an invoice
     *
     * @return textual representation of the invoice
     */
    public String toString() {
        return "Invoice# " + invoiceNumber + ": $" + String.format("%.2f", getPaymentAmount());
    }

}
