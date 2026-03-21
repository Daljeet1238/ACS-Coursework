import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * This file will analyse the length of a few text
 *
 * @author Jesse Harder
 * @version 1.0.0
 */
public class Lab03_Solution
{
    public static String readFile(String fileName) throws FileNotFoundException{
        // Reads a file into a single string
        
        // Use String.matches() to check if the string ends in .txt
        // If it doesn't, raise an exception!
        if(!fileName.matches(".*\\.txt$")){
            throw new IllegalArgumentException("File must be a .txt file: " + fileName);
        }
        
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
        
        // Split the sentences on . ! or ?
        // Note that . is a special character and must be escaped
        // We use a plus to match any groups of these characters!
        // [\\.!?]+ represents any number of .!?s in a row
        // [\\s]+ represents any whitespace (square brackets optional here)
        // 2 Marks for this regex
        String[] sentences = story.split("[\\.!?]+[\\s]+");

        // Declare the 2D array
        // First dimension's length is how many sentences we have
        String[][] storyWordArray = new String[sentences.length][]; 
        
        // Iterate over each sentence and break it down into words
        // We'll also keep a count of the words here
        int numWords = 0;
        for(int i=0; i<sentences.length; i++){
            // Split the sentences on newlines, spaces, dashes or double quotes
            // We use a plus to match any groups of these characters!
            // 2 Marks for this regex
            // 2 Marks for setting the words into the array
            storyWordArray[i] = sentences[i].split("[\\s-]+");

            numWords += storyWordArray[i].length;
            
            // Print out the sentence arrays to check that it all looks good
            //System.out.println(Arrays.toString(storyWordArray[i]));
        }
        
        // Print out our analysis
        // Students may gather the numbers by using a second for loop, which is fine too
        // 1 Mark each for the characters, sentences, and words
        System.out.println(fileName);
        System.out.println("\tCharacters: " + story.length());
        System.out.println("\tSentences: " + sentences.length);
        System.out.println("\tWords: " + numWords);
        // Note: small differences in the regex will result in different counts
        // Mark the students correct if their approach to getting the numbers was correct,
        // even if the numbers are different from the solution
    }
}
