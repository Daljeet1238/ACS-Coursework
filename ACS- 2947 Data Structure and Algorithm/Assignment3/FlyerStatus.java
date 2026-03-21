/**
 * Daljeet Singh
 * ACS-2947 Assignment-3
 */
import java.util.Random;

public enum FlyerStatus {
    GOLD, SILVER, BRONZE, NONE;

    public static FlyerStatus randomValue(){
        Random rand = new Random();
        FlyerStatus[] values = FlyerStatus.values();
        return values[rand.nextInt(values().length)];
    }
}
