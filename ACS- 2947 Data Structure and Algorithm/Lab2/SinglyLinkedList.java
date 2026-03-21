
/**
 * Daljeet Singh 3169763
 * ACS-2947
 */

public class SinglyLinkedList<E> {
    
    //---------nested Node class----------
    private static class Node<E> {
        private E element;          // refernnece to the element store in Node
        private Node<E> next;       // reference to the next Node in the List

        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }

        public E getElement(){
            return element;
        }

        public Node<E> getNext(){
            return next;
        }

        public void setNext(Node<E> n){
            next = n;
        }
    } //------end of Nested Node---------

    private Node<E> head = null;        //head Node of the list
    private Node<E> tail = null;        //last Node of the list
    private int size = 0;

    //construct the initially empty list
    public SinglyLinkedList() {}

    //return size of the list
    public int size(){
        return size;
    }

    //boolean tells the list is empty or not
    public boolean isEmpty(){
        return size == 0;
    }

    //adds the element to the front of list 
    public void addFirst(E e){
        head = new Node<>(e,head);
        if(size == 0){
            tail = head;
        }
        size++;
    }

    //adds element to the back of the list
    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if(isEmpty()){
            head = newest;
        }else{
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    @Override
    //toString method to provide the output using StringBuilder.
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = head;
        while(current != null){
            sb.append(current.getElement());
            current = current.getNext();
            if(current != null){
                sb.append("\n");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}