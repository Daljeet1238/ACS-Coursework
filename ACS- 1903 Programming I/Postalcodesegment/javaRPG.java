import java.util.Scanner;
/**
 * Write a description of class javaRPG here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class javaRPG{
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       System.out.println("What is the name of the cat");
       String answer = "Crookshakes", guess;
       guess = sc.nextLine();
       boolean result = answer.equalsIgnoreCase(guess);
       System.out.println(result);
   }
}
