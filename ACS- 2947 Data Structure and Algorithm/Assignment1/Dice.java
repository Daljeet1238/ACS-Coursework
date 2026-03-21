/**
 * ACS-2947 Assingment - 1
 * Daljeet Singh 3169763
 */

import java.util.ArrayList;

public class Dice {
    private Die die1;               //refernece to the die 1
    private Die die2;               //reference to the die 2
    private int nSides;             //reference to the number of sides

    //constructor for the dice class which contains the die of 6 sides each
    public Dice(){
        this.die1 = new Die(6);
        this.die2 = new Die(6);
    }

    /**
     * constructor that allow to specify the numbe rof sides
     * @param nSides number of sides of the die
     */
    public Dice(int nSides){
        this.nSides = nSides;
        this.die1 = new Die(nSides);
        this.die2 = new Die(nSides);
    }

    //getter to get the number of sides.
    public int getNSides(){
        return nSides;
    }

    /**
     * method which roll the die and add the value in the ArrayList
     * @return ArrayList containing face value of the die
     */
    public ArrayList<Integer> roll(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(die1.roll());
        list.add(die2.roll());
        return list;
    }
}

