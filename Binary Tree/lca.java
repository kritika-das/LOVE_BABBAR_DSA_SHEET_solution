// 31

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class BST {
    // Function to find the lowest common ancestor in a BST.
    Node LCA(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2)
            return root;

        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);

        if (left == null)
            return right;
        if (right == null)
            return left;

        return root;
    }
}

public class lca {
    public static void main(String[] args) {
        // Create a sample Binary Search Tree
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(20);

        // Values for which LCA needs to be found
        int n1 = 3;
        int n2 = 7;

        BST bst = new BST();
        Node lcaNode = bst.LCA(root, n1, n2);

        System.out.println("Lowest Common Ancestor of " + n1 + " and " + n2 + " is: " + lcaNode.data);
    }
}
