
/**
 * Daljeet Singh 3169763
 * 16th October, 2024
 */

public class Movie extends Item{
    private String director;
    private String studio;
    private int runTime;

    //constructor
    public Movie (String director, String studio, int runtime, int identificationNUmber, String title, Genre genre){
        super(identificationNUmber, title, genre);
        this.director = director;
        this.studio = studio;
        this. runTime = runtime;
    }

    //getters
    public String getDirector(){
        return director;
    }

    public String getStudio(){
        return studio;
    }

    public int getRunTime(){
        return runTime;
    }

    public String getDiscription(){
        return "\"" + getTitle() + " directed by " + director + "\"";
    }

    public String toString(){
        return getDiscription();
    }
}

 