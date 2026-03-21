/**
 * Daljeet Singh
 * ACS-2947 Assignment-3
 */
public class LinkedStack<E> implements Stack<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    public LinkedStack() {};

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void push(E elemnet){
        list.addFirst(elemnet);
    }

    public E top(){
        return list.first();
    }

    public E pop(){
        return list.removeFirst();
    }
}
