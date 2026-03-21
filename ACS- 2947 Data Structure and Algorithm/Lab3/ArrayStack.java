/**
 * DSA ACS-2947
 * Lab-3 
 * Daljeet Singh 3169763
 */


public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 1000;        // it is array's default capacity.
    private E[] data;                               // array to store the data.
    private int t = -1;                             // index of the top element.
    
    /**
     * constructor for ArrayStack with default cpacity.
     */
    public ArrayStack(){
        this(CAPACITY);
    }

    /**
     * constructor with the given capacity
     * @param capacity capacity of the array.
     */
    public ArrayStack(int capacity){
        data = (E[]) new Object[capacity];
    }

    /**
     * returns the size of the array.
     */
    public int size(){
        return t+1;
    }

    /**
     * returns the true or false accordingly the stack is empty or not.
     */
    public boolean isEmpty(){
        return t == -1;
    }

    /**
     * adds the new element in the stack.
     * increment the size.
     */
    public void push(E e) throws IllegalStateException{
        if(size() == data.length) throw new IllegalStateException("Stack is full");
        data[++t] = e;
    }

    /**
     * returns the element of that index without removing it from the stack.
     */
    public E top(){
        if(isEmpty()) return null;
        return data[t];
    }

    /**
     * returns the top element of the stack and remove it from the stack.
     */
    public E pop(){
        if(isEmpty()) return null;
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }

    /**
     * toString method for the class.
     * @return String
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= t; i++){
            sb.append(data[i]);
            if(i < t){
                sb.append(",");
            }
        }
        return sb.toString();
    }
}


