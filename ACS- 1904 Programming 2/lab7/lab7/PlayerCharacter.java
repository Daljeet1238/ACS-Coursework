
/**
 *
 * Daljeet Singh 3169763
 * 25th October, 2024
 */

public class PlayerCharacter extends Entity{
    private int level;
    private String playerName;

    public PlayerCharacter(int level, int health, int xLocation, int yLocation, String playerName, String characterName){
        super(health, xLocation, yLocation, characterName);
        this.level = level;
        this.playerName = playerName;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public String getPlayerName(){
        return playerName;
    }

    public void setPlayerName(String playerName){
        this.playerName = playerName; 
    }

    public String toString(){
        return characterName + " (" + playerName + ")";
    }
}
