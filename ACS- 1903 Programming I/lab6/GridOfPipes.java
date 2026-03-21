/**
 * ACS-1903 Lab 5 Q7
 * Daljeet Singh 3169763
 */
import java.util.Scanner;

public class GridOfPipes{
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the number of rows then columns");
        int columns = kb.nextInt();
        int rows = kb.nextInt();
        
        for(int i = 0; i <= columns; i++){
            for(int j = 0; j < rows-1; j++){
                System.out.print("| ");
            }
            System.out.println("|");
            
        }
        
    }
}