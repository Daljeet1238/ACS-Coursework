/*
 * 
 * Daljeet Singh 3169763
 * 24th November, 2024
 */


import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class Lab11{

    public static void quickSort(ArrayList<String> a){
        if(a == null || a.size() <= 1){
            return;
        }else{
            quickSort(a, 0, a.size() - 1);
        }
        
    }
    
	public static void quickSort(ArrayList<String> a, int start, int end){
        if(start >= end){
            return;
        }


        String pivot = a.get(start);
        int right = end;
        int left = start + 1;

        while(left <= right){
            while(left <= right && a.get(right).compareTo(pivot) > 0){
                right--;
            }

            while(left <= right && a.get(left).compareTo(pivot) <= 0){
                left++;
            }

            if(left < right){
                String value = a.get(left);
                a.set(left, a.get(right));
                a.set(right, value);

            }

        }
        a.set(start, a.get(right));
        a.set(right, pivot);

        quickSort(a, start, right - 1);
        quickSort(a, right + 1, end);	
	}
	
    public static void insertionSort(ArrayList<String> a){
        int length = a.size();

        for(int i=1; i<length; i++ ){
            String x = a.get(i);

            int j = i-1;
            while(j >= 0 && a.get(j).compareTo(x) > 0){
                a.set(j + 1,a.get(j));
                j--;
            }
            a.set(++j, x);
        }
    }
    
    public static void main(String[] args)
    {
        ArrayList<String> a = new ArrayList<String>();
        String[] names = {
            "Alfa", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India", 
            "Juliet", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", 
            "Romeo", "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "X-ray", "Yankee", "Zulu"
        };
        for(String name : names) a.add(name);
        System.out.println("Input:");
        System.out.println("\t" + Arrays.toString(a.toArray()));
        
        
        Collections.shuffle(a);
        System.out.println("Shuffled:");
        System.out.println("\t" + Arrays.toString(a.toArray()));
        insertionSort(a);
        System.out.println("Insertion Sorted:");
        System.out.println("\t" + Arrays.toString(a.toArray()));
        
        
        Collections.shuffle(a);
        System.out.println("Shuffled:");
        System.out.println("\t" + Arrays.toString(a.toArray()));
        quickSort(a);
        System.out.println("Quick Sorted:");
        System.out.println("\t" + Arrays.toString(a.toArray()));
        
    }
}
