
/**
 * Daljeet Singh 3169763
 * 16th October, 2024
 */

public class Item{
    protected int identificationNumber;
    protected String title;
    protected Genre genre;
    
    //Contructor
    public Item(int identificationNumber, String title, Genre genre){
        this.identificationNumber = identificationNumber;
        this.title = title;
        this.genre = genre;
    }

    //Getters
    public int getIdentificationNumber(){
        return identificationNumber;
    }

    public String getTitle(){
        return title;
    }

    public Genre getGenre(){
        return genre;
    }
}
