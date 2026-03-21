
/**
 * Daljeet Singh 3169763
 * ACS-2947
 *  Lab 2 Extra
 */

public class ReportMarks {
    private int numReports = 0;     //number of actual entries added
    private BookReport[] marks;     //array of BookReports    
    
    public ReportMarks(int capacity){
        marks = new BookReport[capacity];
    }
    
    /*Add book report to the appropriate place by order of mark*/
    public void AddMark(BookReport e){
        
        /*** Place code for question 2 here ***/
        
    }

    public String toString(){  
        String s = "";
        for (BookReport br: marks)
            s = s + br + "\n";
        return s;
    }
    
    public static void main (String args[]){
        ReportMarks marks = new ReportMarks(7);
        marks.AddMark(new BookReport("Jane", 14, false));
        marks.AddMark(new BookReport("Martin", 20, true));
        marks.AddMark(new BookReport("Steve", 10, true));
        marks.AddMark(new BookReport("Helen", 18, true));
        marks.AddMark(new BookReport("Chris", 20, false));
        marks.AddMark(new BookReport("Alex", 12, true));
        marks.AddMark(new BookReport("Eve", 15, true));
        System.out.println(marks);
           
    }
}

