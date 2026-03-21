/**
 * Daljeet Singh
 * ACS-2947 Lab-5
 */

public class Lab5_Driver {
    public static void main(String[] args) {
        
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();

        Position<String> A = tree.addRoot("root");
        Position<String> B = tree.addLeft(A, "leftChild");
        Position<String> C = tree.addRight(A, "rightChild");
        Position<String> D = tree.addLeft(B, "leftGrandChild1");
        Position<String> E = tree.addRight(B, "rightGrandChild2");
        Position<String> F = tree.addLeft(C, "leftgrandChild3");
        Position<String> G = tree.addRight(C, "rightGrandChild4");
        Position<String> H = tree.addLeft(D, "leftGreatGrandChild1");
        Position<String> I = tree.addRight(D, "rightGreatGrandChild2");
        Position<String> J = tree.addLeft(F , "leftGreatGrandChild5");
        Position<String> K = tree.addRight(F, "RightGreaatGrandChild6");

        System.out.println("The descendants of A: ");
        allDescendants(tree, A);

        System.out.println("The descendants of B: ");
        allDescendants(tree, B);

        System.out.println("The path from I to root(A): ");
        pathToroot(tree, I);

        System.out.println("Tree Height: ");
        tree.height(A);

        System.out.println("Depth of right child of the root (C)");
        tree.depth(C);

        System.out.println("Removed node: I");
        tree.remove(I);

        System.out.println("Final tree size: " + tree.size());
    }

    public static void allDescendants(LinkedBinaryTree<String> tree,Position<String> p){
        for(Position<String> position : tree.children(p)){
            System.out.println("\t" + p.getElement() + " ");
            allDescendants(tree, position);
        }
    }

    public static void pathToroot(LinkedBinaryTree<String> tree,Position<String> p){
        while(p != null){
            System.out.println(p.getElement() + ", ");
            tree.parent(p);
        }
    }
}
