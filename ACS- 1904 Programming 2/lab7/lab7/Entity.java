
/**
 *
 * Daljeet Singh 3169763
 * 25th October, 2024
 */

public class Entity{
        protected int health;
        protected int xLocation;
        protected int yLocation;
        protected String characterName;

    public Entity(int health, int xLocation, int yLocation, String characterName){
        this.health = health;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.characterName = characterName;

    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getXLocation(){
        return xLocation;
    }

    public void setXLocation(int xLocation){
        this.xLocation = xLocation;
    }

    public int getYLocation(){
        return yLocation;
    }

    public void setYLocation(int yLocation){
        this.yLocation = yLocation;
    }

    public String getCharacterName(){
        return characterName;
    }

    public void setCharacterName(String characterName){
        this.characterName = characterName;
    }

    public String toString(){
        return characterName;
    }

    public void move(int x, int y){
        this.xLocation = x;
        this.yLocation = y;
        System.out.println(characterName + " moved to (" + x + y + ")");
    }
}
