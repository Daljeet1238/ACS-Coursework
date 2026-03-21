/**
 * Daljeet Singh 3169763
 */

public class Lab4_Driver {

    public static void main(String[] args) {
        LinkedPositionalList<Character> list = new LinkedPositionalList<>(); 
            
        for(char c = 'A'; c <='O'; c++){
            list.addFirst(c);
        }

        //declare the variable cursor and assign it first element
        Position<Character> cursor = list.first();
        displayList("Q2a:" , cursor, list);

        //move the cursor to the 9th position
        for(int i = 0; i < 8; i++){
            cursor = list.after(cursor);
        }
        displayList("Q2b:", cursor, list);

        //add letter Q and P
        list.addAfter(cursor, 'P');
        list.addBefore(cursor, 'Q');
        displayList("Q2c:", cursor, list);

        //move the cursor 5 position backwards
        for(int i = 0; i < 5; i++){
            cursor = list.before(cursor);
        }
        displayList("Q2d:", cursor, list);

        //change the letter after cursor and delete the item before the cursor
        list.set(list.after(cursor), 'Y');
        list.remove(list.before(cursor));
        displayList("Q2e:", cursor, list);
        
        //move the cursor 6 position forward and change the letter to S
        for(int i = 0; i < 6; i++){
            cursor = list.after(cursor);
        }
        list.set(cursor, 'S');
        displayList("Q2f:", cursor, list);

        //Add the letter A in the first position
        list.addFirst('A');
        displayList("Q2g:", cursor, list);

        //Reset the cursor to the first position and delete odd ASCII number valeus
        cursor = list.first();
        while(cursor != null){
            Position<Character> temp = list.after(cursor);
            if(cursor.getElement() % 2 != 0){
                list.remove(cursor);

            }
            cursor = temp;
        }
        displayList("Q2h:", cursor, list);

        //add letter Z at the end of the list
        list.addAfter(list.last(),'Z');
        displayList("Q2i:", cursor, list);

        //display the number of entries remaining in the list
        System.out.println("Number of entries remaining: " + list.size());
    }

    /**
     * method to show the result
     * @param question  String question number
     * @param cursor cursor position
     * @param list the whole list
     */
    public static void displayList(String question, Position<Character> cursor, PositionalList<Character> list){
        System.out.println(question);
        System.out.println("Cursor is at: " + (cursor != null ? cursor.getElement() : "null"));
        System.out.print("LPL contents: [");
        Position<Character> first = list.first();
        while(first != null){
            System.out.print(first.getElement());
            first = list.after(first);
            if(first != null){
                System.out.print(", ");
            } 
        }
        System.out.println("]\n");
    }
}