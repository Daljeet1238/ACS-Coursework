/**
 * Lab 5 Extra Work
 * @author 
 */

public class ExtraWork_Driver {
    public static void main (String[] args){
        PositionalList<Integer> list = new LinkedPositionalList<>();
        int[] temp = {8, 1, 8, 6, 2, 7, 5, 1, 2, 5, 5, 4, 0, 9, 1, 2, 9, 4};
        for (int i : temp)
            list.addLast(i);
        System.out.println("Original list: \n" + list);
    
    }
}
