/**
 * ACS-1903 Lab 8 Q7
 * Daljeet Singh 3169763
 */
import javax.swing.JOptionPane;

public class SquareRootOfAbsolute{
    public static void main(String[] args){
        String input = JOptionPane.showInputDialog("Enter a number: ");
        double x, y;
        
        //It converts String into double
        x = Double.parseDouble(input);
        
        //Giving the squareroot of the absolute value of x
        y = Math.sqrt(Math.abs(x));
        
        JOptionPane.showMessageDialog(null, "y = " + y);
    }
}