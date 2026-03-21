/**
 * Daljeet Singh 3169763
 * ACS-2947 Assignment 2 Part B
 */

 import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>{
    
    private int size = 0;                       //safe of the array
    private E[] arr;                            //generic array used for the storage
    private static final int CAPACITY = 4;      // reference to the capacity of the array

    /**
     * default constructor for the arraylist class
     */
    public ArrayList(){
        this(CAPACITY);
    }

    /**
     * constructor for the arraylist class which allow the user to define capacity
     * @param capacity capacity which user want to declare
     */
    public ArrayList(int capacity){
        arr = (E[]) new Object[capacity];       //safe cast
    }

    /**
     * retrun the size of the arraylist
     */
    public int size(){
        return size;
    }

    /**
     * retrun whether the array is empty or not
     */
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * retrun the element of that index or
     * throw exception if the index is out of the range
     */
    public E get(int i) throws IndexOutOfBoundsException{
        checkIndex(i, size);
        return arr[i];
    }

    /**
     * replace the element at index i with element e
     * returns the replaced element
     */
    public E set(int i, E e) throws IndexOutOfBoundsException{
        checkIndex(i, size);
        E temp = arr[i];
        arr[i] = e;
        return temp;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException{
        checkIndex(i, size + 1);
        if(size == arr.length){
            resize(arr.length * 2);
            for(int j = size; j > i; j--){
                arr[j + 1] = arr[j];
            }
            arr[i] = e;
            size++;
        }
    }

    /**
     * insert the element at the end of the array
     * @param e element which adds in the array
     */
    public void add(E e){
        if(size == arr.length){
            resize(arr.length * 2);
            arr[size] = e;
        }else{
            arr[size] = e;
        }
        size++;
    }

    

    /**
     * remove the element at the index i
     */
    public E remove(int i){
        if(arr.length == size/ 4){
            resize(size / 2);
            E temp = arr[i];
            arr[i] = null;
            size--;
            return temp;
        }else{
            E temp = arr[i];
            arr[i] = null;
            size--;
            return temp;
        }
    }

    //----------------- nested ArrayIterator class -------------------
    
    private class ArrayIterator implements Iterator<E>{
        private int j = 0;
        private boolean removable = true;

        /**
         * Test whether the iterator has a next object
         * @return true if there are further object, false otherwise
         */
        public boolean hasNext() {return j < size; }                //size is field of outer instance

        public E next() throws NoSuchElementException{
            if(j == size) throw new NoSuchElementException("No next element");
            removable = true;
            return arr[j++];
        }

    }
    
    //----------------- end of nested ArrayIterator class ------------

    /**
     * returns an iterator of the element stored in the list.
     */
    public Iterator<E> iterator(){
        return new ArrayIterator();
    }

    /**
     * resize the array according to the number of elements
     */
    protected void resize(int capacity){
        E[] temp = (E[]) new Object[capacity];              //cast into array
        for(int i = 0; i < size; i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }

    /**
     * checks whether the index is valid and in the array
     * @param i index of the element 
     * @param n size of the array
     * @throws IndexOutOfBoundsException execption thrown if index is out of the array
     */
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException{
        if(i < 0 || i >= n)
            throw new IndexOutOfBoundsException("Illegal index " + i);
    }

    /**
     * returns whether the objects are equals or not
     */
    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof ArrayList)) return false;
        ArrayList<E> other =  (ArrayList<E>) o;
        if(this.size() != other.size()) return false;
        for(int i = 0; i < this.size(); i++){
            if(!arr[i].equals(other.get(i))) return false; 
        }
        return true;
    }

    /**
     * toString method for the array using Stringbuilder
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            sb.append(arr[i] + "\n");
        }
        return sb.toString();
    }
}
