/*
 * Daljeet Singh 3169763
 * 27th Novemeber, 2024
 */

import java.util.Comparator;

public class Driver{
    public static void selectionSort(TrainCar head){
        if (head == null || head.getNextCar() == null) {
            return;
        }
    
        TrainCar smallestWeight = head;
        TrainCar current = head.getNextCar();
    
        while(current != null){
            if(current.getLoad() < smallestWeight.getLoad()){
                smallestWeight = current;
            }
            current = current.getNextCar();
        }

        if(smallestWeight != head){
            double load1 = head.getLoad();
            head.setLoad(smallestWeight.getLoad());
            smallestWeight.setLoad(load1);

            String cargo1 = head.getCargo();
            head.setCargo(smallestWeight.getCargo());
            smallestWeight.setCargo(cargo1);
        }

        selectionSort(head.getNextCar());
        
    }
    
    public static void selectionSort(TrainCar head, Comparator c) {
        if (head == null || head.getNextCar() == null) {
            return;
        }
    
        TrainCar smallest = head;
        TrainCar current = head.getNextCar();
    
        while (current != null) {
            if (c.compare(current, smallest) < 0) {
                smallest = current;
            }
            current = current.getNextCar();
        }
    
        if (smallest != head) {
            head.swapCargo(smallest);
        }
    
        selectionSort(head.getNextCar(), new OrderByCargo());
    }
    


    public static void main(String[] args){
        // Instantiate our train cars
        TrainCar a = new TrainCar("A", "wheat", 100);
        TrainCar b = new TrainCar("B", "oats", 120);
        TrainCar c = new TrainCar("C", "gold", 40);
        TrainCar d = new TrainCar("D", "pork", 50);
        TrainCar e = new TrainCar("E", "coal", 200);
        TrainCar f = new TrainCar("F", "canola", 45);
        TrainCar g = new TrainCar("G", "one really big egg", 150);

        // Link the cars together
        a.setNextCar(b);
        b.setNextCar(c);
        c.setNextCar(d);
        d.setNextCar(e);
        e.setNextCar(f);
        f.setNextCar(g);

        System.out.println("Unsorted:");
        a.printTrain();
        
        // Pass the head of the train to the sort method
        selectionSort(a);
        
        System.out.println("\nNatural Order:");
        a.printTrain();
        
        // Now use the alternate sort
        selectionSort(a, new OrderByCargo());
        
        System.out.println("\nAlternate Order:");
        a.printTrain();
    }
}
