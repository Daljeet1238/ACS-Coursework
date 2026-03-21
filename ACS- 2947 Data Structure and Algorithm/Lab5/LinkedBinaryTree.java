/**
 * Daljeet Singh
 * ACS-2947 Lab-5
 */

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E>{

    //------------------------------ Nested Node class -------------------------------

    protected static class Node<E> implements Position<E>{
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        /**
         * Constructor for the node
         * @param e element in the node
         * @param above parent of the node(if any)
         * @param leftChild left child of the node(if any)
         * @param rightChild right child of the node(if any)
         */
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild){
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        //accessor methods
        public E getElement(){
            return element;
        }

        public Node<E> getParent(){
            return parent;
        }

        public Node<E> getLeft(){
            return left;
        }

        public Node<E> getRight(){
            return right;
        }

        // update methods
        public void setElement(E e){
            element = e;
        }

        public void setParent(Node<E> p){
            parent = p;
        }

        public void setLeft(Node<E> l){
            left = l;
        }

        public void setRight(Node <E> r){
            right = r;
        }
    }

    //--------------------------- End of Nested Node class -------------------------------

    /**
     * Factory function to create a new Node storing element e
     * @param e element of the node
     * @param parent parent of the Node(if any)
     * @param left left child of the Node(if any)
     * @param right right child of the Node(if any)
     * @return newly created node containing the element e
     */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right){
        return new Node<E>(e, parent, left, right);
    }

    //LinkedBinaryTree instance variable
    protected Node<E> root = null;
    private int size = 0;

    //constructor for the LinkedBinaryTree
    public LinkedBinaryTree(){ }                            //constructs an empty binary tree

    //non public utility
    /**
     * validate the position and return it as a node
     * @param p poition of the node
     * @return node 
     * @throws IllegalArgumentException
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException{
        if(!(p instanceof Node)) throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p;                             // safe cast
        if(node.getParent() == node)                            // our convention for the defunt node
            throw new IllegalArgumentException("p is no longer in the tree"); 
        return node;
    }

    /**
     * Returns the element stored at this position.
     *
     * @return the stored element
     * @throws IllegalStateException if position no longer valid
     */
    public E getElement() throws IllegalStateException{
        return getElement();
    }



    /**
     * Returns the root Position of the tree (or null if tree is empty).
     * @return root Position of the tree (or null if tree is empty)
     */
    public Position<E> root(){
        return root;
    }

    /**
     * Returns the Position of p's parent (or null if p is root).
     *
     * @param p A valid Position within the tree
     * @return Position of p's parent (or null if p is root)
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    public Position<E> parent(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return node.getParent();
    }

    /**
     * Returns the number of nodes in the tree.
     * @return number of nodes in the tree
     */
    public int size(){
        return size;
    }

    /**
     * Returns the Position of p's left child (or null if no child exists).
     *
     * @param p A valid Position within the tree
     * @return the Position of the left child (or null if no child exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    public Position<E> left(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return node.getLeft();
    }

    /**
     * Returns the Position of p's right child (or null if no child exists).
     *
     * @param p A valid Position within the tree
     * @return the Position of the right child (or null if no child exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    public Position<E> right(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return node.getRight();
    }    

    // place element e at the root of an empty tree and return its new Position.
    public Position<E> addRoot(E e) throws IllegalArgumentException{
        if(!isEmpty()) throw new IllegalArgumentException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    } 

    /**
     * create a new left child of position p storing element e , return it's position
     * @param p position of the element
     * @param e element in the node
     * @return left child node 
     * @throws IllegalArgumentException if p is not a valid position for the tree
     */
    public Position<E> addLeft(Position<E> p,E e) throws IllegalArgumentException{
        Node<E> parent = validate(p);
        if(parent.getLeft() != null) throw new IllegalArgumentException("p is already has a left child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    /**
     * method to declare the right child of the parent
     * @param p position of the element
     * @param e elemnt in the node
     * @return right child position of the parent 
     * @throws IllegalArgumentException if p is not a valid position for the tree
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> parent = validate(p);
        if(parent.getRight() != null) throw new IllegalArgumentException("p already has a right child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        return child;
    }

    /**
     * replace the element at position p with e and returns the replaced element
     * @param p position of the element
     * @param e element 
     * @return replaced element 
     * @throws IllegalArgumentException if p is not a valid position for the tree
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    /**
     * method tells the number of level separating position p from the root
     * @param p position of the element
     * @return number of level as depth
     */
    public int depth(Position<E> p){
        if(isRoot(p))
            return 0;
        else    
            return 1 + depth(parent(p));
    }

    public int height(Position<E> p){
        int h = 0;
        for(Position<E> c : children(p))
            h = Math.max(h, 1 + height(c));
        return h;
    }

    /**
     * removes the node at position p and replace it with its child, if any
     * @param p position 
     * @return  removed element
     * @throws IllegalArgumentException
     */
    public E remove(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        if(numChildren(p) == 2)
            throw new IllegalArgumentException("p has two children");
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if(child != null)
            child.setParent(node.getParent());                              // child's grandparent become its parent
        if(node == root)
            root = child;
        else{
            Node<E> parent = node.getParent();
            if(node == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setLeft(child);
        }
        size--;
        E temp = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(null);
        return temp;
    }


}
