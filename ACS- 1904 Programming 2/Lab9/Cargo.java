
/**
 *
 * @author Daljeet Singh 3169763
 * @version 10th November, 2024
 */
public class Cargo implements Transportable{
    private String id;
    private double weight;

    public Cargo(){
        this.id = "";
        this.weight = 0.00;
    }

    public Cargo(String id, double weight){
        this.id = id;
        this.weight = weight;
    }

    @Override
    public double calculateFare(){
        return weight * 1.50;
    }

    @Override
    public String identify(){
        return id;
    }
}
