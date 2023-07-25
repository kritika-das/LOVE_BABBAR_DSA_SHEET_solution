//1
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    // Function to return the level order traversal of a tree.
    static ArrayList<Integer> levelOrder(Node node) {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();
        if (node != null) {
            levelOrderHelper(node, list);
        }
        return list;
    }

    private static void levelOrderHelper(Node root, ArrayList<Integer> list) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                list.add(curr.data);
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

public class levelorder {
    public static void main(String[] args) {
        // Create a binary tree for testing
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Perform level order traversal
        ArrayList<Integer> levelOrderList = Solution.levelOrder(root);

        // Print the result
        System.out.println("Level Order Traversal:");
        for (int num : levelOrderList) {
            System.out.print(num + " ");
        }
    }
}
