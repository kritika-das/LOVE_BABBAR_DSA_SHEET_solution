//14
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Treebalance {
    // Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root) {
        return balance(root) != -1;
    }

    // Helper function to calculate the height of the tree and check balance.
    int balance(Node root) {
        if (root == null)
            return 0;

        int lh = balance(root.left);
        if (lh == -1)
            return -1;

        int rh = balance(root.right);
        if (rh == -1)
            return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;

        return Math.max(lh, rh) + 1;
    }
}

public class Main {
    public static void main(String[] args) {
       

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);

        Tree tree = new Tree();
        boolean isBalanced = tree.isBalanced(root);

        System.out.println("Is the tree balanced? " + isBalanced);
    }
}
