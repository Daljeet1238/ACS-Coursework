import java.util.Random;
import java.util.Arrays;

/**
 * Write a description of class lab05 here.
 *
 * Daljeet Singh
 * 6th October, 2024
 */
public class RandomUtils extends Random{
    
    public RandomUtils(){
        super();
    }
    
    //Return a random integer
    public int generateInt(){
        int num = super.nextInt();
        return num;
    }
    
    //Return a random double
    public double nextDouble(){
        double number = super.nextDouble() * 2 - 1;
        return number;
    }
    
    
    //takes two parameters and return a random in between them.
    public double nextDouble(int minValue , int maxValue){
        double randomNumber = super.nextDouble(maxValue - minValue) + minValue;
        
        return randomNumber;
    }
    
    //return a 1D array of random doubles. 
    public double[] generateVector(int size){
        double[] vector = new double[size];
        
        for(int i = 0; i < vector.length; i++){
            vector[i] = super.nextDouble() * 2 - 1;
        }
        
        return vector;
    }
    
    //Takes three parameter and return a 1D array of random doubles.
    public double[] generateVector(int size, double minValue, double maxValue){
        double[] vector = new double[size];
        
        for(int i = 0; i < vector.length; i++){
            vector[i] = super.nextDouble() * (maxValue - minValue) + minValue;
        }
        
        return vector;
    }
    
    //Return a matrix of 2D array and it takes two parameters which declare the length and width of the matrix.
    public double[][] generateMatrix (int length, int width){
        double[][] matrix = new double[length][width];
        
        for(int i = 0; i < length; i++){
            for(int j = 0; j < width; j++){
                matrix[i][j] = super.nextDouble() * 2 - 1;
            }
        }
        
        return matrix;
    }
    
    // takes four parameters and return a 2d array.
    public double[][] generateMatrix (int length, int width ,int min, int max){
        double[][] matrix = new double[length][width];
        
        for(int i = 0; i < length; i++){
            for(int j = 0; j < width; j++){
                matrix[i][j] = super.nextDouble() * (max - min) + min;
            }
        }
        
        return matrix;
    }
}
