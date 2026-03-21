import java.util.Comparator;

/**
 * Name: Daljeet Singh
 * Student#: 3169763
 */

/**
 * generic default comaparator class which uses natural ordering
 */
public class DefaultComparator<E> implements Comparator<E> {
    public int compare(E a, E b) throws ClassCastException{
        return ((Comparable<E>) a).compareTo(b);
    }
}
