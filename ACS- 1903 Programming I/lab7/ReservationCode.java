import java.util.Scanner;
/**
 * ACS-1903 Lab7 Q8
 * Daljeet Singh 3169763
 */
public class ReservationCode{
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the reservation code:");
        String code = kb.next();
        boolean isValid = validateCode(code);
        System.out.println(isValid ? "Valid" : "Invalid");
    }

    public static boolean validateCode(String code){
        if(code.length() != 6){
            return false;
            
        }
        for(int i = 0; i < code.length(); i++){
                char c = code.charAt(i);
                if(! Character.isLetter(c))
                return false;
            }
        return true;
    }
}