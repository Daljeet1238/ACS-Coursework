/**
 * Daljeet Singh 3169763
 * ACS- 2947- 002
 * Assignment - 4
 */
import java.util.Iterator;
import java.util.NoSuchElementException;


public class DoublyLinkedList<E> implements Iterable<E>{

    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }

        public E getElement(){return element;}
        public Node<E> getPrev(){return prev;}
        public Node<E> getNext(){return next;}
        public void setPrev(Node<E> p){prev = p;}
        public void setNext(Node<E> n){next = n;}
        
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList(){
        header = new Node<>(null, null,null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int size(){return size;}

    public boolean isEmpty(){return size == 0;}

    public E first(){
        if(isEmpty()) return null;
        return header.getNext().getElement();
    }

    public E last(){
        if(isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    public void addFirst(E e){
        addBetween(e ,header, header.getNext());
    }

    public void addLast(E e){
        addBetween(e, trailer.getPrev(), trailer);
    }

    public E removeFirst(){
        if(isEmpty()) return null;
        return remove(header.getNext());
    }

    public E removeLast(){
        if(isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor){
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    private E remove(Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }   

    @Override
    public Iterator<E> iterator(){
        return new DoublyLinkedListIterator();
    }

    private class DoublyLinkedListIterator implements Iterator<E> {
        private Node<E> current = header.getNext();
        private Node<E> n = null;
        private boolean removable = false;

        @Override
        public boolean hasNext(){
            return current != trailer;
        }

        @Override
        public E next() throws NoSuchElementException{
            if(!hasNext()) throw new NoSuchElementException("nothing left");
            E data = current.getElement();
            n = current;
            current = current.getNext();
            removable = true;
            return data;
        }

        @Override
        public void remove() throws IllegalStateException{
            if(!removable) throw new IllegalStateException("nothing to remove");
            DoublyLinkedList.this.remove(n);
            removable = false;
        }
    }
}
