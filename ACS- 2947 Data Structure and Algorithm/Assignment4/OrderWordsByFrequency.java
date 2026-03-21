/**
 * Daljeet Singh 3169763
 * ACS- 2947- 002
 * Assignment - 4
 */

import java.util.Comparator;

public class OrderWordsByFrequency implements Comparator<Entry<String, Integer>>{

    @Override
    public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
        int freqDifference = entry1.getValue().compareTo(entry2.getValue());

        if(freqDifference == 0){
            return entry1.getKey().compareTo(entry2.getKey());
        }

        return freqDifference;
    }
}
