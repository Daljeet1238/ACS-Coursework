import java.util.Arrays;
import java.util.Random;

/**
 * Write a description of class Driver here.
 *
 * Daljeet Singh 3169763
 * 14th October, 2024
 */
public class Driver{
    public static void main(String[] args){
        int[] array = new int[51];
        Random rand = new Random();
        for(int i = 0; i < array.length; i++){
            array[i] = i;
        }
        
        for(int i = 0; i < 100; i++){
            int randomInt = rand.nextInt(201) - 100;
            
            try{
                int value = accessElement(array, randomInt);
                System.out.println("testArray[" + randomInt + "]: " + value);
            }catch(ArrayIndexOverflowException e){
                System.out.println("testArray[" + randomInt + "]: " + array[array.length - 1]);
            }catch(ArrayIndexUnderflowException e){
                System.out.println("testArray[" + randomInt + "]: " + "Underflow!");
            }
        }
    }
    
    public static int accessElement(int[] array,int index){
        int length = array.length;
        
        if(index > length - 1){
            throw new ArrayIndexOverflowException(index, length);
        }
        else if(index < 0){
            throw new ArrayIndexUnderflowException(index, length);
        }else{
            return array[index];
        }
    }
}
