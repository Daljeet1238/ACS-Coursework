/**
 * ACS-2947 Assingment - 1
 * Daljeet Singh 3169763
 */

public class ArrayQueue<E> implements Queue<E> {
    private static final int CAPACITY = 1000;
    private E[] data;
    private int f = 0;
    private int sz = 0;

    //constructor for the class
    public ArrayQueue(){
        this(CAPACITY);
    }

    public ArrayQueue(int c){
        data = (E[]) new Object[c];
    }

    //methods

    //returns the number of elements in the queue
    public int size(){
        return sz;
    }

    //returns whether queue is empty or not
    public boolean isEmpty(){
        return sz == 0;
    }

    //Insert an element at the rear of the queue
    public void enqueue(E e) throws IllegalStateException {
        if(sz == data.length) throw new IllegalStateException("Queue is full");
        int avail = (f + sz) % data.length;
        data[avail] = e;
        sz++;
    }

    //return (but does not remove) the first element of the queue
    public E first(){
        if(isEmpty()){
            return null;
        }else{
            return data[f];
        }
    }

    //return and remove the first element of the queue
    public E dequeue(){
        if(isEmpty()) return null;
        E answer = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        sz--;
        return answer; 
        
    }
}
