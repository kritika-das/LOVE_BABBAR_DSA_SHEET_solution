// BtToDll.java
//18
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    Node headOfDLL = null;
    Node previousNode = null;

    Node bToDLL(Node root) {
        convertBSTToDLL(root);
        return headOfDLL;
    }

    void convertBSTToDLL(Node root) {
        if (root == null) {
            return;
        }

        convertBSTToDLL(root.left);

        if (previousNode == null) {
            headOfDLL = root;
        } else {
            root.left = previousNode;
            previousNode.right = root;
        }

        previousNode = root;

        convertBSTToDLL(root.right);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a sample binary search tree
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        // Create a Solution object and convert the binary tree to a doubly linked list
        Solution solution = new Solution();
        Node headOfDLL = solution.bToDLL(root);

        // Print the doubly linked list from left to right
        Node current = headOfDLL;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
    }
}
