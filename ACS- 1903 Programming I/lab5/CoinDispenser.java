/**
 * Daljeet Singh
 * 3169763
 */
import java.util.Scanner;
public class CoinDispenser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of pennies: ");
        int amount = sc.nextInt();
        int amount1 = 0;

        if (amount % 5 >= 3) {
            amount1 = amount + (5 - amount % 5);
            System.out.println("Coin dispensed (" + amount1 + " cents) :");
        } else if (amount % 5 < 3) {
            amount1 = amount - amount % 5;
            System.out.println("Coin dispensed (" + amount1 + " cents) :");
        } else {
            amount1 = amount;
            System.out.println("Error :(");
        }

        int toonies, loonies, quarters, dimes, nickels;
        int rem1, rem2, rem3, rem4;

        toonies = amount1 / 200;
        rem1 = amount1 % 200;

        loonies = rem1 / 100;
        rem2 = rem1 % 100;

        quarters = rem2 / 25;
        rem3 = rem2 % 25;

        dimes = rem3 / 10;
        rem4 = rem3 % 10;

        nickels = rem4 / 5;

        if (toonies > 0) {
            System.out.println("Toonies: " + toonies);
        }
        if (loonies > 0) {
            System.out.println("Loonies: " + loonies);
        }
        if (quarters > 0) {
            System.out.println("Quarters: " + quarters);
        }
        if (dimes > 0) {
            System.out.println("Dimes: " + dimes);
        }
        if(nickels > 0){
            System.out.println("Nickels: " + nickels);
        }
    }
}
