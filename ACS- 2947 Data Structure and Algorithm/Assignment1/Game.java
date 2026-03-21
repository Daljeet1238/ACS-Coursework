/**
 * ACS-2947 Assingment - 1
 * Daljeet Singh 3169763
 */

import java.util.ArrayList;

public class Game {
    private CircularDoubleLinkedList<Player> players;       //reference to the players of the game
    private ArrayList<Player> eliminatedPlayers;
    private Dice dice;                                      //reference to the dice
    private boolean gameOn;                                 //reference to the game

    /**
     * constructor for the Game class
     */
    public Game(){
        players = new CircularDoubleLinkedList<>();
        eliminatedPlayers = new ArrayList<>();
        dice = new Dice();
        gameOn = true;
    }

    /**
     * method to add the player in the list 
     * @param name  name of the player
     */
    public void addPlayer(String name){
        Player newPlayer = new Player(name);        //creates a new player
        players.addLast(newPlayer);                 //adds the player in the list
    }

    /**
     * method which starts the game 
     */
    public void play(){
        System.out.println("The Dice Game!");
        while(gameOn && players.size() > 1){                //condition which keeps the game on until it breaks
            Player currentPlayer = players.first();         // refernece to the first player in the list
            ArrayList<Integer> rolls = dice.roll();         // stores the dice values in the arraylist
            int dice1 = rolls.get(0);                 //stores the first value of dice1 
            int dice2 = rolls.get(1);                 //stores the value of dice2  
            int totalScore = dice1 + dice2;                 //provides the tottal score

            System.out.print(currentPlayer.getName() + " rolled " + dice1 + " and " + dice2 + ". ");

            //update the score by two times of the score
            if (dice1 == 2 || dice2 == 2){  
                currentPlayer.updateScore(totalScore * 2);
                System.out.println("Lucky 2, score is now " + currentPlayer.getScore());
                players.rotate();
            }
            else if (totalScore == 7){
                //simply add the score in the total score 
                if (dice1 == 2 || dice2 == 2){
                    currentPlayer.updateScore(totalScore * 2);
                    System.out.println("Lucky 2, score is now " + currentPlayer.getScore());
                }
                else{
                    if(currentPlayer.getScore() > 6){
                        currentPlayer.subtractScore(7);         //subtract 7 from the total score
                        System.out.println("Unlucky 7, score is " + currentPlayer.getScore());
                    }
                    else{
                        System.out.println("Unlucky 7, score is now " + currentPlayer.getScore());
                    }
                }
                players.rotate();
            }
            //reset the score to 0 if dice1 and dice2 both shows 6
            else if (dice1 == 6 && dice2 == 6){
                currentPlayer.resetScore();
                players.reverse();
                System.out.println("Double 6 , score is now " + currentPlayer.getScore() + ". Reverse direction");
                players.rotate();                       //give turn to the previous player
                players.rotate();
            }
            //eliminate the player from the game
            else if (dice1 == 1 && dice2 == 1) {
                eliminatedPlayers.add(currentPlayer);               //adds the current player into the eliminated list
                players.removeFirst();
                System.out.println("Snake eyes! Player eliminated :(");
            }
            else{
                currentPlayer.updateScore(totalScore);
                System.out.println("Score is now " + currentPlayer.getScore());
                players.rotate();
            }

            //shows the winner's name
            if(currentPlayer.getScore() >= 100){
                System.out.println(currentPlayer.getName() + " won the game! :)");
                gameOn = false;
            }

            //rotate the turn to the next player
            //players.rotate();

            //show the last remaining player 
            if (players.size() == 1) {
                System.out.println(players.first().getName() + "is the last person standing \n " + players.first().getName() + " wons the game! :)");
            }
        }

        //shows the final score of all the remaining compititors
        System.out.println("Final Scores:");
        while(players.size() != 0){
            Player player = players.removeFirst();
            System.out.print(player.getName() + ": " + player.getScore() + ", ");
        }

        System.out.println();
        
        //shows the eliminated players
        if(eliminatedPlayers.size() != 0){
            System.out.print("Eliminated: " + eliminatedPlayers);
        }else{
            System.out.println("No player is eliminated");
        }
    }
}

