//7
import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class BinaryTree {
    // Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null) {
            preOrderHelper(root, list);
        }
        return list;
    }

    private static void preOrderHelper(Node node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.data);
        preOrderHelper(node.left, list);
        preOrderHelper(node.right, list);
    }
}

public class preOrder {
    public static void main(String[] args) {
        // Create a binary tree for testing
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(2);

        // Perform preorder traversal
        ArrayList<Integer> preorderList = BinaryTree.preOrder(root);

        // Print the result
        System.out.println("Preorder Traversal:");
        for (int num : preorderList) {
            System.out.print(num + " ");
        }
    }
}
