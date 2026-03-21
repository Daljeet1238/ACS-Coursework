/**
 * ACS-1903 Lab 5 Q8
 * Daljeet Singh 3169763
 */
import java.util.Scanner;

public class ReverseWords{
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter some words:");
        String userInput = kb.next();
        
        while(!userInput.equalsIgnoreCase("stop")){
            for (int i = userInput.length()-1; i>=0; i--){
                System.out.print(userInput.charAt(i));
            }
            System.out.print(" ");
            userInput = kb.next();
        }
        
        
    }
}