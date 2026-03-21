import java.util.Scanner;

/**
 * ACS -1903 Lab 4 Question 8
 * Daljeet Singh 3169763
 */
public class SumOfFirstN{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = sc.nextInt();
        int sum = 0;
        
        for(int i = 1; i <=n; i++){
            sum = sum + i;
        }
        System.out.print("The sum of first "+ n +" is " + sum);
    }
}