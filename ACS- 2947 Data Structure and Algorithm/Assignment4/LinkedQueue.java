/**
 * Daljeet Singh 3169763
 * ACS- 2947- 002
 * Assignment - 4
 */

import java.util.LinkedList;

public class LinkedQueue<E> implements Queue<E>{
    private LinkedList<E> list;         //declare a linkedlist list

    public LinkedQueue(){
        this.list = new LinkedList<>();
    }

    /**
     * method returns the size of the linkedlist
     */
    @Override
    public int size(){
        return list.size();
    }

    /**
     * method tells whether the list is empty or not
     */
    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    /**
     * method adds the element to the end of the queue
     */
    @Override
    public void enqueue(E element){
        list.addLast(element);
    }

    /**
     * method returns the first element of the queue
     */
    @Override
    public E first(){
        return list.getFirst();
    }

    /**
     * method removes and returns the first element of the queue
     */
    @Override
    public E dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");         // throw exception if the queue is empty
        }else{
            return list.removeFirst();
        }
    }

    /**
     * returns the list in the form of String
     */
    @Override
    public String toString(){
        return list.toString();
    }
}