/**
 * Assignment 2 Question 2
 * Daljeet Singh 3169763
 */

import java.util.Random;

public class Advantage{
    public static void main(String[] args){
        int player1 = 0, player2 = 0, tie = 0;
        double playerScore1 = 0.0, playerScore2 = 0.0;
        for(int i = 0; i < 10000; i++){
            int roll1 = dice1();
            int roll2 = dice2();
            if(roll1 > roll2){
                player1++;
                playerScore1++;
            }else if(roll2 > roll1){
                player2++;
                playerScore2++;
            } else{
                tie++;
                i--;
            }
        }
        double probability = playerScore1 / playerScore2;
        System.out.println("Score:");
        System.out.println("Player1: " + player1);
        System.out.println("Player2: " + player2);
        System.out.println("[" + tie + " ties]");
        System.out.println("***********************");
        System.out.println("Based on this simulation, Player1 is " + probability + " times more likely to win.");
    }
    public static int dice1(){
        Random rand = new Random();
        return rand.nextInt(6)+1 + rand.nextInt(6)+1;
    }
    public static int dice2(){
        Random rand = new Random();
        return rand.nextInt(5)+1 + rand.nextInt(5)+1;
    }
}
