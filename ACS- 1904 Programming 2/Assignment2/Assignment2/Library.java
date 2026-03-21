import java.util.ArrayList;
import java.util.List;

/**
 * Daljeet Singh 3169763
 * 16th October, 2024
 */

public class Library{
    private List<Item> items;
    private String name;
    
    //Constructor
    public Library(String name){
        items = new ArrayList<>();
        this.name = name;
    }

    //Getters
    public String getName(){
        return name;
    }

    public List<Item> getItem(){
        return items;
    }

    //add method
    public void addItem(Item item){
        items.add(item);
    }
    
    //chekout method
    public Item checkout(String title) throws ItemNotFoundException{
        for(Item item: items){
            if(item.getTitle().equalsIgnoreCase(title)){
                items.remove(item);
                return item;
            }
        }
        throw new ItemNotFoundException(title + " not found in the items");
    }
}
