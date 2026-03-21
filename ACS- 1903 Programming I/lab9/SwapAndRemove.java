/**
 * ACS-1903 Lab 9 Q8
 * Daljeet Singh 3169763
 */

import java.util.ArrayList;

public class SwapAndRemove{
    public static void main(String[] args){
        ArrayList<String> words = new ArrayList<>();
        words.add("is");
        words.add("this");
        words.add("an");
        words.add("array");
        words.add("list");
        words.add("?");
        System.out.println(words);
        
        String first = words.get(0);
        String second = words.get(1);
        words.set(0, second);
        words.set(1, first);
        int length = words.size() - 1;
        words.remove(length);
        for(String k : words){
            System.out.print(k + " ");
        }
    }
}