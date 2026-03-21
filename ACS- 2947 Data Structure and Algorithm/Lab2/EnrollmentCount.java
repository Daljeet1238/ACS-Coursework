
/**
 * Daljeet Singh 3169763
 * ACS-2947
 */

public class EnrollmentCount {
    
    //Declaring the private integers.
    private int available;
    private int capacity;
    private int waitlisted;

    //Making the constructor for the EnrollmentCount class
    public EnrollmentCount(int avail, int cap, int wait){
        available = avail;
        capacity = cap;
        waitlisted = wait;
    }

    //getters
    public int getAvailable(){
        return available;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getWaitlisted(){
        return waitlisted;
    }

    @Override
    //Construct the toString method using the StringBuilder.
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(available);
        sb.append("/");
        sb.append(capacity);
        sb.append("/");
        sb.append(waitlisted);

        return sb.toString();
    }
}