/**
 * Daljeet Singh 3169763
 * ACS-2947 Assignment 2 Part B
 */

import java.util.Random;
import java.util.Scanner;

public class PartA_Driver{

    public static void main(String[] args) throws InterruptedException {
        System.out.println("System: Let's play Simon!");

        Scanner kb = new Scanner(System.in);
        Random rand = new Random();                                         // creates the random number
        ArrayList<String> systemOutput = new ArrayList<>();                 // instance of ArrayList
        int count = 0;                                                      // counts the player's score
        int numColor = 1;                                                   // declare the number of color
        boolean valid = true;
        do{
            ArrayList<String> userInput = new ArrayList<>();

            for(int i = 0; i < numColor; i++){
                String color = getColor(rand.nextInt(4) + 1);         // gets the color using random number   
                systemOutput.add(color);                                    // adds colors in the list
            }

            for (int i = 0; i < systemOutput.size(); i++) {
                System.out.println("System: " + systemOutput.get(i));       // prints the colors
            }
            Thread.sleep(2000);
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // prints the lines

            String[] input = kb.nextLine().split(" ");                // takes the input from the user and breaks the colors with spaces  

            for(String word: input){                                        // adds the colors into the arraylist 
                userInput.add(word);
            }

            if(systemOutput.equals(userInput)){
                count++;                                                    // increase the score of the player
                numColor++;                                                 // increase the number of colors after every successful attempt 
                System.out.println("Correct! Your current score is " + count);
            }
            else{
                System.out.println("Game over! Your score is " + count);    // close the game if user answer wrong
                valid = false;                                              // end the do-while loop
            }

            while(!systemOutput.isEmpty()){                                 // removes the elements until the list became empty
                systemOutput.remove(0);
            }

        }while(valid);                                                      // do while continues until the valid is true

        kb.close();
    }

    /**
     * method to get the random color
     * @param number random number to get color
     * @return color
     */
    private static String getColor(int number){
        switch (number) {
            case 1:
                return "green";
            case 2:
                return "blue";
            case 3:
                return "yellow";
            case 4:
                return "red";
            default:
                return "";
        }
    }
}