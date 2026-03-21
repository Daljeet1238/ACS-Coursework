/**
 * Daljeet Singh 3169763
 * ACS- 2947- 002
 * Assignment - 4
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartB_Driver {
    public static void main(String[] args) throws FileNotFoundException{
        LinkedChainHashMap<String, PostalCode> map = new LinkedChainHashMap<>();

        Scanner sc = new Scanner(new File("PartB.txt"));

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] parts = line.split(",");

            String code = parts[0].trim();
            String area = parts[1].trim();
            String province = parts[2].trim();
            double latitude = Double.parseDouble(parts[3].trim());
            double longitude = Double.parseDouble(parts[4].trim());

            PostalCode postalCode = new PostalCode(code, area, province, latitude, longitude);
            map.put(code, postalCode);

        }
        sc.close();

        System.out.println("Total number of entries: " + map.size());
        System.out.println("Number of collisions: " + map.getCollisions());

        Queue<PostalCode> postalCodes = new LinkedQueue<>();
        for(Entry<String, PostalCode> entry : map.entrySet()){
            postalCodes.enqueue(entry.getValue());
        }

        Scanner userInput = new Scanner(System.in);
        System.out.println("Display by code (C) or Longitude (L) (any other key to quit)");
        String choice = userInput.nextLine().toUpperCase();

        Queue<PostalCode> sortQueue = new LinkedQueue<>();

        if(choice.equals("C")){
            QuickSort.quickSort(postalCodes);
            sortQueue = postalCodes;
        }else if(choice.equals("L")){
            QuickSort.quickSort(postalCodes, new OrderByLongitude());
            sortQueue = postalCodes;
        }

        while (!sortQueue.isEmpty()) {
            System.out.println(sortQueue.dequeue());
        }

        System.out.println("Inserting an Entry where the same key previously exists in the map: ");
        PostalCode copy = new PostalCode("T0A", "Eastern Alberta (St. Paul)", "AB", 54.766, -111.7174);
        map.put("T0A", copy);

        System.out.println("Removing key T0A");
        PostalCode removed = map.remove("T0A");
        System.out.println("Removed value: " + removed);

        PostalCode UWinnipeg = new PostalCode("R3B 2E9", "Postal Avenue", "MB", 49.891911, -97.153565);
        map.put("R3B 2E9", UWinnipeg);

        PostalCode UWinnipeg1 = map.get("R3B 2E9");
        System.out.println("University of winnipeg latitude: " + UWinnipeg1.getLatitude());

        userInput.close();
    }
}

