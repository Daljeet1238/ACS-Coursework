/**
 * Assignment 2 Question 1
 * Daljeet Singh 3169763
 */
import javax.swing.JOptionPane;

public class SerialDecoder{
    public static void main(String[] args){
        String input1, input2; 
        int length;
        do{
            input1 = JOptionPane.showInputDialog("Enter a 10-digit Taylor Guitar serial number:");
            length = input1.length();
            char initial = input1.charAt(0);
            if(length == 10){
                if(initial == '1' || initial == '2'){
                    char first = input1.charAt(0);
                    String location = getLocation(first);
                    String year = getYear(input1);
                    String month = getMonth(input1);
                    String day = getDay(input1);
                    String position = getPosition(input1);
                    displayInformation(location, year, month, day, position);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not a Taylor Guitar");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Not a Taylor Guitar");
            }
            input2 = JOptionPane.showInputDialog("Do you want to enter another? y/n");
            
        }while(!input2.equals("n"));
        JOptionPane.showMessageDialog(null, "Goodbye!");
    }
    public static String getLocation(char first){
       String locationName = ""; 
       switch (first){
           case '1': locationName = "USA";
               break;
           case '2': locationName = "Mexico";
               break;
           default: locationName = "Invalid";
       }
       return locationName;
    }
    public static String getYear(String input1){
        String year = "20"+ input1.charAt(1) + input1.charAt(6);
        return year;
    }
    public static String getMonth(String input1){
        String monthnumber = input1.substring(2,4);
        String month ="";
        switch(monthnumber){
            case "01": month = "January";
                break;
            case "02": month = "Febuary";
                break;
            case "03": month = "March";
                break;
            case "04": month = "April";
                break;
            case "05": month = "May";
                break;
            case "06": month = "June";
                break;
            case "07": month = "July";
                break;
            case "08": month = "August";
                break;
            case "09": month = "September";
                break;
            case "10": month = "October";
                break;
            case "11": month = "November";
                break;
            case "12": month = "December";
                break;
            default: month = "Invalid";
        }
        return month;
    }
    public static String getDay(String input1){
        String day = input1.substring(4,6);
        return day;
    }
    public static String getPosition(String input1){
        String position = input1.substring(7,input1.length());
        return position;
    }
    public static void displayInformation(String locationame, String year, String month, String day, String position){
        JOptionPane.showMessageDialog(null, "Taylor Guitar, made in " + locationame + "\nProduction start date: " + day + "-" + month + "-" + year + "\nPosiotion: " + position);
    }
}
