//19
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class SumTree {
    public void toSumTree(Node root) {
        solve(root);
    }

    int solve(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = solve(root.left);
        int rightSum = solve(root.right);
        int currentData = root.data;

        root.data = leftSum + rightSum;

        return leftSum + rightSum + currentData;
    }
}

public class Main {
    // Function to print the tree in an inorder traversal
    static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);

        // Create a Solution object and convert the binary tree to a Sum Tree
        Solution solution = new Solution();
        solution.toSumTree(root);

        // Print the Sum Tree using inorder traversal
        System.out.println("Inorder Traversal of Sum Tree:");
        inorderTraversal(root);
    }
}
