/**
 * Daljeet Singh 3169763
 * ACS- 2947- 002
 * Assignment - 4
 */

import java.util.Comparator;

public class OrderByLongitude implements Comparator<PostalCode>{
    @Override
    public int compare(PostalCode p1, PostalCode p2){
        return Double.compare(p1.getLongitude(), p2.getLongitude());
    }
}
