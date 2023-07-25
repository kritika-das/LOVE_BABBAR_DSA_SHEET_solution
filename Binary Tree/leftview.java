//9
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Tree {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null) {
            leftViewHelper(root, list);
        }
        return list;
    }

    private void leftViewHelper(Node node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                // Add the first node in the current level to the left view list
                if (i == 0) {
                    list.add(curr.data);
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }
}

public class leftview {
    public static void main(String[] args) {
        // Create a binary tree for testing
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        // Create an instance of the Tree class
        Tree tree = new Tree();

        // Get the left view of the binary tree
        ArrayList<Integer> leftViewList = tree.leftView(root);

        // Print the left view elements
        System.out.println("Left View of the Binary Tree:");
        for (int num : leftViewList) {
            System.out.print(num + " ");
        }
    }
}
