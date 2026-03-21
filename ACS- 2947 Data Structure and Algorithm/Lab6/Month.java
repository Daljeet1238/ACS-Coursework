/**
 * Name: Daljeet Singh
 * Student#: 3169763
 */

public class Month implements Comparable<Month>{
    private String monthName;                                   // reference to the name of the month
    private int monthNumber;                                    // reference to the number of the month of the year
    private int days;                                           // reference to the total number of days in the month
    private int workingDays;                                    // reference to the working days of the month

    /**
     * Full argument constructor of the month class
     * @param monthName name of the month
     * @param monthNumber number of the month
     * @param days days in the month
     * @param workingDays working days in the month
     */
    public Month(String monthName, int monthNumber, int days, int workingDays){
        this.monthName = monthName;
        this.monthNumber = monthNumber;
        this.days = days;
        this.workingDays = workingDays;
    }

    // getters for the class

    public String getMonthName(){
        return monthName;
    }

    public int getMonthNumber(){
        return monthNumber;
    }

    public int getDays(){
        return days;
    }

    public int getworkingdays(){
        return workingDays;
    }

    //setters for the class

    public void setMonthName(String monthName){
        this.monthName = monthName;
    }

    public void setMonthNumber(int monthNumber){
        this.monthNumber = monthNumber;
    }

    public void setDays(int days){
        this.days = days;
    }

    public void setWorkingDays(int workingDays){
        this.workingDays = workingDays;
    }

    /**
     * Method that calculates the number of non-working days in the month
     * @return number of non-working days in that month
     */
    public int freeDays(){
        return days - workingDays;
    }

    @Override
    // compareTo method for the comparable class
    public int compareTo(Month month1) {
        return monthNumber - month1.monthNumber;
    }

    // toString method for the class
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(monthName + " ");
        sb.append(days + " ");
        sb.append(workingDays);
        return sb.toString();
    }
}
