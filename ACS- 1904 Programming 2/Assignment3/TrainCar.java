/*
 * Daljeet Singh 3169763
 * 27th Novemeber, 2024
 */

public class TrainCar{
    private String name;
    private String cargo;
    private double load;
    private TrainCar nextCar;

    public TrainCar(){
        this.name = "unknown";
        this.cargo = "unknown";
        this.load = 0.00;
        this.nextCar = null;
    }

    public TrainCar(String name, String cargo, double load){
        this.name = name;
        this.cargo = cargo;
        this.load = load;
        this.nextCar = null;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCargo(){
        return cargo;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public double getLoad(){
        return load;
    }

    public void setLoad(double load){
        this.load = load;
    }

    public TrainCar getNextCar(){
        return nextCar;
    }

    public void setNextCar(TrainCar nextCar){
        this.nextCar = nextCar;
    }

    public void swapCargo(TrainCar t){
        String temp = this.cargo;
        this.cargo = t.cargo;
        t.cargo = temp;

        double temp1 = this.load;
        this.load = t.load;
        t.load = temp1;
    }

    public void printTrain(){
        System.out.println(this.toString());
        if(this.nextCar != null){
            this.nextCar.printTrain();
        }
    }

    public String toString(){
        return "Car " + name + ": " + cargo + " (" + load + ")";
    }
}