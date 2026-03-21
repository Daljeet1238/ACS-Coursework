/**
 * Daljeet Singh 3169763
 * Assignment 3 Question 2
 */
import java.util.Random;
public class Guitar{
    private String make;
    private String model;
    private String woodType;
    private String date;
    private String factory;
    private static int position = 100;
    private String serial;
    
    public Guitar(){
        make = "unknown";
        woodType = "unknown";
        date = "unknown";
        factory = "unknown";
        model = "unknown";
        position = 100;
        serial = generatingSerial();
    }
    
    public Guitar(String model, String woodType, String date, String factory){
        //this.make = make;
        this.model = model;
        this.woodType = woodType;
        this.date = date;
        this.factory = factory;
        this.position = 100;
        this.serial = generatingSerial();
    }
    
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
    
    public String getModel(){
        return model;
    }
    
    public void setModel(String model){
        this.model = model;
    }
    
    public String getWoodType() {
        return woodType;
    }

    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    private int generatingPosition() {
        return position++;
    }

    private String generatingSerial(){
        int factoryNumber = (this.factory.equals("USA")) ? 1 : 2;
        
        int lastIndex = -1;
        for (int i = date.length() - 1; i >= 0; i--) {
            if (date.charAt(i) == ' ') {
                lastIndex = i;
            }
        }
        String month = date.substring(0, date.indexOf(" "));
        String dayString = date.substring(date.indexOf(" ") + 1, lastIndex);
        int day = Integer.parseInt(dayString);
        int year = Integer.parseInt(date.substring(lastIndex + 1)) % 100;
        int monthNum = getMonth(month);
        
        String serialNumber = "" + factoryNumber + (year < 10 ? "0" : "") + year + (monthNum < 10 ? "0" : "") + monthNum + (day < 10 ? "0" : "") + day + (generatingPosition() < 10 ? "0" : "") + generatingPosition();
        return serialNumber;
    }
    
    private int getMonth(String month){
        switch(month){
            case "January": 
                return 1;
            case "February": 
                return 2;
            case "March": 
                return 3;
            case "April": 
                return 4;
            case "May": 
                return 5;
            case "June": 
                return 6;
            case "July": 
                return 7;
            case "August": 
                return 8;
            case "September": 
                return 9;
            case "October": 
                return 10;
            case "November": 
                return 11;
            case "December": 
                return 12;
            default: 
                return 0; 
        }
    }
    
    public String getSerial() {
        return serial;
    }
    
    public String toString(){
        return generatingSerial() + " " + model + ", " + woodType; 
    }
    public boolean equals(Guitar g){
        return  position==g.position && make==g.make && woodType==g.woodType;
    }
}
