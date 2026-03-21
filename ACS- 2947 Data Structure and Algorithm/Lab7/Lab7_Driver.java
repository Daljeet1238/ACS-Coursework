/**
 * Daljeet Singh 3169763
 * ACS- 2947- 002
 * Lab -7
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab7_Driver{
    public static void main(String[] args) throws FileNotFoundException {
        ChainHashMap<String, RGBColor> h1 = new ChainHashMap<>();
        ChainHashMap<String, Integer> h2 = new ChainHashMap<>();

        System.out.println("Populating map from file:");

        Scanner sc = new Scanner(new File("data.csv"));
        while(sc.hasNextLine()){
            String line = sc.nextLine().trim();
            if(line.isEmpty()){
                sc.nextLine();
            }

            String[] values = line.split(",");
            if(values.length !=  4){
                sc.nextLine();
            }

            String colorName = values[0].trim();
            int red = Integer.parseInt(values[1].trim());
            int green = Integer.parseInt(values[2].trim());
            int blue = Integer.parseInt(values[3].trim());

            RGBColor rgbColor = new RGBColor(colorName, red, green, blue);
            RGBColor existingColor = h1.get(colorName);

            if(existingColor != null){
                if(existingColor.equals(rgbColor)){
                    System.out.println("Duplicate Ignored: " + colorName + "(" + red + ", " + green + ", " + blue + ")");
                }
                System.out.println("Duplicate: " + colorName + "(" + red + ", " + green + ", " + blue + ") replaced " + existingColor.getColor() +  "(" + existingColor.getRed() + ", " + existingColor.getGreen() + ", " + existingColor.getBlue() + ")");
                Integer count = h2.get(colorName);
                if(count == null){
                    count = 0;
                }
                count++;
                h2.put(colorName, count);

                String newColorName = colorName+count;

                System.out.println("Re-adding dupicate: " + newColorName + "(" + existingColor.getRed() + ", " + existingColor.getGreen() + ", " + existingColor.getBlue() + ")");
                h1.put(colorName, rgbColor);
            }else{
                h1.put(colorName, rgbColor);
            }
        }

        System.out.println("Number of colors added: " + h1.size());
        System.out.println();
        System.out.println("Total number of duplicated colors: " + h2.size());

        for(Entry<String, Integer> e : h2.entrySet()){
            System.out.println("Duplicate " + e.getKey() + "colors: " + e.getValue());
        }
    }
}