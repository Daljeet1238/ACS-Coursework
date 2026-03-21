
/**
 * A quick analysis of some search volumes in 2024
 *
 * Daljeet Singh 3169763
 * 09/07/2024
 */

public class Lab01{
    //Declaring an array
    String[] months = {"January", "February", "March", "April", "May", "June", "July"};
    
    //Declaring arrays for volumes.
    int[] javaVols = {246000, 450000, 201000,  201000, 201000, 201000};
    int[] programmingVols = {40500, 33100, 33100, 33100, 33100, 33100, 33100,};
    int[] uofwVols = {1900, 1600, 1600, 1600, 1600, 1300, 1300};
    
    //retrun the index of the greatest value.
    public static int calcMax(int[] a){
        int greatestValue = a[0];
        int index = 0;
        
        for(int i = 0; i < a.length; i++){
            if(a[i] > greatestValue){
                greatestValue = a[i];
                index = i;
            }
        }
        return index;
    }
    
    //return the average of the values.
    public static double calcAverage(int[] a){
        double sum = 0;
        double length = a.length;
        for(int i = 0; i < a.length; i++){
            sum += a[i];
        }
        double average = sum / length;
        return average;
    }
    
    
    public static void main(String[] args){
        Lab01 lab = new Lab01();
        
        //calculate the average search volume for university of winnipeg.
        double UOfWAverage = lab.calcAverage(lab.uofwVols);
        System.out.println("Average monthly search for University of Winnipeg is " + UOfWAverage);
        
        //display the month when java have greatest search.
        int mostSearched = lab.calcMax(lab.javaVols);
        System.out.println("Most searched month is " + lab.months[mostSearched]);
    }
}
