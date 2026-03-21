/**
 * Name: Daljeet Singh
 * Student#: 3169763
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * ACS-2947 
 * Lab 5 
 * A Dynamic ArrayQueue Class that implements Iterable interface 
 */
public class ArrayQueue<E> implements Queue<E> {
    private static final int CAPACITY = 4;
    private E[] data;
    private int f = 0;
    private int size = 0;

    public ArrayQueue() { this(CAPACITY); }
    public ArrayQueue(int cap) { data = (E[]) new Object[cap];}

    /**
     * Returns the size of the Queue
     * @return int
     */
    public int size() { return size; }

    /**
     * Checks if the Queue is empty.
     * @return boolean
     */
    public boolean isEmpty() { return size == 0; }
        
    /**
     * Returns but does not remove the first element of the Queue. Null if Queue is empty.
     * @return E
     */
    public E first() {
        if(isEmpty()) return null;
        return data[f];
    }

    /**
     * Returns and removes the first element of the Queue. Null if empty.
     * @return E
     */
    public E dequeue() {
        if(isEmpty()) return null;
        E ans = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        size--;
        return ans;
    }
    
    /**
     * method that resize the capacity of the array
     * @param capacity new capacity of the array
     */
    private void resize(int capacity){
        E[] temp = (E[]) new Object[capacity];
        for(int k = 0; k < size; k++){
            temp[k] = data[(f + k) % data.length];
        }
        data = temp;
        f = 0;
    }

    /**
     * insert element at the rear of the queue
     */
    public void enqueue(E e){
        if(size == data.length)
            resize(size * 2);
        int avail = (f + size) % data.length;
        data[avail] = e;
        size++;
    }

    // toString method of the ArrayQueue class
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(E e : data){
            sb.append(e);
        }
        return sb.toString();
    }
    
    
    public void clear(){
        data = (E[]) new Object[CAPACITY];
        f = 0;
        size = 0;
    }
          
    private class ArrayIterator implements Iterator<E> {
        private int j = 0;      
        public boolean hasNext() {
            return j < size;
        }

        // rerturn the next object in the iterator
        public E next() throws NoSuchElementException {   
        	if(j == size) throw new NoSuchElementException("No next Element");
            E e = data[(f + j) % data.length];
            j++;
            return e;
        }

        public void remove() {throw new UnsupportedOperationException();}
        
    }

    public Iterator<E> iterator() {
        return new ArrayIterator();
    }
}
