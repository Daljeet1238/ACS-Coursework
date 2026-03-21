/**
 * Assignment 2 Question 4
 * Daljeet Singh 3169763
 */

import java.util.Scanner;

public class EulerEstimate{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number of iterations (1-20):");
        int n = sc.nextInt();
        while(n < 1 || n > 20){
            System.out.println("Invalid input. Please enter a number between 1 to 20 for iterartion.");
            n = sc.nextInt();
        }
        System.out.println("Enter a value for x in e^x:");
        double x = sc.nextDouble();
        
        double factorial = 1.0;
        double estimatedValue = 1.0;
        
        for(int i = 1; i <= n; i++){
            factorial *= i;
            estimatedValue += Math.pow(x , i) / factorial;
        }
        
        double actualValue = Math.exp(x);
        double distance = Math.abs(actualValue - estimatedValue);
        
        System.out.println("Your value of estimate of e^" + x + ": " + estimatedValue);
        System.out.println("Distance from the actual value of e^" + x + ": " + distance);
    }
}
