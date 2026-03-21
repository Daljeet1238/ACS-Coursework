/**
 * Daljeet Singh
 * ACS-2947 Assignment-3
 */
import java.util.Iterator;

/**
 * Daljeet Singh
 * ACS-2947 Lab-5
 */

public abstract class AbstractTree<E> implements Tree<E> {

    /**
     * Returns true if Position p has one or more children.
     *
     * @param p    A valid Position within the tree
     * @return true if p has at least one child, false otherwise
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    public boolean isInternal(Position<E> p) throws IllegalArgumentException{
        return numChildren(p) > 0;
    }

    /**
     * Returns true if Position p does not have any children.
     *
     * @param p    A valid Position within the tree
     * @return true if p has zero children, false otherwise
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    public boolean isExternal(Position<E> p) throws IllegalArgumentException{
        return numChildren(p) == 0;
    }

    /**
     * Returns true if Position p represents the root of the tree.
     *
     * @param p    A valid Position within the tree
     * @return true if p is the root of the tree, false otherwise
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    public boolean isRoot(Position<E> p) throws IllegalArgumentException{
        return p ==root();
    }

    /**
     * Tests whether the tree is empty.
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty(){
        return size() == 0;
    };

    // --------------------- nested ElementIterator class -----------------
    /**
     * adapts the iteration produced by position() to return elements
     */
    private class ElementIterator implements Iterator<E> {
        private Iterator<Position<E>> posIterator = positions().iterator();

        public boolean hasNext(){
            return posIterator.hasNext();
        }

        public E next(){
            return posIterator.next().getElement();
        }

        public void remove(){
            posIterator.remove();
        }
    }

    // ------------------- end of nested ElementIterator class ------------

    /**
     * Return an iterator over the element in the binary tree
     */
    public Iterator<E> iterator() {
        return new ElementIterator();
    }
}
