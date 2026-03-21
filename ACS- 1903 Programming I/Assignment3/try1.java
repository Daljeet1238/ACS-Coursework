import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

public class try1{
    public static void main(String[] args) {
        ArrayList<Integer> winningLotteryNumbers = new ArrayList<>();
        Random rand = new Random();
        while (winningLotteryNumbers.size() < 6) {
            int number = rand.nextInt(49) + 1;
            if (!winningLotteryNumbers.contains(number)) {
                winningLotteryNumbers.add(number);
            }
        }
        Collections.sort(winningLotteryNumbers);

        ArrayList<Integer> userTicket = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your 6 ticket numbers:");
        for (int i = 0; i < 6; i++) {
            int number = sc.nextInt();
            userTicket.add(number);
        }

        int matches = checkTicket(winningLotteryNumbers, userTicket);
        displayResult(matches);
    }

    public static int checkTicket(ArrayList<Integer> winningLotteryNumbers, ArrayList<Integer> userTicket) {
        int matches = 0;
        for (int number : userTicket) {
            if (winningLotteryNumbers.contains(number)) {
                matches++;
            }
        }
        return matches;
    }

    public static void displayResult(int matches) {
        if (matches >= 3) {
            System.out.println("You win! " + matches + " numbers match");
        } else {
            System.out.println("You do not have at least 3 matching numbers");
        }
    }
}
