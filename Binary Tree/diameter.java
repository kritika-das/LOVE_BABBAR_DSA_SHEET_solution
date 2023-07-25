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

class Solution {
    // Function to return the diameter of a Binary Tree.
    int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        // Calculate the height of the left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Calculate the diameter passing through the root
        int rootDiameter = leftHeight + rightHeight;

        // Calculate the diameter of left and right subtrees recursively
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        // Return the maximum of the three diameters
        return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
    }

    // Function to calculate the height of a binary tree.
    int height(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}

public class diameter {
    public static void main(String[] args) {
        // Create a binary tree for testing
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Calculate the diameter of the binary tree
        int treeDiameter = solution.diameter(root);

        // Print the result
        System.out.println("Diameter of the Binary Tree: " + treeDiameter);
    }
}
