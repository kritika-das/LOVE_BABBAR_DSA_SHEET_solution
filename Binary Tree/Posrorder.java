//8
import java.util.ArrayList;

class Node {
    int data;
    Node left, right;
    
    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Tree {
    // Function to return a list containing the postorder traversal of the tree.
    ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null) {
            postOrderHelper(root, list);
        }
        return list;
    }
    
    private void postOrderHelper(Node node, ArrayList<Integer> list) {
        if (node != null) {
            postOrderHelper(node.left, list);
            postOrderHelper(node.right, list);
            list.add(node.data);
        }
    }
}

public class Posrorder {
    public static void main(String[] args) {
        // Create a binary tree for testing
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Create an instance of the Tree class
        Tree tree = new Tree();

        // Perform postorder traversal
        ArrayList<Integer> postorderList = tree.postOrder(root);

        // Print the result
        System.out.println("Postorder Traversal:");
        for (int num : postorderList) {
            System.out.print(num + " ");
        }
    }
}
