
/**
 * ACS-1903 Lab 10 Q8
 * Daljeet Singh 3169763
 */
public class Lab10Driver{
    public static void main(String[] args){
        // instantiate two movies: one with full values and another no-arg
        Movie hp = new Movie("Harry Potter and the Goblet of Fire", 2005);
        Movie sw = new Movie();
        
        // display the movies
        System.out.println(hp.getTitle() + ", " + hp.getYear());
        System.out.println(sw.getTitle() + ", " + sw.getYear());       
        
        // set the values of the second movie
        sw.setTitle("Return of the Jedi");
        sw.setYear(1983);
        
        // display the movies again
        System.out.println();
        System.out.println(hp.getTitle() + ", " + hp.getYear());
        System.out.println(sw.getTitle() + ", " + sw.getYear());            
    }
}
