
/**
 * Daljeet Singh 3169763
 * 16th October, 2024
 */

public class DriverItem{
    public static void main(String[] args) throws ItemNotFoundException{
        Library library = new Library("The Library");
        
        Item book = new Book("The Habbit", "Tolkien", "unknown", 120, Format.HARDCOVER, 1, Genre.FANTASY);
        Item movie = new Movie("Tony Stark", "marvel", 146, 2, "The Iron Man", Genre.SCI_FI);
        Item magzine = new Magazine("Me Magazine", 25, "October2024", 3, "National Geographic", Genre.SCIENCE);

        library.addItem(book);
        library.addItem(movie);
        library.addItem(magzine);

        for(Item item: library.getItem()){
            System.out.println(item);
        }

        System.out.println("\n");

        library.checkout("The Habbit");

        for(Item item: library.getItem()){
            System.out.println(item);
        }

        System.out.println("\n");

        library.checkout("Super Mario");
    }
}
