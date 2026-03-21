
/**
 * Daljeet Singh 3169763
 * ACS-2947
 *  Lab 2 Extra
 */

public class BookReport {
    private String name;        // student name
    private int mark;           // report mark
    private boolean onTime;     // true if on time, false if late
    
    public BookReport(String name, int mark, boolean onTime){
        this.name = name;
        this.mark = mark;
        this.onTime = onTime;
    }
    
    public String getStudentName(){
        return name;
    }
    
    public int getMark(){
        return mark;
    }
    
    public boolean getStatus(){
        return onTime;
    }
    
    public void setMark(int mark){
        this.mark = mark;
    }
    
    public String toString(){
        return name + ", " + mark; 
    }
    
}
