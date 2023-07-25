//6
import java.util.ArrayList;

class Node {
    int data;
    Node left, right;
    
    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null) {
            inOrderHelper(root, list);
        }
        return list;
    }

    // Helper function to perform the inorder traversal recursively.
    private void inOrderHelper(Node node, ArrayList<Integer> list) {
        if (node != null) {
            inOrderHelper(node.left, list);
            list.add(node.data);
            inOrderHelper(node.right, list);
        }
    }
}

public class Inorder {
    public static void main(String[] args) {
        // Create a binary tree for testing
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Perform inorder traversal
        ArrayList<Integer> inorderList = solution.inOrder(root);

        // Print the result
        System.out.println("Inorder Traversal:");
        for (int num : inorderList) {
            System.out.print(num + " ");
        }
    }
}
