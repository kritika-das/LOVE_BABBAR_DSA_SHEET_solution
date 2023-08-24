//21
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class Sumtree {
    boolean isSumTree(Node root) {
        int result = solve(root);
        return f == 1;
    }

    int f = 1;

    int solve(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.data;
        }

        if (f == 0) {
            return 0;
        }

        int leftSum = solve(root.left);
        int rightSum = solve(root.right);

        if (leftSum + rightSum != root.data) {
            f = 0;
        }

        return leftSum + rightSum + root.data;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        Node root1 = new Node(3);
        root1.left = new Node(1);
        root1.right = new Node(2);
        boolean result1 = solution.isSumTree(root1);
        System.out.println("Test Case 1: " + result1); // Output should be true (1)

        // Test case 2
        Node root2 = new Node(5);
        root2.left = new Node(2);
        root2.right = new Node(3);
        boolean result2 = solution.isSumTree(root2);
        System.out.println("Test Case 2: " + result2); // Output should be false (0)
    }
}
