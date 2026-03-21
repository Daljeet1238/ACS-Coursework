/**
 * DSA ACS-2947
 * Lab-3 
 * Daljeet Singh 3169763
 */

import java.util.Scanner;

public class Lab3_Driver {
/**
 * main method to check whether the input is palindrome or not
 * @param args
 */
public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);                            //declare the scanner
    System.out.println("Enter a word, phrase, or sentence");
    String input = kb.nextLine();                                   //store the input  
    kb.close();                                                     //close the scanner

    System.out.println();

    /**
     * removes all the spaces and comas
     * convert the input into lowercase
     */
    String modifyString = modify(input.toLowerCase());              
    System.out.println(modifyString);

    /**
     * initiate the stack
     */
    Stack<Character> stack = new ArrayStack<>();

    /**
     * iterate over the String and insert each character in the stack
     */
    for (char c : modifyString.toCharArray()) {
        stack.push(c);
    }


    StringBuilder reversedString = new StringBuilder();         // initiate a new string builder

    /**
     * using pop on the stack which make it in reverse order
     */
    while (!stack.isEmpty()) {
        reversedString.append(stack.pop());
    }

    /**
     * returns whether the given word is palindrome or not
     */
    if(modifyString.equals(reversedString.toString())){
        System.out.println("is a palindrome");
    }else{
        System.out.println("is not a palindrome");
    }

}

/**
 * method which removes all the spaces and comas from the input
 * @param input given word, phrase or sentence
 * @return String without any spaces and comas
 */
public static String modify(String input){
    StringBuilder sb = new StringBuilder();         // initiate the new Stringbuilder
    char[] charArray = input.toCharArray();

    /**
     * iterate over the array and check whether the char is letter or not
     */
    for(char i : charArray){
        if(Character.isLetter(i)){
            sb.append(i);
        }
    }
    return sb.toString();           //return String

    
}
}
