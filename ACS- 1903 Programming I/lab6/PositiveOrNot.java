/**
 * ACS-1903 Lab 6 Q7
 * Daljeet Singh 3169763
 */
import java.util.Scanner;

public class PositiveOrNot{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String response;
        int number;
    
        do{
            System.out.println("Enter a number: ");
            int answer = sc.nextInt();
            if(answer >= 0){
                System.out.println("positive");            
            }else{
                System.out.println("not positive");
            }
            System.out.println("Would do like to enter another number? (y/n)");
            response = sc.next();
        }while(response.equals("y"));
        System.out.print("Goodbye!");
    }
}
