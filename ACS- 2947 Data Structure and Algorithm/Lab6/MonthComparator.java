/**
 * Name: Daljeet Singh
 * Student#: 3169763
 */
import java.util.Comparator;

public class MonthComparator implements Comparator<Month> {
    public int compare(Month m1, Month m2) {
        if (m1.freeDays() != m2.freeDays()) {
            return m1.freeDays() - m2.freeDays();
        } else if (m1.getDays() != m2.getDays()) {
            return m2.getDays() - m1.getDays();
        }
        return m1.getMonthName().compareTo(m2.getMonthName());
    }
}
