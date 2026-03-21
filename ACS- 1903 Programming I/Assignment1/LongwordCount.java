import java.util.Scanner;

/**
 * ACS -1903 Lab 4 Question 7
 * Daljeet Singh 3169763
 */
public class LongwordCount{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = 0;
        System.out.println("Enter one words (stop to end):");
        String name="";
        while(!name.equalsIgnoreCase("stop")){
            name = sc.next();
            if(name.length() > 6){
                count++;
            }   
        }
        System.out.println("Number of long words: " + count);
    }
}

