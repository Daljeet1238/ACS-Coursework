import java.util.Scanner;

public class ReverseWords1 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter some words:");
        String userInput = kb.nextLine(); // Use nextLine() to read the entire line
        
        while(!userInput.equalsIgnoreCase("stop")){
            int length = userInput.length()-1; // Move this line inside the loop to update the length for each word
            for (int i = length; i >= 0; i--) { // Correct the loop condition and start index
                System.out.print(userInput.charAt(i)); // Print each character of the word in reverse order
            }
            System.out.println(); // Print a newline after reversing each word
            userInput = kb.nextLine(); // Read the next line of input
        }
    }
}
