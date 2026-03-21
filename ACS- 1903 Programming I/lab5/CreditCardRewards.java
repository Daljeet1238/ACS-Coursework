/**
 * ACS-1903 Lab 6 Q8
 * Daljeet Singh 3169763
 */
import java.util.Scanner;

public class CreditCardRewards{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rewardsCode;   
        
        System.out.println("Enter a reward number: ");
        rewardsCode = sc.nextInt();
        String response;
        switch(rewardsCode){
            case 0: 
            case 1: response = "Points";
                break;
            case 2: response = "Travel miles"; 
                break;
            case 3: response = "Cash back";
                break;
            default: response = "invalid entry";
        }
        System.out.println("Reward type: " + response);
    }
}