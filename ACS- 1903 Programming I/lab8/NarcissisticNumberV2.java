/**
 * ACS-1903 Lab8 Q8
 * Daljeet Singh 3169763
 */
import java.util.Scanner;

public class NarcissisticNumberV2{
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter a number:");
        String input = kb.next();
        int answer = 0;
        int length = input.length();
        int originalValue = Integer.parseInt(input);
        
        for(int i = 0; i < length; i++){
            int number = Character.getNumericValue(input.charAt(i));
            double numberPower = Math.pow(number, length);
            answer += numberPower;
            
        }
        
        if(answer == originalValue){
            System.out.println(input + " is a narcissistic number");
        }else{
            System.out.println(input + " is not a narcissistic number");
        }
    }
}