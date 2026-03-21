import java.util.ArrayList;

/**
 *
 * @author Daljeet Singh 3169763
 * @version 10th November, 2024
 */

public class Train {
    private String name;
    private ArrayList<Transportable> thing;

    public Train(String name){
        this.name = name;
        this.thing = new ArrayList<>();
    }

    public void addTransport(Transportable transport){
        thing.add(transport);
    }


    public String getName(){
        return name;
    }

    public void displayTransport(){
        for(Transportable thing : thing){
            System.out.println("Transport: " + thing.identify() + " Fare: $" + thing.calculateFare());
        }
    }
}
