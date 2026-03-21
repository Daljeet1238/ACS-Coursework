
/**
 * Daljeet Singh 3169763
 * ACS-2947
 */

public class Lab2_Driver {
    public static void main(String[] args) {
        
        //creating the instances of the enrollmentCount 
        EnrollmentCount enroll1 = new EnrollmentCount(2, 60, 8);
        EnrollmentCount enroll2 = new EnrollmentCount(1, 59, 3);
        EnrollmentCount enroll3 = new EnrollmentCount(11, 60, 0);
        EnrollmentCount enroll4 = new EnrollmentCount(12, 45, 2);

        //creating the instances of the pair class.
        Pair<String, EnrollmentCount> course1 = new Pair<>("ACS-2947-002: ", enroll1);
        Pair<String, EnrollmentCount> course2 = new Pair<>("ACS-2947-003: ", enroll2);
        Pair<String, EnrollmentCount> course3 = new Pair<>("ACS-2814-001: ", enroll3);
        Pair<String, EnrollmentCount> course4 = new Pair<>("ACS-1904-001: ", enroll4);

        System.out.println(course1);            //prints the course1
        System.out.println(course2);            //prints the course2

        //counts the total registrations in both sectiopn and adds up.
        int registrations = (enroll1.getCapacity() - enroll1.getAvailable()) + (enroll2.getCapacity() - enroll2.getAvailable());

        System.out.println("Total current registration: " + registrations);
        System.out.println();

        //creates the instance of the duo class.
        Duo<String> foodPairing = new Duo<>("Chicken","Chips");
        foodPairing.setThing2("Vegetables");        //change the second element 
        System.out.println(foodPairing);               //prints the result

        System.out.println();

        //creates the instance of the SinglyLinkedlist.
        SinglyLinkedList<Pair<String, EnrollmentCount>> courseList = new SinglyLinkedList<>();

        //adds the course in the list
        courseList.addLast(course1);
        courseList.addLast(course2);
        courseList.addLast(course3);
        courseList.addLast(course4);
        
        //prints the list.
        System.out.println(courseList);
    }
}
