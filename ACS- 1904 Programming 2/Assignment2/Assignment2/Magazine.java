
/**
 * Daljeet Singh 3169763
 * 16th October, 2024
 */

public class Magazine extends Item{
    private String publisher;
    private int pageCount;
    private String edition;

    //constructor
    public Magazine(String publisher, int pageCount, String edition, int identificationNUmber, String title, Genre genre){
        super(identificationNUmber, title, genre);
        this.publisher = publisher;
        this.pageCount = pageCount;
        this.edition = edition;
    }
    
    //getters
    public String getPublisher(){
        return publisher;
    }

    public int getPageCount(){
        return pageCount;
    }

    public String getEdition(){
        return edition;
    }

    public String getDiscription(){
        return ("\"" + getTitle() + "(" + edition + ")\"");
    }
    public String toString(){
        return getDiscription();
    }
}


