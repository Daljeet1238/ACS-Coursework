
/**
 *
 * @author Daljeet Singh 3169763
 * @version 10th November, 2024
 */
public class Driver
{
    private Driver(){}

    public static void main(String[] args){
        Train t = new Train("Canadian Pacific 374");
        
        t.addTransport(new Person("Donald Smith", 65));
        t.addTransport(new Person("William Van Horne", 30));
        t.addTransport(new Person("Sandford Fleming", 17));
        t.addTransport(new Cargo("Canola", 24.22));
        t.addTransport(new Cargo("Grain", 450.8));

        System.out.println("All aboard " + t.getName() + "!");
        t.displayTransport();
        
    }
}
