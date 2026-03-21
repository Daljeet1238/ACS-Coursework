/**
 * ACS-2906-001
 * Assignement 1
 * 
 * Student Number: 3169763
 * Student Name: Daljeet Singh
 * Date: 18/10/2025
 */

import java.util.Scanner;

public class NumberSpliter {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");

        // Read user input
        int number = scanner.nextInt();
        scanner.close();

        // Initialize variables to hold the bits
        int y = 0;
        int z = 0;

        boolean alternating = true;

        for(int i = 0; (number >>> i) > 0; i++) {
            // Check if the i-th bit of number is 1
            if(((number >>> i) & 1) == 1){
                if(alternating){
                    // Assign 1 to the i-th bit of y
                    y |= (1 << i);
                }else{
                    // Assign 1 to the i-th bit of z
                    z |= (1 << i);
                }

                alternating = !alternating;
            }
        }

        // Output the results
        System.out.println("y z" );
        System.out.println(y + " " + z);

    }
}