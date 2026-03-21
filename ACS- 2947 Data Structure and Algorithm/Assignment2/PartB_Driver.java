/**
 * Daljeet Singh 3169763
 * ACS-2947 Assignment 2 Part B
 */

public class PartB_Driver {
    public static void main(String args[]){
        ArrayPositionalList<String> s1 = new ArrayPositionalList<>();                                       // creates new instance of ArrayPositionalList

        s1.addLast("harry");                                                                              // adds the element at the end of the list
        s1.addLast("will");
        s1.addLast("tom");
        s1.addLast("tom");
        s1.addLast("tom");
        s1.addLast("charles");
        System.out.println("Original Positional List:");
        System.out.println(s1.toString());                                                                  // prints the list before the removing the consecutives duplicates
        System.out.println("Number of entries after call: " + removeConsecutiveDuplicate(s1));              // removes the consecutive duplicates from the list
        System.out.println(s1.toString());                                                                  // prints after removing the consecutive duplicates from the list

        ArrayPositionalList<String> s2 = new ArrayPositionalList<>();                                       // creates new instance of ArrayPositionalList
        s2.addLast("harry");                                                                              // adds the element at the end of the list  
        s2.addLast("harry");
        s2.addLast("tom");
        s2.addLast("will");
        s2.addLast("meg");
        s2.addLast("harry");
        System.out.println("Original Positional List:");                                        
        System.out.println(s2.toString());                                                                  // prints the list before the removing the consecutives duplicates
        System.out.println("Number of entries after call: " + removeConsecutiveDuplicate(s2));              // removes the consecutive duplicates from the list
        System.out.println(s2.toString());                                                                  // prints after removing the consecutive duplicates from the list

        ArrayPositionalList<String> s3 = new ArrayPositionalList<>();                                       // creates new instance of ArrayPositionalList
        s3.addLast("tom");                                                                                // adds the element at the end of the list  
        s3.addLast("will");
        s3.addLast("harry");
        s3.addLast("charles");
        s3.addLast("meg");
        System.out.println("Original Positional List:");
        System.out.println(s3.toString());                                                                  // prints the list before the removing the consecutives duplicates
        System.out.println("Number of entries after call: " + removeConsecutiveDuplicate(s3));              // removes the consecutive duplicates from the list
        System.out.println(s3.toString());                                                                  // prints after removing the consecutive duplicates from the list

        ArrayPositionalList<String> s4 = new ArrayPositionalList<>();                                       // creates new instance of ArrayPositionalList
        s4.addLast("meg");                                                                                // adds the element at the end of the list  
        s4.addLast("meg");
        s4.addLast("tom");
        s4.addLast("tom");
        s4.addLast("tom");
        s4.addLast("tom");
        s4.addLast("harry");
        System.out.println("Original Positional List:");
        System.out.println(s4.toString());                                                                  // prints the list before the removing the consecutives duplicates           
        System.out.println("Number of entries after call: " + removeConsecutiveDuplicate(s4));              // removes the consecutive duplicates from the list
        System.out.println(s4.toString());                                                                  // prints after removing the consecutive duplicates from the list

        ArrayPositionalList<String> s5 = new ArrayPositionalList<>();                                       // creates new instance of ArrayPositionalList    
        s5.addLast("meg");                                                                                // adds the element at the end of the list  
        s5.addLast("meg");
        s5.addLast("tom");
        s5.addLast("james");
        s5.addLast("charles");
        s5.addLast("charles");
        s5.addLast("james");
        s5.addLast("harry");
        s5.addLast("harry");
        s5.addLast("harry");
        System.out.println("Original Positional List:");
        System.out.println(s5.toString());                                                                  // prints the list before the removing the consecutives duplicates
        System.out.println("Number of entries after call: " + removeConsecutiveDuplicate(s5));              // removes the consecutive duplicates from the list
        System.out.println(s5.toString());                                                                  // prints after removing the consecutive duplicates from the list

        ArrayPositionalList<Character> c = new ArrayPositionalList<>();                                     // creates new instance of ArrayPositionalList    
        c.addLast('A');
        c.addLast('M');
        c.addLast('A');
        c.addLast('Z');
        c.addLast('I');
        c.addLast('N');
        c.addLast('G');
        c.addLast('R');
        c.addLast('A');
        c.addLast('C');
        c.addLast('E');

        ArrayPositionalList.InsertionSort(c);                                                               // sort the arraypositionallist 
        System.out.println(c.toString());                                                                   // prints the c
    }

    /**
     * method that removes the consecutive duplicates in the list
     * @param list ArraypositionalList as a input
     * @return the number of elements in the list
     */
    public static int removeConsecutiveDuplicate(ArrayPositionalList<String> list) {
        if (list.isEmpty()) return 0;
    
        Position<String> current = list.first();
        while (current != null) {
            Position<String> next = list.after(current);
            if (next != null && current.getElement().equals(next.getElement())) {
                list.remove(next);
            } else {
                current = next;
            }
        }
        return list.size();
    }
}
