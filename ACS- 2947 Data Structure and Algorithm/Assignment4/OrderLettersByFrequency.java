/**
 * Daljeet Singh 3169763
 * ACS- 2947- 002
 * Assignment - 4
 */

import java.util.Comparator;

public class OrderLettersByFrequency implements Comparator<Entry<Character, Integer>>{

    @Override
    public int compare(Entry<Character, Integer> entry1, Entry<Character, Integer> entry2) {
        int freqLettersDifference = entry1.getValue().compareTo(entry2.getValue());

        if(freqLettersDifference == 0){
            return entry1.getKey().compareTo(entry2.getKey());
        }

        return freqLettersDifference;
    }
}