/**
 * ACS-1903 Lab 11
 * Daljeet Singh 3169763
 */

public class Item{
    private static int idNumber = 200;
    private int id;
    private String name;
    private double price;
    
    public Item(){
        this.id = idNumber++;
    }
    
    public Item(String name, double price){
        this.id = idNumber++;
        this.name = name;
        this.price = price;
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public String toString(){
        return id + ": " + name + " $" + price;  
    }
    
    public boolean equals(Item item) {
        return this.id == item.getId();
    }
}
