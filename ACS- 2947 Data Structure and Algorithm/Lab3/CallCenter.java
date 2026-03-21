/**
 * DSA ACS-2947
 * Lab-3 
 * Daljeet Singh 3169763
 */

public class CallCenter {
    public static void main(String[] args) {
        LinkedJavaQueue<String> waitingList = new LinkedJavaQueue<>();      //declares the queue of String

        /**
         * add allisha, anna, nick to the queue
         */
        waitingList.enqueue("Allisha");
        waitingList.enqueue("Anna");
        waitingList.enqueue("Nick");

        System.out.println("Currently waiting: " + waitingList);

        /**
         * add joy the queue
         */
        waitingList.enqueue("Joy");

        System.out.println("Currently waiting: " + waitingList);

        /**
         * add brendan and rebecca in the queue
         */
        waitingList.enqueue("Brendan");
        waitingList.enqueue("Rebecca");

        System.out.println("Currently Waiting: " + waitingList);
        System.out.println("An agent will now answer Allisha.");

        /**
         * remove the first element from the queue
         */
        waitingList.dequeue();

        System.out.println("Currently waiting: " + waitingList);

        /**
         * add ryan to the queue
         */
        waitingList.enqueue("Ryan");

        System.out.println("The next customer to be answered is Anna");
        System.out.println("Currently Waiting: " + waitingList);

        /**
         * remove first three element from the queue
         */
        waitingList.dequeue();
        waitingList.dequeue();
        waitingList.dequeue();

        System.out.println("An agent will now answer Anna");
        System.out.println("An agent will now answer Nick");
        System.out.println("An agent will now answer Joy");

        //show the number of waiting list left
        System.out.println("Number of customer waiting: " + waitingList.size());

        System.out.println("An agent will now answer Brendan");
        System.out.println("An agent will now answer Rebecca");

        /**
         * remove the first two element from the queue
         */
        waitingList.dequeue();
        waitingList.dequeue();

        System.out.println("Number of customer waiting: " + waitingList.size());

        System.out.println("Currently waiting: " + waitingList);
    }
}
