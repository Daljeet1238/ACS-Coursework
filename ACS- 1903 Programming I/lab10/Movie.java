/**
 * ACS-1903 Lab 10 Q8
 * Daljeet Singh
 */
public class Movie{
    private String title;       
    private int year;           
    
    public Movie(){
        title = "unknown";
    }
    
    public Movie(String t, int y){
        title = t;
        year = y;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String t){
        title = t;
    }
    
    public int getYear(){
        return year;
    }
    
    public void setYear(int y){
        year = y;
    }
}
