//2
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Tree {
    // Function to return the reverse level order traversal of a tree.
    public ArrayList<Integer> reverseLevelOrder(Node node) {
        ArrayList<Integer> reverseList = new ArrayList<>();
        if (node == null) {
            return reverseList;
        }

        Queue<Node> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            stack.push(current.data);

            if (current.right != null) {
                queue.add(current.right);
            }
            if (current.left != null) {
                queue.add(current.left);
            }
        }

        while (!stack.isEmpty()) {
            reverseList.add(stack.pop());
        }

        return reverseList;
    }
}

public class revlevelordertraversal {
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

        // Perform reverse level order traversal
        ArrayList<Integer> reverseLevelOrderList = tree.reverseLevelOrder(root);

        // Print the result
        System.out.println("Reverse Level Order Traversal:");
        for (int num : reverseLevelOrderList) {
            System.out.print(num + " ");
        }
    }
}
