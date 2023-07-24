package Binary Tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class Solution {
    // Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node node) {
        ArrayList<Integer> list = new ArrayList<>();
        if (node == null) return list;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (i == size - 1) {
                    list.add(cur.data);
                }
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
        }
        return list;
    }
}

public class right_view {
    public static void main(String[] args) {
        // Create the binary tree.
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        // Create the Solution object and get the right view elements.
        Solution solution = new Solution();
        ArrayList<Integer> rightViewElements = solution.rightView(root);

        // Print the right view elements.
        for (Integer element : rightViewElements) {
            System.out.print(element + " ");
        }
    }
}
