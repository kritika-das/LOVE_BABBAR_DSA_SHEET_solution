//22
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class levelcheck {
    boolean check(Node root) {
        // Initialize maxLevel and result flag
        int maxLevel = -1;
        boolean result = true;

        // Start the traversal with the root node
        result = leafChecker(root, 0, maxLevel);

        return result;
    }

    boolean leafChecker(Node root, int level, int maxLevel) {
        // Base case: If the current node is null, return true
        if (root == null) {
            return true;
        }

        // If it's a leaf node
        if (root.left == null && root.right == null) {
            // If maxLevel is not set, set it to the current level
            if (maxLevel == -1) {
                maxLevel = level;
            } 
            // If the current level is different from maxLevel, return false
            else if (level != maxLevel) {
                return false;
            }
        }

        // Recursively check left and right subtrees
        boolean leftResult = leafChecker(root.left, level + 1, maxLevel);
        boolean rightResult = leafChecker(root.right, level + 1, maxLevel);

        // Return true if both left and right subtrees satisfy the condition
        return leftResult && rightResult;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Leaf nodes are at the same level
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        boolean result1 = solution.check(root1);
        System.out.println("Test Case 1: " + result1); // Output should be true

        // Test Case 2: Leaf nodes are at different levels
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.left.left = new Node(3);
        boolean result2 = solution.check(root2);
        System.out.println("Test Case 2: " + result2); // Output should be false
    }
}
