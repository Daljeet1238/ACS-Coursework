
/**
 *
 * @author Daljeet Singh 3169763
 * @version 10th November, 2024
 */
public class Person implements Transportable{
    private String name;
    private int age;

    Person(){
        this.name = "unknown";
        this.age = 0;
    }

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public double calculateFare(){
        double fare = 0;
        if(age <= 18){
            fare = 15.00;
        }else if(age >= 65){
            fare = 10.00;
        }else{
            fare = 25.50;
        }
        return fare;
    }

    @Override
    public String identify(){
        return name;
    }
}
