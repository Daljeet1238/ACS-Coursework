/**
 * ACS-2947 Assingment - 1
 * Daljeet Singh 3169763
 */

import java.util.Random;

public class Die{
    private int nFaces;             //reference to the number of faces
    private int faceValue;          //reference to the face value of the die

    /**
     * constructor for the die class
     * @param nFaces number of the faces
     */
    public Die(int nFaces){
        if(nFaces < 2){ 
            throw new IllegalArgumentException("Die must have atleast have 2 faces");
        }else{
            this.nFaces = nFaces;
            roll();
        }
    }

    /**
     * roll method which provides the random number
     * @return return the face value for the die
     */
    public int roll(){
        Random random = new Random();
        return faceValue = random.nextInt(nFaces) + 1;
    }

    //getter for the face value 
    public int getFaceValue(){
        return faceValue;
    }

    // public void setFaceValue(int value){
    //     this.faceValue = value;
    // }

    //getter for the number fo faces
    public int getNFaces(){
        return nFaces;
    }
}