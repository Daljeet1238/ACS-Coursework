
/**
 * Write a description of class Lab04 here.
 *
 * 30th September 2024
 * Daljeet Singh 3169763
 */
public class Lab04
{
    public static void main(String[] args){
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eden", "Frank", "George"};
        int[] ages = {30, 79, 1, 15, 17, 22, 65};
        
        StringBuilder sb1 = new StringBuilder();
        
        String passengers = "";
        int age = 0;
        for(int i = 0; i < names.length; i++){
            passengers = names[i];
            age = ages[i];
            
            Fare fare = Fare.determineFare(age);
            
            if(age > 0 || age < 150){
                sb1.append(passengers + " : $" + fare.getRate() + ", " + fare.name() + "\n");
            }else{
                throw new IllegalArgumentException("Age must be in between 0 and 150");
            }
        }
        System.out.println(sb1.toString());
    }
}
