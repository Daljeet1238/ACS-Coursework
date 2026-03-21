/**
 * ACS-1903 Assignment 3 Question 2
 * Sample Driver
 */

import java.util.ArrayList;

public class A3Q2Driver{
    public static void main(String[] args){
        
        // Create guitars and add to production list
        ArrayList<Guitar> production = new ArrayList<>();
        production.add(new Guitar());
        production.add(new Guitar("Baby Taylor", "Mahogany", "March 28 2024", "Mexico"));
        production.add(new Guitar("814ce Builder's Edition", "Sitka Spruce", "March 28 2024", "USA"));
        production.add(new Guitar("722ce Grand Concert", "Mahogany", "March 28 2024", "USA"));
        
        // set details for the first guitar
        production.get(0).setModel("Mini GS");
        production.get(0).setWoodType("Rosewood");
        production.get(0).setDate("March 28 2024");
        production.get(0).setFactory("Mexico");
        
        // display all guitars 
        System.out.println("Taylor Guitars in production on " + production.get(0).getDate());
        System.out.println("-----------------------------------------------");
        for (Guitar g : production){
            System.out.println(g);
        }
    }
}
