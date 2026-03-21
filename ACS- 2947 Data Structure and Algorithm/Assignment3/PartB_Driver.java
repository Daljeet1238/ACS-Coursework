/**
 * Daljeet Singh
 * ACS-2947 Assignment-3
 */
import java.util.Scanner;

public class PartB_Driver {
    public static void main(String[] args){
        HeapPriorityQueue<Passenger, String> standByList = new HeapPriorityQueue<>();
        Scanner sc = new Scanner(System.in);

        //adds 10 passengers
        for(int i = 0; i < 10; i++){
            System.out.println("Enter passport no of new passenger: ");
            String passport = sc.nextLine();
            FareCode fareCode = FareCode.randomValue();
            FlyerStatus flyerStatus = FlyerStatus.randomValue();
            Passenger passenger = new Passenger(passport, fareCode, flyerStatus);

            standByList.insert(passenger, passport);
            System.out.println("Adding passenger: " + passenger);
            System.out.print("Standby list: [" + standByList + "] \n");
        }

        //remove 5 passengers
        for(int i = 0; i < 5; i++){
            Entry<Passenger, String> remove = standByList.removeMin();
            System.out.println("Passenger " + remove.getKey() + "gets seated");
            System.out.println("Standby List: [" + standByList + "] \n");
        }

        for(int i = 0; i < 5; i++){
            System.out.println("Enter passport no of new passenger: ");
            String passport = sc.nextLine();
            FareCode fareCode = FareCode.randomValue();
            FlyerStatus flyerStatus = FlyerStatus.randomValue();
            Passenger passenger = new Passenger(passport, fareCode, flyerStatus);

            standByList.insert(passenger, passport);
            System.out.println("Adding passenger: " + passenger);
            System.out.print("Standby list: [" + standByList + "] \n");
        }

        while (!standByList.isEmpty()) {
            Entry<Passenger, String> remove = standByList.removeMin();
            System.out.println("Passenger " + remove.getKey() + "gets seated");
            System.out.println("Standby List: [" + standByList + "] \n");
        }

    }
}
