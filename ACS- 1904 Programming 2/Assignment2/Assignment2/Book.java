
/**
 * Daljeet Singh 3169763
 * 16th October, 2024
 */

public class Book extends Item{
    private String publisher;
    private int pageCount;
    private String author;
    private Format format;
    
    //constructor
    public Book(String title, String author, String publisher, int pageCount, Format format, int identificationNUmber, Genre genre){
        super(identificationNUmber, title, genre);
        this.publisher = publisher;
        this.pageCount = pageCount;
        this.author = author;
        this.format = format;
    }

    //getters
    public String getPublisher(){
        return publisher;
    }

    public int getPageCount(){
        return pageCount;
    }

    public String getAuthor(){
        return author;
    }

    public Format format(){
        return format;
    }

    public String getDiscription(){
        return "\"" + getTitle() + " by " + author + " (" + format + ")\"";
    }

    public String toString(){
        return getDiscription();
    }
}
