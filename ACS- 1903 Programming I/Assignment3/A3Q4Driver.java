/**
 * ACS-1903 Assignment 3 Question 4
 * Sample Driver
 */

import java.util.Scanner;
import java.util.ArrayList;
public class A3Q4Driver{
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        
        // generate tickets for this Saturday's draw
        Lottery lotto = new Lottery("April 6 2024");
        for (int i=1; i<100000; i++){
            LotteryTicket quickPick = new LotteryTicket();
            playLottery(lotto, quickPick);
        }
        
        // user picks a set of numbers for Saturday's draw
        System.out.println("Enter 6 numbers between 1 and 49:");
        LotteryTicket ticket = new LotteryTicket(kb.nextInt(), kb.nextInt(), kb.nextInt(), kb.nextInt(), kb.nextInt(), kb.nextInt());
        playLottery(lotto, ticket);
        
        // winning numbers are drawn
        lotto.generateWinningNumbers();
        
        // check user's ticket
        lotto.checkTicket(ticket);
        
        System.out.println("\n-----------------------------------------------\n");
        
        // display results        
        lotto.displayWinningResults();     
    }
    public static ArrayList generateWinningNumbers(){
        
    }
    // method for two-way association
    public static void playLottery(Lottery l, LotteryTicket t){
        t.setLottery(l);
        l.addTicket(t);
    }
}



