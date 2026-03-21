import java.util.Scanner;

/**
 * 
 *Acs 1903 lab 3 Q-8
 * Daljeet Singh 3169763
 */
public class AverageOfThreeNumbers{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the first number:");
        double firstNumber = sc.nextDouble();
        System.out.println("Enter the first number:");
        double secondNumber = sc.nextDouble();
        System.out.println("Enter the first number:");
        double thirdNumber = sc.nextDouble();
        double addition = firstNumber + secondNumber + thirdNumber;
        double result = addition/3;
        
        System.out.println("The average is " + result); 
    }
}
