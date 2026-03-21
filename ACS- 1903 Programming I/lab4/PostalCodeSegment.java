/**
 * ACS-1903 Lab 3 Question 7
 * Daljeet Singh 3169763
*/
import javax.swing.JOptionPane;

public class PostalCodeSegment{
    public static void main(String[] args){
        String postalCode = JOptionPane.showInputDialog("Enter a canadian postal code: ") ;
        String postalCodeSegment = postalCode.substring(0,3);
        String result = postalCodeSegment.toUpperCase();
        JOptionPane.showMessageDialog(null, "The FSA segment is " + result);
        
    }
}
