class binarytree_dll
{
    // Global variables to keep track of the head and previous node of the DLL
    Node headOfDLL = null;
    Node previousNode = null;

    // Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
        // Initialize the DLL using an inorder traversal
        convertBSTToDLL(root);

        // Return the head of the DLL
        return headOfDLL;
    }

    // Helper function to convert a binary tree to a doubly linked list (DLL)
    void convertBSTToDLL(Node root)
    {
        if (root == null) {
            return;
        }

        // Recursively convert the left subtree
        convertBSTToDLL(root.left);

        // If previousNode is null, it means we are at the leftmost node, so we set headOfDLL to the current root.
        if (previousNode == null) {
            headOfDLL = root;
        } else {
            // Otherwise, we update the pointers to form the doubly linked list.
            root.left = previousNode;
            previousNode.right = root;
        }

        // Update previousNode to the current root.
        previousNode = root;

        // Recursively convert the right subtree
        convertBSTToDLL(root.right);
    }
}
