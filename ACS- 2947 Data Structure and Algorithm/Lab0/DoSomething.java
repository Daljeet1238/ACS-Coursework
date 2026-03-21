/**
 * Daljeet Singh 3169763
 * 
 * This is an example of Javadoc documentation. 
 * The task is to:
 * 		1. Describe what the doSomething method does in at most 3 sentences as a Javadoc documentation. 
 *  Ans: doSomething takes 2 parameters an array of int(d) and an integer(t).
 *       It iterates over the array until it reaches the provided integer or the end of the array.
 *       It returns the index of the provided value or the length of the array.
 *       
 * 		2. Include a main method to call doSomething with some appropriate data and display the returned value.
 *
 * @author ACS-2947 Lab 0
 * Adapted from Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 * 
 */
class DoSomething {
 
  public static int doSomething(int[] d, int t) {
    int j = 0;
    while ((j < d.length) && (d[j] != t))
      j++;
    return j;                       
  }

  public static void main(String[] args){
    int[] arr = {1, 2, 3, 4, 5};

    System.out.println(doSomething(arr, 1));
    System.out.println();

    System.out.println(doSomething(arr, 0));
  }

}
