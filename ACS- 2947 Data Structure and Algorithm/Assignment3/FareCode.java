/**
 * Daljeet Singh
 * ACS-2947 Assignment-3
 */
import java.util.Random;

public enum FareCode {
    FULL, DISC, BUDDY;

    public static FareCode randomValue(){
        Random rand = new Random();
        FareCode[] values = FareCode.values();
        return values[rand.nextInt(values().length)]; 
    } 
}
