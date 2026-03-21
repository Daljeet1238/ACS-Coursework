/**
 * Daljeet Singh
 * ACS-2947 Assignment-3
 */

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E>{
    
    /**
     * Returns an iterable collection of the Positions representing p's children.
     *
     * @param p    A valid Position within the tree
     * @return iterable collection of the Positions of p's children
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException{
        List<Position<E>> snapshot = new ArrayList<>(2);                    //max capacity of 2
        if(left(p) != null){
            snapshot.add(left(p));
        if(right(p) != null)
            snapshot.add(right(p));
        }
        return snapshot;
    }

    // return the number of children of position p
    public int numChildren(Position<E> p){
        int count = 0;
        if(left(p) != null)
            count++;
        if(right(p) != null)
            count++;
        return count;
    }

    /**
     * Returns the Position of p's sibling (or null if no sibling exists).
     *
     * @param p A valid Position within the tree
     * @return the Position of the sibling (or null if no sibling exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    public Position<E> sibling(Position<E> p) throws IllegalArgumentException{
        Position<E> parent = parent(p);
        if(parent == null) return null;                         // p must be the root
        if(p == left(parent)){                                  // p is a left child
            return right(parent);                               // right child might be null
        }else{                                                  // p is a right child
            return left(parent);                                // left child might be null
        }
    }
}
