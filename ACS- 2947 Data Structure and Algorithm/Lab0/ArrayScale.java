/**
 * Daljeet Singh 3169763
 * 
 * This is an example of Javadoc documentation. 
 * It has two examples of methods for scaling a numeric array.
 * The task is to:
 * 		1. Describe the difference between the scale1 and scale2 methods in at most two sentences.
 *  Ans: scale1 use the enhanced for loop on the other hand scale2 use the simple for loop using the length and indexes of the array.
 * 
 * 		2. Identify which one accurately scales the array and explain why.
 *  Ans: scale2 will work accurately because it changes the original array using the indexes on the other hand scale1 use enhanced for loop
 *       which make the copies for the original array.
 * 
 * @author ACS-2947 Lab 0
 * Adapted from Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 * 
 */
public class ArrayScale {
  public static void scale1(double[] data, double factor) {
    for (double val : data)
      val *= factor;                     
  }

  public static void scale2(double[] data, double factor) {
    for (int j=0; j < data.length; j++)
      data[j] *= factor;                  
  }

  /**
   * Print method that uses StringBuilder to display every element of an array
   * @param data
   */
  public static void print(double[] data) {
    StringBuilder sb = new StringBuilder();
    for (double val : data)
      sb.append(" " + val);
    sb.append("\n");
    System.out.println(sb);
  }

  public static void main(String[] args) {
    double[] sample = {1.0, 2.0, 3.0, 4.0};
    print(sample);
    scale1(sample, 2);
    print(sample);
    scale2(sample, 3);
    print(sample);
  }
}
