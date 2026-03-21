import java.util.Scanner;

public class NarcissisticNumber{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int inputValue = scanner.nextInt();
        int digitCount = 0;
        int result = 0;
        
        // Calculate the number of digits in the input value
        int tempValue = inputValue;
        while (tempValue > 0) {
            tempValue = tempValue / 10;
            digitCount += 1;
        }
        
        // Calculate the sum of the digits raised to the power of the number of digits
        tempValue = inputValue;
        while (tempValue > 0) {
            int digit = tempValue % 10;
            int power = 1;
            for (int i = 0; i < digitCount; i++) {
                power *= digit;
            }
            result += power;
            tempValue = tempValue / 10;
        }
        System.out.println(result);
    }
}