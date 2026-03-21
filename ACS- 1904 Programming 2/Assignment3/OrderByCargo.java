/*
 * Daljeet Singh 3169763
 * 27th Novemeber, 2024
 */

import java.util.Comparator;

public class OrderByCargo implements Comparator<TrainCar>{

    @Override
    public int compare(TrainCar o1, TrainCar o2) {
        return o1.getCargo().compareTo(o2.getCargo());
    }
    
}
