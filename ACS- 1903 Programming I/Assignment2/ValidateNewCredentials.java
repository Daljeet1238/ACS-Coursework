/**
 * Assignment 2 Question 3
 * Daljeet Singh 3169763
 */

import java.util.Scanner;

public class ValidateNewCredentials{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your handle:");
        String input = sc.nextLine();
        while(validateHandle(input) == false){
            System.out.println("Invalid handle, Handle must be between 3 to 14 characters.");
            System.out.println("Enter your handle:");
            input = sc.nextLine();
        }
            
        System.out.println("Create a password:");
        input = sc.nextLine();
        
        while(validatePassword(input) == false){
            System.out.println("Invalid password, enter another:");
            System.out.println("Password must be at least 8 characters, contain at least 1 letter, 1 number, 1 special character, and no spaces.");
            System.out.println("Create a password:");
            input = sc.nextLine();
        }
        System.out.println("Account created successfully.");        
    }
    public static boolean validateHandle(String input){
        boolean valid = true;
        if(input.length() <= 2 && input.length() >= 15){
           valid = false; 
        }
        for(int i = 0; i <input.length(); i++){
            char c = input.charAt(i);
            if(!Character.isLetter(c)){
                valid = false;
            }
        }
        return valid;
    }
    public static boolean validatePassword(String input){
        int length = input.length();
        boolean alpha = false, numericDigit = false, specialCharacter = false, space = true;
        boolean valid = true;
        if(length < 8){
            valid = false;
        }
        for(int i = 0; i < length; i++){
            char c = input.charAt(i);
            if(Character.isLetter(c)){
                alpha = true;
            }
            if(Character.isDigit(c)){
                numericDigit = true;
            }
            if(Character.isWhitespace(c)){
                space = false;
            }
            if(!Character.isLetter(c) && Character.isDigit(c) && !Character.isWhitespace(c)){
                specialCharacter = true;
            }
        }
        return valid && alpha && numericDigit && space && specialCharacter;
    }
}