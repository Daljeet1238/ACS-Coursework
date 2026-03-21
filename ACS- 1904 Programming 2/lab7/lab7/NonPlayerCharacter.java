
/**
 *
 * Daljeet Singh 3169763
 * 25th October, 2024
 */

public class NonPlayerCharacter extends Entity{
    private String difficulty;
    private String dialogue;

    public NonPlayerCharacter(int health, int xLocation, int yLocation, String difficulty, String dialogue, String characterName){
        super(health, xLocation, yLocation, characterName);
        this.difficulty = difficulty;
        this.dialogue = dialogue;  
    }

    public String getDifficulty(){
        return difficulty;
    }

    public void setDifficulty(String difficulty){
        this.difficulty = difficulty;
    }

    public String getDialogue(){
        return dialogue;
    }

    public void setDialogue(String dialogue){
        this.dialogue = dialogue;
    }

    public String toString(){
        return super.toString() + ": \"" + dialogue + "\"";
    }
}
