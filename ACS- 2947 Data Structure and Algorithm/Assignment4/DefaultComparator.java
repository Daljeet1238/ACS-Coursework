/**
 * Daljeet Singh 3169763
 * ACS- 2947- 002
 * Assignment - 4
 */

import java.util.Comparator;

public class DefaultComparator<K> implements Comparator<K>{
    public int compare(K a, K b) throws ClassCastException{
        return ((Comparable<K>) a).compareTo(b);
    }
}
