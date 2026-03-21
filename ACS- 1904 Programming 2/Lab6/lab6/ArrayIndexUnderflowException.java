/**
 * Write a description of class lab6 here.
 *
 * Daljeet Singh 3169763
 * 14th October, 2024
 */
public class ArrayIndexUnderflowException extends ArrayIndexOutOfBoundsException{
    private int index;
    private int length;

    //constructor
    public ArrayIndexUnderflowException(int index, int length){
        this.index = index;
        this.length = length;
    }

    //getter for the constructor
    public int getLength(){
        return length;
    }

    public int getIndex(){
        return index;
    }
}