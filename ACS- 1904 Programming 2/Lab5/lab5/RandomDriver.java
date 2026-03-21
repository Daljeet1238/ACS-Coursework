
/**
 * Write a description of class RandomDriver here.
 *
 * Daljeet Singh
 * 6th October, 2024
 */
public class RandomDriver{
    public static void main(String[] args){
        RandomUtils randomUtils = new RandomUtils();
        
        int numberInt = randomUtils.generateInt();
        System.out.println("Random Integer: " + numberInt);
        
        double numberDouble = randomUtils.nextDouble();
        System.out.println("Random Double: " + numberDouble);
        
        double numberDouble100 = randomUtils.nextDouble(-100, 100);
        System.out.println("Random double between -100 and 100: " + numberDouble100);
        
        System.out.println("Random vector of length 5:");
        double[] vector1 = randomUtils.generateVector(5);
        for (double value : vector1) {
            System.out.print(value +", ");
        }
        
        System.out.println("\n");
        
        System.out.println("Random vector of length with values between -100 and 100:");  
        double[] vector2 = randomUtils.generateVector(5, -100, 100);
        //Iterating through the array.
        for(double value : vector2){
            System.out.print(value + ", ");
        }
        
        System.out.println("\n");
        
        System.out.println("Random matrix of size (2,4):");
        double[][] matrix1 = randomUtils.generateMatrix(2 , 4);
        //Iterating through the array and provide the values which made a matrix.
        for(double[] row : matrix1){
            for(double value : row){
                System.out.print(value + " ");
            }
            System.out.println("");
        }
        
        System.out.println("\n");
        
        System.out.println("Random matrix of size(2,4) with values between -100 and 100:");
        double[][] matrix2 = randomUtils.generateMatrix(2 , 4 , -100 , 100);
        for(double[] row : matrix2){
            for(double value : row){
                System.out.print(value + " ");
            }
            System.out.println("");
        }
    }
}
