/**
 * Daljeet Singh 3169763
 * ACS-2947 Assignment 2 Part B
 */

public class ArrayPositionalList<E> implements PositionalList<E> {

    //--------------------------- nested Location class -----------------------

    private static class Location<E> implements Position<E> {

        private int index;                                                          // reference to the index of element
        private E element;                                                          // reference to the element

        /**
         * constructor for the Location class
         * @param i index of the element
         * @param e eleement
         */
        public Location(int i, E e) {
            index = i;
            element = e;
        }

        /**
         * getter for the Location class
         */
        public E getElement() throws IllegalStateException {
            if (index == -1) {
                throw new IllegalStateException("Position no longer valid");
            }
            return element;
        }

        /**
         * setter for the Location class
         * @param e element which sets in the list
         */
        public void setElement(E e) {
            element = e;
        }

        /**
         * method to get the index of the element
         * @return index of the element
         */
        public int getIndex() {
            return index;
        }

        /**
         * method to set the index of the element
         * @param i index of the element
         */
        public void setIndex(int i) {
            index = i;
        }
    }

    //---------------------- end of nested Location class ---------------------

    public static final int CAPACITY = 16;                                      // default capacity for the list
    private Location<E>[] data;                                                 // reference to the ArraypositionalList
    private int size = 0;                                                       // size of the list

    /**
     * constructor of ArrayPositionalList with default capacity
     */
    public ArrayPositionalList() {
        this(CAPACITY);
    }

    /**
     * constructor for the ArrayPositionalList
     * @param capacity updated capacity for the ArraypositionalList
     */
    public ArrayPositionalList(int capacity) {
        data = (Location<E>[]) new Location[capacity];
    }

    /**
     * returns the size of the list
     */
    @Override
    public int size(){
        return size;
    }

    /**
     * retrun whether the list is empty or not
     */
    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * return the first element of the list
     */
    @Override
    public Position<E> first(){
        if(size == 0) return null;

        return data[0];
    }

    /**
     * return the last element of the list
     */
    public Position<E> last(){
        if(size == 0)return null;

        return data[size - 1];
    }

    /**
     * Returns the Position immediately before Position p.
     * @param p   a Position of the list
     * @return the Position of the preceding element (or null, if p is first)
     * @throws IllegalArgumentException if p is not a valid position for this list
     */
    public Position<E> before(Position<E> p) throws IllegalArgumentException{
        Location<E> loc = validate(p);
        if(loc.getIndex() == 0){
            return null;
        }
        return data[loc.getIndex() - 1];
    }

    /**
     * Returns the Position immediately after Position p.
     * @param p   a Position of the list
     * @return the Position of the following element (or null, if p is last)
     * @throws IllegalArgumentException if p is not a valid position for this list
     */
    public Position<E> after(Position<E> p) throws IllegalArgumentException{
        Location<E> loc = validate(p);
        if(loc.getIndex()  >= size -1){
            return null;
        }
        return data[loc.getIndex() + 1];
    }

    /**
     * Inserts an element at the front of the list.
     *
     * @param e the new element
     * @return the Position representing the location of the new element
     */
    public Position<E> addFirst(E e){
       return add(0, e);
    }

    /**
     * Inserts an element at the back of the list.
     *
     * @param e the new element
     * @return the Position representing the location of the new element
     */
    public Position<E> addLast(E e){
        return add(size, e);
    }

    /**
     * Inserts an element immediately before the given Position.
     *
     * @param p the Position before which the insertion takes place
     * @param e the new element
     * @return the Position representing the location of the new element
     * @throws IllegalArgumentException if p is not a valid position for this list
     */
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException{
        Location<E> loc = validate(p);
        return add(loc.getIndex() - 1, e);
    }

    /**
     * Inserts an element immediately after the given Position.
     *
     * @param p the Position after which the insertion takes place
     * @param e the new element
     * @return the Position representing the location of the new element
     * @throws IllegalArgumentException if p is not a valid position for this list
     */
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException{
        Location<E> loc = validate(p);
        return add(loc.getIndex() + 1, e);
    }

    /**
     * Replaces the element stored at the given Position and returns the replaced element.
     *
     * @param p the Position of the element to be replaced
     * @param e the new element
     * @return the replaced element
     * @throws IllegalArgumentException if p is not a valid position for this list
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException{
        Location<E> loc = validate(p);
        E elemnet = loc.getElement();
        loc.setElement(e);
        return elemnet;
    }

    /**
     * Removes the element stored at the given Position and returns it.
     * The given position is invalidated as a result.
     *
     * @param p the Position of the element to be removed
     * @return the removed element
     * @throws IllegalArgumentException if p is not a valid position for this list
     */
    public E remove(Position<E> p) throws IllegalArgumentException{
        Location<E> loc = validate(p);
        E element = loc.getElement();
        int index = loc.getIndex();

        for(int i = index; i < size - 1; i++){
            data[i] = data[i + 1];
            data[i].setIndex(i);
        }

        data[size - 1] = null;
        size--;
        loc.setIndex(-1);
        return element;
    }

    /**
     * adds the element in the arraypositionalList
     * @param index index of the element 
     * @param e element which adds 
     * @return position of the element
     */
    public Position<E> add(int index, E e){
        if(size == data.length) throw new IllegalArgumentException("data is full");
        for(int i = size; i > index; i--){
            data[i] = data[i - 1];
            data[i].setIndex(i);
        }
        data[index] = new Location<>(index, e);
        size++;
        return data[index];
    }

    /**
     * method that takes the position of the element
     * @param p position of the element
     * @return Location of the element
     * @throws IllegalArgumentException if p is not a valid position for list 
     */
    public Location<E> validate(Position<E> p) throws IllegalArgumentException{
        if(!(p instanceof Location)) throw new IllegalArgumentException("Invalid p");
        Location<E> loc = (Location<E>) p;
        if(loc.getIndex() == -1) throw new IllegalArgumentException("p is no longer in the list");
        return loc;
    }

    /**
     * Insertion sort method to sort the arraypositionallist
     * @param list arraypositionalList of characters
     */
    public static void InsertionSort(ArrayPositionalList<Character> list){
        int n = list.size();

        for(int i = 1; i < n; i++){
            Position<Character> value = list.data[i];
            char c = value.getElement();

            int j = i;

            while(j > 0 && list.data[j - 1].getElement().compareTo(c) > 0){
                list.data[j] = list.data[j-1];
                list.data[j].setIndex(j);
                j--;
            }
            list.data[j] = new Location<Character>(j, c);
        }
    }

    /**
     * toString method for the ArrayPositionalList 
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            sb.append("[" + i + "] ");
            sb.append(data[i].getElement());
            sb.append(" ");
        }
        return sb.toString();
    }
}