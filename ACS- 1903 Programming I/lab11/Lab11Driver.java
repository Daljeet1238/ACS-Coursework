/**
 * ACS-1903 Lab 11
 * Daljeet Singh 3169763
 */

import java.util.ArrayList;

public class Lab11Driver{
    public static void main(String[] args){
        ArrayList<Item> items = new ArrayList<>();
        
        Item firstItem = new Item("drink" , 1.75);
        Item secondItem = new Item("chips" , 2.65);
        Item thirdItem = new Item("popcorn" , 4.75);
        
        items.add(firstItem);
        items.add(secondItem);
        items.add(thirdItem);
        
        items.add(new Item("candy" , 2.35));
        
        for(Item item : items){
            System.out.println(item);
        }
    }
}
