/**
 * Daljeet Singh
 * ACS-2947 Assignment-3
 */
public class PartA_Driver{
    public static void main(String[] args) {
        System.out.println("Tree");

        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();

        Position<String> root = tree.addRoot("A");
        Position<String> b = tree.addLeft(root, "B");
        Position<String> c = tree.addRight(root, "C");
        Position<String> d = tree.addLeft(b, "D");
        Position<String> e = tree.addRight(b, "E");
        Position<String> f = tree.addLeft(c, "F");
        Position<String> g = tree.addRight(c, "G");
        Position<String> h = tree.addLeft(f, "H");
        Position<String> i = tree.addRight(f, "I");

        System.out.println(tree);

        LinkedBinaryTree<String> binaryTree = new LinkedBinaryTree<>();

        Position<String> root1 = binaryTree.addRoot("-");

        Position<String> multiply = binaryTree.addLeft(root1, "*");
        Position<String> divide = binaryTree.addLeft(multiply, "/");
        Position<String> plus1 = binaryTree.addLeft(divide, "+");
        Position<String> seven1 = binaryTree.addLeft(plus1, "7");
        Position<String> five = binaryTree.addRight(plus1, "5");
        Position<String> three = binaryTree.addRight(divide, "3");

        Position<String> plus2 = binaryTree.addRight(multiply, "+");
        Position<String> minus1 = binaryTree.addLeft(plus2, "-");
        Position<String> seven2 = binaryTree.addLeft(minus1, "7");
        Position<String> one = binaryTree.addRight(minus1, "1");

        Position<String> multiply1 = binaryTree.addRight(plus2, "*");
        Position<String> eight = binaryTree.addLeft(multiply1, "8");
        Position<String> two1 = binaryTree.addRight(multiply1, "2");

        Position<String> minus2 = binaryTree.addRight(root1, "-");
        Position<String> plus3 = binaryTree.addLeft(minus2, "+");
        Position<String> multiply2 = binaryTree.addLeft(plus3, "*");
        Position<String> six = binaryTree.addLeft(multiply2, "6");
        Position<String> three2 = binaryTree.addRight(multiply2, "3");
        Position<String> three3 = binaryTree.addRight(plus3, "3");

        Position<String> multiply3 = binaryTree.addRight(minus2, "*");
        Position<String> seven3 = binaryTree.addLeft(multiply3, "7");
        Position<String> two2 = binaryTree.addRight(multiply3, "2");

        System.out.println("Arithmetic Tree");
        System.out.println("---------------");

        //inorder traversal
        System.out.print("Inorder: ");
        System.out.print("[");
        for (Position<String> p : binaryTree.inorder()) {
            System.out.print(p.getElement() + " ");
        }
        System.out.print("]");
        System.out.println();

        //postorder traversal
        System.out.print("Postorder: ");
        System.out.print("[");
        for (Position<String> p : binaryTree.postorder()) {
            System.out.print(p.getElement() + " ");
        }
        System.out.print("]");
        System.out.println();

        int result = TreeValue(binaryTree);
        System.out.println("BinaryTree value: " + result);
        
    }

    private static int TreeValue(LinkedBinaryTree<String> tree) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        for (Position<String> p : tree.postorder()) {
            String element = p.getElement();
            if (isOperator(element)) {
                int right = stack.pop();
                int left = stack.pop();
                int result = applyOperator(element, left, right);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(element));
            }
        }
        return stack.pop();
    }

    // Check if the element is an operator
    private static boolean isOperator(String element) {
        String[] operators = {"+", "-", "*", "/"};
        for (String op : operators) {
            if (element.equals(op)) {
                return true;
            }
        }
        return false;
    }

    // Apply the operator to the operands using if-else
    private static int applyOperator(String operator, int left, int right) {
        if (operator.equals("+")) {
            return left + right;
        } else if (operator.equals("-")) {
            return left - right;
        } else if (operator.equals("*")) {
            return left * right;
        } else if (operator.equals("/")) {
            return left / right;
        } else {
            throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}