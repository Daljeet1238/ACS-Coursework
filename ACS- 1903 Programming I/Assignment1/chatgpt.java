import javax.swing.JOptionPane;

public class chatgpt{
    public static void main(String[] args) {
        // Prompt user to enter the 10-digit serial number
        String serialNumber = JOptionPane.showInputDialog("Enter the 10-digit serial number:");

        // Check if the serial number has 10 characters
        if (serialNumber.length() == 10) {
            // Check if the serial number starts with 1 or 2
            char firstDigit = serialNumber.charAt(0);
            if (firstDigit == '1' || firstDigit == '2') {
                // Decode and display the production details via a dialog box
                String location = (firstDigit == '1') ? "USA" : "Mexico";
                String year = serialNumber.substring(1, 3);
                String month = serialNumber.substring(3, 5);
                String day = serialNumber.substring(5, 7);
                String productionSequence = serialNumber.substring(7);

                String message = "Location: " + location + "\nYear: 20" + year + "\nMonth: " + month +
                        "\nDay: " + day + "\nProduction Sequence: " + productionSequence;
                JOptionPane.showMessageDialog(null, message);
            } else {
                // Display if the serial number doesn't start with 1 or 2
                JOptionPane.showMessageDialog(null, "Not a Taylor guitar");
            }
        } else {
            // Display if the serial number is not 10 characters long
            JOptionPane.showMessageDialog(null, "Invalid serial number length");
        }
    }
}
