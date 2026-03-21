/**
 * Daljeet Singh 3169763
 * ACS- 2947- 002
 * Assignment - 4
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PartA_Driver {
    public static void main(String[] args) throws FileNotFoundException{
        ProbeHashMap<String, Integer> map1 = new ProbeHashMap<>();
        ProbeHashMap<Character, Integer> map2 = new ProbeHashMap<>();

        List<String> pronouns = new ArrayList<>();
        pronouns.add("i");
        pronouns.add("we");
        pronouns.add("you");
        pronouns.add("he");
        pronouns.add("she");
        pronouns.add("it");
        pronouns.add("they");
        
        Scanner sc = new Scanner(new File("PartA.txt"));
        sc.useDelimiter("[^a-zA-Z]+");
        while(sc.hasNext()){
            String word = sc.next().toLowerCase();
            
            Integer wordCount = map1.get(word);
            if(wordCount == null){
                map1.put(word,1);
            }else{
                map1.put(word, wordCount+1);
            }

            for(char c : word.toCharArray()){
                Integer charCount = map2.get(c);
                if(charCount == null){
                    map2.put(c, 1);
                }else{
                    map2.put(c, charCount+1);
                }
            }
        }
        sc.close();

        Comparator<Entry<String, Integer>> wordComparator = new OrderWordsByFrequency();
        Comparator<Entry<Character , Integer>> charComparator = new OrderLettersByFrequency();

        Entry<String, Integer> mostFrequentWord = findMaxLeast(map1, wordComparator, true);
        Entry<String, Integer> leastFrequentWord = findMaxLeast(map1, wordComparator, false);
        Entry<Character, Integer> mostFrequentChar = findMaxLeast(map2, charComparator, true);
        Entry<Character, Integer> leastFrequentChar = findMaxLeast(map2, charComparator, false);
        Entry<String, Integer> mostFrequentPronoun = findCategoryMaxLeast(map1, pronouns, wordComparator, true);
        Entry<String, Integer> leastFrequentPronoun = findCategoryMaxLeast(map1, pronouns, wordComparator, false);

        System.out.println("Test Analyzer");
        System.out.println("Total number of distinct words: " + map1.size());
        System.out.println("Total number of distinct letters: " + map2.size());
        System.out.println("Most occuring character: " + mostFrequentChar.getKey() + ", " + mostFrequentChar.getValue());
        System.out.println("Least occuring character: " + leastFrequentChar.getKey() + ", " + leastFrequentChar.getValue());
        System.out.println("Most occuring word: " + mostFrequentWord.getKey() + ", " + mostFrequentWord.getValue());
        System.out.println("Least occuring word: " + leastFrequentWord.getKey() + ", " + leastFrequentWord.getValue());
        System.out.println("Most occuring pronoun: " + mostFrequentPronoun.getKey() + ", " + mostFrequentPronoun.getValue());
        System.out.println("Least occuring pronoun: " + leastFrequentPronoun.getKey() + ", " + leastFrequentPronoun.getValue());

    }

    public static <K,V> Entry<K, V> findMaxLeast(ProbeHashMap<K, V> map, Comparator<Entry<K, V>> comp, boolean choose) {
        if(map == null || map.isEmpty()) return null;
        
        Entry<K,V> result = null;
        for(Entry<K,V> e : map.entrySet()){
            if(result == null){
                result = e;
            }

            if(choose ? comp.compare(e, result) > 0 : comp.compare(e, result) < 0){
                result = e;
            }
        }
        return result;
    }

    public static <K,V> Entry<K,V> findCategoryMaxLeast(ProbeHashMap<K, V> map, List<K> keys,Comparator<Entry<K, V>> comp, boolean choose){
        if(map == null || keys == null || keys.isEmpty()) return null;

        Entry<K,V> result = null;
        for(Entry<K,V> entry : map.entrySet()){
            if(keys.contains(entry.getKey())){
                if(result == null){
                    result = entry;
                }

                if(choose ? comp.compare(entry, result) > 0 : comp.compare(entry, result) < 0){
                    result = entry;
                }
            }
        }
        return result;
    }
}
