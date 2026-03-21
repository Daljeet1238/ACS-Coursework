
/**
 * Testing our person class
 *
 * @author Daljeet Singh 3169763
 * @version 17th Nov, 2024
 */
public class Driver
{
    public static void main(String[] args){
        Person alice = new Person("alice");
        Person robert = new Person("robert");
        Person maria = new Person("maria");
        Person john = new Person("john");
        Person anna = new Person("anna");
        Person peter = new Person("peter");
        Person kate = new Person("kate");
        
        //setting the parents.
        alice.setParent(robert, maria);
        robert.setParent(john, anna);
        maria.setParent(peter, kate);

        //executing the checkFamily function to find the family members.
        System.out.println("Does alice have an ancestor named anna? " + alice.checkFamily("anna"));
        System.out.println("Does alice have an ancestor named alice? " + alice.checkFamily("alice"));
        System.out.println("Does alice have an ancestor named thomas? " + alice.checkFamily("thomas"));
        System.out.println("Does alice have an ancestor named thomas? " + robert.checkFamily("alice"));
        System.out.println("Does maria have an ancestor named kate? " + maria.checkFamily("kate"));
        System.out.println("Does robert have an ancestor named maria? " + robert.checkFamily("maria"));
    }
}
