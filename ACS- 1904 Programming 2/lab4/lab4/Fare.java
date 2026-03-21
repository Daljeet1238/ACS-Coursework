
/**
 * Enumeration class Fare - write a description of the enum class here
 *
 * Daljeet Singh 3169763
 * 30th September, 2024
 */
public enum Fare {
    INFANT(4.50, 0, 4),
    YOUTH(9.40, 5, 17),
    ADULT(15.00, 18, 64),
    SENIOR(10.65, 65, 150);

    private double rate;
    private int minAge;
    private int maxAge;
    
    
    Fare(double rate, int minAge, int maxAge){
        this.rate = rate;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }
    
    public double getRate(){
        return rate;
    }
    
    public void setRate(double rate){
        this.rate = rate;
    }
    
    public int getMinAge(){
        return minAge;
    }
    
    public void setMinAge(int minAge){
        this.minAge = minAge;
    }
    
    public int getMaxAge(){
        return maxAge;
    }
    
    public void setMaxAge(int maxAge){
        this.maxAge = maxAge;
    }
    
    public static Fare determineFare(int age){
        if(age < 0 || age > 150){
            throw new IllegalArgumentException("Age must be between 0 to 150 years");
        }else{
            Fare[] fares = Fare.values();
            for(Fare fare : fares){
                if(age >= fare.getMinAge() && age <= fare.getMaxAge()){
                    return fare;
                }
            }
        }
        throw new IllegalArgumentException("Age must be between 0 and 150" + age);
    }
}