import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class will read in text files and compare
 * the texts within them
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lab03
{
    public static String readFile(String fileName) throws FileNotFoundException{
        // Read a file into a single string
        
        // Check for valid file name here...
        
        
        
        // System.getProperty("user.dir") gives us the current working directory
        // This is where our code is running, and where Java will look for our file
        System.out.println("Reading " + System.getProperty("user.dir") + "\\" + fileName + "...");
        
        Scanner scanner = new Scanner(new File(fileName));
        String contents = scanner.useDelimiter("\\A").next();
        scanner.close();
        return contents;
    }
    
    
    public static void main(String[] args) throws FileNotFoundException{
        String fileName = "fairytale.txt"; // Relative path of our filename
        String story = readFile(fileName); // Read the story as 1 string
            
        // Write your solutions here!
        
        
        /*
         * Hint: If you're having trouble creating your 2D array,
         * remember that you can define the first dimension of the array separate from the second.
         * eg: String[][] x = new String[10][]; is allowed, and the second dimensions can be filled in later.
         */
    }
}
