/**
 * ACS-2947 Assingment - 1
 * Daljeet Singh 3169763
 */

public class Player {
    private String name;                //reference to the name of the player
    private int score;                  //reference to the player score of the player

    /**
     * constructor for the Player class
     * @param n name of the player
     */
    public Player(String n){
        name = n;
        score = 0;
    }

    //getter for the player name
    public String getName(){
        return name;
    }

    /**
     * setter for the player name
     * @param n name of the player
     */
    public void setName(String n){
        this.name = n;
    }

    //getter for the score
    public int getScore(){
        return score;
    }

    /**
     * method to update the player score
     * @param points points which adds or subtract from the player's score
     */
    public void updateScore(int points){
        score += points;
    }

    /**
     * method to subtract the score 
     * @param points points which subtracts from the player's score
     */
    public void subtractScore(int points){
        score -= points;
    }

    /**
     * method to reset the player's score to 0
     */
    public void resetScore(){
        score = 0;
    }

    //toString method for the player class
    @Override
    public String toString(){
        return name;
    }
}
