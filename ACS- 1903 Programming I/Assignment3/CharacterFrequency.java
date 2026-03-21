/**
 * Daljeet Singh 3169763
 * Assignment 3 Question 3
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
public class CharacterFrequency{
    public static void main(String[] args) throws  FileNotFoundException{
        String file = "A3.txt";
        Scanner f = new Scanner(new File(file));
        
        ArrayList<Character> letters = new ArrayList<>();
        ArrayList<Integer> lettersFrequency = new ArrayList<>();   
        ArrayList<Character> numbers = new ArrayList<>();
        ArrayList<Integer> numbersFrequency = new ArrayList<>();
        ArrayList<Character> specialChar = new ArrayList<>();
        ArrayList<Integer> specialCharFrequency = new ArrayList<>();
        
        
        countFrequencies(f, letters, lettersFrequency, numbers, numbersFrequency, specialChar, specialCharFrequency);
        
        printHighestFrequency(letters, lettersFrequency, numbers, numbersFrequency, specialChar, specialCharFrequency);
    }
    
    public static void countFrequency(char c, ArrayList<Character> charList, ArrayList<Integer> frequencyList){
        int indexOfChar = charList.indexOf(c);
        if(!charList.contains(c)){
            charList.add(c);
            frequencyList.add(1);
        }else{
            int increaseFrequency = frequencyList.get(indexOfChar) + 1;
            frequencyList.set(indexOfChar, increaseFrequency);
        }
    }
    
    public static void countFrequencies(Scanner f, ArrayList<Character> letters, ArrayList<Integer> lettersFrequency,
        ArrayList<Character> numbers, ArrayList<Integer> numbersFrequency, ArrayList<Character> specialChar,
        ArrayList<Integer> specialCharFrequency){  
        do{
            String token = f.next();
            int count = 0;
            for(int i = 0; i < token.length(); i++){
                char z = token.charAt(i);
                char c = Character.toLowerCase(z);
                if(Character.isLetter(c)){
                    countFrequency(c, letters, lettersFrequency);
                }
                else if(Character.isDigit(c)){
                    countFrequency(c, numbers, numbersFrequency);
                }
                else if(Character.isWhitespace(c)){
                    count = 0;
                }
                else{
                    countFrequency(c, specialChar, specialCharFrequency);
                }
            }
        }while(f.hasNext());
    }
    
    public static char highestFrequencyItem(ArrayList<Character> charList, ArrayList<Integer> frequencyList){
        int highestFrequency = frequencyList.get(1);
        char firstItem = charList.get(1);
        for(int i = 2; i < charList.size(); i++){
            if(frequencyList.get(i) > highestFrequency){
                highestFrequency = frequencyList.get(i);
                firstItem = charList.get(i);
            }
        }
        return firstItem;
    }
    
    
    public static void printHighestFrequency(ArrayList<Character> letters, ArrayList<Integer> lettersFrequency,
        ArrayList<Character> numbers, ArrayList<Integer> numbersFrequency, ArrayList<Character> specialChar,
        ArrayList<Integer> specialCharFrequency){
        System.out.println("type\t\tcharacters\t\tfrequency");
        System.out.println("----\t\t----------\t\t---------");
        
        char maxLetter = highestFrequencyItem(letters, lettersFrequency);
        int maxLetterFrequency = letters.indexOf(maxLetter);
        int max1 = lettersFrequency.get(maxLetterFrequency);
        
        System.out.println("letter:\t\t" + maxLetter + "\t\t\t" + max1);
        
        char maxNumber = highestFrequencyItem(numbers, numbersFrequency);
        int maxNumberFrequency = numbers.indexOf(maxNumber);
        int max2 = numbersFrequency.get(maxNumberFrequency);
        
        System.out.println("number:\t\t" + maxNumber + "\t\t\t" + max2);
        
        char maxSpecial = highestFrequencyItem(specialChar, specialCharFrequency);
        int maxSpecialFrequency = 0;
        for(int i = 0; i < specialChar.size(); i++){
            if(specialCharFrequency.get(i) > maxSpecialFrequency && specialCharFrequency.get(i) == maxSpecial){
                maxSpecialFrequency += specialCharFrequency.get(i);
            }
        }
        System.out.println("special:\t" + maxSpecial + "\t\t\t" + maxSpecialFrequency);
    }
}
