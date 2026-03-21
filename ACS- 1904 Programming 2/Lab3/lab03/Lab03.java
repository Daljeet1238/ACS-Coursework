import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class will read in text files and compare
 * the texts within them
 *
 * Daljeet Singh 3169763
 * 23-Sept-2024
 */
public class Lab03
{
    public static String readFile(String fileName) throws FileNotFoundException{
        // Read a file into a single string
        
        // Check for valid file name here...
        if(!fileName.matches(".*\\.txt$")){
            throw new IllegalArgumentException("The file is not a txt file." + fileName);
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
            
        String[] sentences = story.split("[.!?]\\s+"); // splitting the file into an array of sentences.
        String[][] words = new String[sentences.length][]; //creating a 2D array. 
        
        //counting the number of words
        int wordsCounter = 0;
        for(int i = 0; i < sentences.length; i++){
            words[i] = sentences[i].split("-|\\s+");
            wordsCounter += words[i].length;
            String[] word= words[i];
            
            System.out.println(word);
        }
        
        
        
        //calculate the length of file.
        int charCounter = story.length();
        System.out.println("The story is " + charCounter + " characters long.");
        
        System.out.println("The story is " + wordsCounter + " words long.");
        
        int sentencesCounter = sentences.length;
        System.out.println("The story is " + sentencesCounter + " sentences long.");
        
        /*
         * Hint: If you're having trouble creating your 2D array,
         * remember that you can define the first dimension of the array separate from the second.
         * eg: String[][] x = new String[10][]; is allowed, and the second dimensions can be filled in later.
         */
    }
}
