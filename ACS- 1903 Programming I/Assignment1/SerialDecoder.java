import javax.swing.JOptionPane;

/**
 *
 *Daljeet Singh 3169763
 */
public class SerialDecoder{
    public static void main(String[] args){
        String serialDecoder = JOptionPane.showInputDialog("Enter the 10-digit Taylor guitar serial number:");
        char year1 = serialDecoder.charAt(1);
        char year2 = serialDecoder.charAt(6);
        String month = serialDecoder.substring(2,4);
        String date = serialDecoder.substring(4,6);
        String position = serialDecoder.substring(7,10);
        String month1;
        if(month.equals("01")){
            month1 = "Jan";
        } else if(month.equals("02")){
            month1 = "Feb";
        }else if(month.equals("03")){
            month1 = "Mar";
        }else if(month.equals("04")){
            month1 = "Apr";
        }else if(month.equals("05")){
            month1 = "May";
        }else if(month.equals("06")){
            month1 = "Jun";
        }else if(month.equals("07")){
            month1 = "Jul";
        }else if(month.equals("08")){
            month1 = "Aug";
        }else if(month.equals("09")){
            month1 = "Sept";
        }else if(month.equals("10")){
            month1 = "Oct";
        }else if(month.equals("11")){
            month1 = "Nov";
        }else if(month.equals("12")){
            month1 = "Dec";
        }else {
            month1 = "Unknown";
        }
        if(serialDecoder.substring(0,1).equals("1")){
            JOptionPane.showMessageDialog(null, "Taylor Guitar, made in America, \nProducton start date:" + date + "-" + month1 + "-20" + year1 + year2 +"\n" + "Position: " + position);
        } else if(serialDecoder.substring(0,1).equals("2")){
            JOptionPane.showMessageDialog(null, "Taylor Guitar, made in Mexico, \nProducton start date:" + date + "-" + month1 + "-20" + year1 + year2 +"\n" + "Position: " + position);
        } else{
            JOptionPane.showMessageDialog(null, "Not a Taylor Guitar");   
        }
    }
}
