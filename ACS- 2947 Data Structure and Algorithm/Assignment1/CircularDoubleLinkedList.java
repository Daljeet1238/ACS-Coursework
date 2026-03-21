/**
 * ACS-2947 Assingment - 1
 * Daljeet Singh 3169763
 */

public class CircularDoubleLinkedList <E> {
    //----------nested Node class-----------------
    public static class Node <E>{
        private E element;              // reference to the element stored in this node
        private Node<E> prev;           // reference to the previous node in the list
        private Node<E> next;           // reference to the nect node in the list

        /**
         * constructor for the node
         * @param e element stored in the node
         * @param p previous node
         * @param n next node
         */
        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }

        //method to get the element store in the node
        public E getElement(){
            return element;
        }

        //method to get the previos Node
        public Node<E> getPrev(){
            return prev;
        }

        //method to get the next Node
        public Node<E> getNext(){
            return next;
        }

        //method to set the previous Node
        public void setPrev(Node<E> p){
            prev = p;
        }

        //method to set the next Node 
        public void setNext(Node<E> n){
            next = n;
        }
    }
    //-------------end of the nested Node class----------------

    private Node<E> tail;               // instance variable for the CircularDoublyLinkedList
    private int size;                   // size of the lsit 

    /**
     * constructor for the circularDoublyLinkedList
     */
    public CircularDoubleLinkedList(){
        tail = null;
        size= 0;
    }

    //method return the size of the list
    public int size(){
        return size;
    }

    //method return returns whether the list is empty or not in the form of true and false
    public boolean isEmpty(){
        return size == 0;
    }

    //method return (but does not remove) the head or Node after the tail
    public E first(){
        if(isEmpty()) return null;
        return tail.getNext().getElement();
    }

    //method return (but does not remove) the previous element in the list
    public E last(){
        if(isEmpty()) return null;
        return tail.getElement();
    }

    /**
     * method adds element to the front of the list
     * @param e element which adds in the list
     */ 
    public void addFirst(E e){
        if(isEmpty()){
            tail = new Node<>(e, null, null);
            tail.setNext(tail);
            tail.setPrev(tail);
        }else{
            addBetween(e, tail, tail.getNext());        //insert between tail and the next element
        }
        size++;
    }

    /**
     * method  adds the element to the last of the list
     * @param e element which adds in the list 
     */
    public void addLast(E e){
        if(isEmpty()){
            tail = new Node<>(e, null, null);
            tail.setNext(tail);
            tail.setPrev(tail);
        }else{
            addBetween(e, tail, tail.getNext());            //insert between tail and next element
            tail = tail.getNext();
        }
        size++;
    }

    /**
     * method remove the first element of the list
     * @return removed element from the front
     */
    public E removeFirst(){
        Node<E> head = tail.getNext();
        if(isEmpty()){
            return null;
        }else if(size == 1){
            tail = null;
        }else{
            remove(head);           //remove the head from the queue
        }
        size--;
        return head.getElement();
        
    }

    //method advance the tail to the next element
    public void rotate(){
        if(isEmpty()){
            tail = null;
        }else{
           tail = tail.getNext(); 
        }
    }

    //method changes the order of direction
    public void reverse(){
        if(!isEmpty()){
            Node<E> current = tail;
            Node<E> temp = null;

            do{
                temp = current.getPrev();
                current.setPrev(current.getNext());
                current.setNext(temp);

                current = current.getNext();
            }while(current != tail);
        }
        tail = tail.getNext();
    }

    /**
     * method remove the last element from the list
     * @return removed element
     */
    public E removeLast(){
        Node<E> oldTail = tail;
        if(isEmpty()){
            return null;
        }else if(size == 1){
            tail = null;
        }else{
            remove(oldTail);
        }
        size--;
        tail = tail.getPrev();
        return oldTail.getElement();
    }

    /**
     * method adds the element to the circularlinkedlist in between the nodes
     * @param e element which is about to add
     * @param predecessor previous node
     * @param successor next node to the element
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor){
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    /**
     * removes the given node from the list 
     * @param node element which removes from the list
     * @return element removed
     */
    private E remove(Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();

        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
}//---------end of the CircularDoublyLinkedList----------------
