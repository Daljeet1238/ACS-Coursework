/**
 * ACS-1903 Lab9 Q7
 * Daljeet Singh 3169763;
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TokenCount{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner f = new Scanner(new File("lab9.txt"));
        int count=0, countE=0;
        String token;
        while(f.hasNext()){
            token = f.next();
            count += 1;
            if(token.charAt(token.length()-1) == 'e'){
                countE += 1;
            }
        }

        System.out.println("Number of tokens: " + count);
        System.out.println("Number of tokens ending with e: " + countE);
    }
}