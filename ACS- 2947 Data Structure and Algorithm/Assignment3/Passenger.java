/**
 * Daljeet Singh
 * ACS-2947 Assignment-3
 */
import java.sql.Timestamp;
import java.util.Date;

public class Passenger implements Comparable<Passenger>{

    private String passportNumber;
    private FareCode fareCode;
    private FlyerStatus flyerStatus;
    private Timestamp timeStamp;

    public Passenger(String passportNumber, FareCode fareCode, FlyerStatus flyerStatus){
        this.passportNumber = passportNumber;
        this.fareCode = fareCode;
        this.flyerStatus = flyerStatus;
        this.timeStamp = new Timestamp(new Date().getTime());
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public FareCode getFareCode() {
        return fareCode;
    }

    public FlyerStatus getFlyerStatus() {
        return flyerStatus;
    }

    public Timestamp getTimestamp(){
        return timeStamp;
    }

    @Override
    public int compareTo(Passenger p) {
        int fareCompare = this.fareCode.compareTo(p.fareCode);
        int flyerCompare = this.flyerStatus.compareTo(p.flyerStatus);

        if(fareCompare != 0){
            return fareCompare;
        }
        if(flyerCompare != 0){
            return flyerCompare;
        }
        return this.timeStamp.compareTo(p.timeStamp);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append("Passport: " + passportNumber);
        sb.append(" Fare: " + fareCode);
        sb.append(" FlyerStatus: " + flyerStatus);
        sb.append(" Time: " + timeStamp);
        sb.append(")");

        return sb.toString();
    }


}
