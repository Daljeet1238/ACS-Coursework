/**
 * Daljeet Singh 3169763
 * 
 * This class contains an example of an enumerated type.
 * The task is to: 
 * 	1. Run the code and understand what it does. Then,
 * 		Uncomment the commented code section and understand and briefly explain 
 * 		what the alternate definition of the enum does. 
 *  
 *  @author ACS-2947 Lab 0
 *  
 */
public class EnumDemo {
  //public enum Day {MON, TUE, WED, THU, FRI, SAT, SUN};
  
  
  /**
   * This enum provide the specific values to the days
   * With the constructor String numbers are assigned to the days
   * It override the toString method which change the natural behaviour of the toString and return the number.
   * Now when we call the main method numbers will show instead of names of the days.
   */
  //This is an enhanced enum for Day.
  public enum Day{
	  MON("1"), TUE("2"), WED("3"), THU("4"), FRI("5"), SAT("6"), SUN("7");
	  private String display;
    private Day(String display){
	      this.display = display;
	  }
	  public String toString(){
        return display;
	  }
	}
  public static void main(String[] args) {
    Day d = Day.MON;
    System.out.println("We always start from day: " + d);  // enum is printed as "1" or "MON" depending on enum
    switchDemo(d);
    
    d = Day.WED;
    System.out.println("Then it is day: " + d);
    switchDemo(d);
    
    System.out.println("\nNo!, it goes like this... \n");
    
    for (Day a : Day.values()) {
      System.out.println("Day " + a);
      switchDemo(a);
    }
  }

  public static void switchDemo(Day d) {
      switch (d) {
        case MON:
          System.out.println("This is tough.");
          break;
        case TUE:
          System.out.println("This is getting better.");
          break;
        case WED:
          System.out.println("Half way there.");
          break;
        case THU:
          System.out.println("I can see the light.");
          break;
        case FRI:
          System.out.println("Now we are talking.");
          break;
        default:
          System.out.println("Day off!");
      }
  }

}


