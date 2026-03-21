import java.util.ArrayList;
import java.util.Collections;

/**
 * Name: Daljeet Singh
 * Student#: 3169763
 */

public class Lab6_Driver {
    public static void main(String[] args) {
        ArrayList<Month> months = new ArrayList<>();                                // creates an instance of the ArrayList

        months.add(new Month("January", 1, 31, 21));
        months.add(new Month("February", 2, 28, 20));
        months.add(new Month("March", 3, 31, 23));
        months.add(new Month("April", 4, 30, 21));
        months.add(new Month("May", 5, 31, 22));
        months.add(new Month("June", 6, 30, 22));
        months.add(new Month("July", 7, 31, 21));
        months.add(new Month("August", 8, 31, 23));
        months.add(new Month("September", 9, 30, 22));
        months.add(new Month("October", 10, 31, 21));
        months.add(new Month("November", 11, 30, 22));
        months.add(new Month("December", 12, 31, 22));

        // sort the list using natural ordering with no comparator
        System.out.println("Natural ordering (With No Comparator):");
        Collections.sort(months);
        for(Month m : months)
            System.out.println(m);
        System.out.println();

        // sort the list using natural ordering using default comparator
        System.out.println("Natural Ordering (With Default Comparator):");
        DefaultComparator<Month> dc = new DefaultComparator<>();
        Collections.sort(months, dc);
        for(Month m : months)
            System.out.println(m);
        System.out.println();

        // sort the list using ordering by month comparator
        System.out.println("Ordering by MonthComaparator:");
        MonthComparator mc = new MonthComparator();
        Collections.sort(months, mc);
        for(Month m : months)
            System.out.println(m);
        System.out.println();

        printBinaryNumber(16);
    }

    /**
     * method prints the number in binary form
     * @param n integer as a parameter
     */
    public static void printBinaryNumber(int n){
        ArrayQueue<String> queue = new ArrayQueue<>();
        queue.enqueue("1");

        for(int i = 0; i < n; i++){
            String number = queue.dequeue();
            System.out.print(number + " ");

            queue.enqueue(number + "0");
            queue.enqueue(number + "1");
        }

        for(String element: queue){
            System.out.println(element + " ");
        }
        queue.clear();
        System.out.println(queue);

    }
}
