import java.util.Scanner;

public class NarcissisticNumberV2 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter a number:");
        int value = kb.nextInt();
        int length = 0;
        int output = 0;
        
        // Calculate the number of digits in the input value
        int temp = value;
        while (temp > 0) {
            temp = temp / 10;
            length += 1;
        }
        
        // Calculate the sum of the digits raised to the power of the number of digits
        temp = value;
        while (temp > 0) {
            int digit = temp % 10;
            int power = 1;
            for (int i = 0; i < length; i++) {
                power *= digit;
            }
            output += power;
            temp = temp / 10;
        }
        System.out.println(output);
    }
}