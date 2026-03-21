/**
 * ACS-1903 Lab 3 Question 8
 * Daljeet Singh 3169763
*/
import java.util.Scanner;

public class TeenagerChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first name and age:");
        String name = sc.next();
        int age = sc.nextInt();

        if (age >= 13 && age <= 19) {
            System.out.println(name + " is a teenager.");
        } else {
            System.out.println(name + " is not a teenager.");
        }
    }
}

