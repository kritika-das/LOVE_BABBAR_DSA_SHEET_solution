//20Construct Tree from Inorder & Preorder

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class treefromInorder {
    private int preIndex = 0; // Initialize preIndex

    public TreeNode buildTree(int[] inorder, int[] preorder) {
        int n = inorder.length;
        // Call cTree to construct the tree
        return cTree(inorder, preorder, 0, n - 1);
    }

    private TreeNode cTree(int[] in, int[] pre, int is, int ie) {
        if (is > ie)
            return null;

        // Create a new node using the current preorder element
        TreeNode root = new TreeNode(pre[preIndex++]);

        // Find the index of root.val in inorder traversal
        int inIndex = -1;
        for (int i = is; i <= ie; i++) {
            if (in[i] == root.val) {
                inIndex = i;
                break;
            }
        }

        // Recursively build the left and right subtrees
        root.left = cTree(in, pre, is, inIndex - 1);
        root.right = cTree(in, pre, inIndex + 1, ie);

        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {3, 9, 20, 15, 7};

        TreeNode root = solution.buildTree(inorder, preorder);

        // You can now use the root node of the constructed tree for further operations.
        // For example, you can traverse and print the tree to verify the construction.
        System.out.println("Inorder Traversal:");
        inorderTraversal(root);

        System.out.println("\nPreorder Traversal:");
        preorderTraversal(root);
    }

    // Inorder traversal of the tree (used for verification)
    private static void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.val + " ");
            inorderTraversal(node.right);
        }
    }

    // Preorder traversal of the tree (used for verification)
    private static void preorderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }
}
