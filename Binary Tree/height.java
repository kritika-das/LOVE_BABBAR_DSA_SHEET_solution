//3
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    // Function to find the height of a binary tree.
    int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            int ldepth = height(node.left);
            int rdepth = height(node.right);
            if (ldepth > rdepth) {
                return (ldepth + 1);
            } else {
                return (rdepth + 1);
            }
        }
    }
}

public class Height {
    public static void main(String[] args) {
        // Create a binary tree for testing
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Create an instance of the BinaryTree class
        BinaryTree binaryTree = new BinaryTree();

        // Calculate the height of the binary tree
        int treeHeight = binaryTree.height(root);

        // Print the result
        System.out.println("Height of the Binary Tree: " + treeHeight);
    }
}
