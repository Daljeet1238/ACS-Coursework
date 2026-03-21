/**
 * ACS-1903 Lab7 Q7
 * Daljeet Singh 3169763
 */
import java.util.Random;

public class DieRolls{
    public static void main(String[] args){
        Random rand = new Random();
        int roll = 0, count=0;
        for(int i = 1; i<100; i++){
            while(roll != 1){
                roll = rand.nextInt(6)+1;
                System.out.println("Roll " + i++ + "=" + roll);
                count += 1; 
            }
        }
        System.out.println("Number of rolls until 1: " + count);
    }
}