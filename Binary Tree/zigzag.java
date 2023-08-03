//13
import java.util.*;

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

class zigzag {
    // Function to store the zigzag order traversal of the tree in a list.
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null)
            return list;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true; // To determine the zigzag direction

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Integer> levelNodes = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node temp = queue.poll();
                if (leftToRight)
                    levelNodes.add(temp.data); // Add data in left-to-right direction
                else
                    levelNodes.add(0, temp.data); // Add data in right-to-left direction

                if (temp.left != null)
                    queue.add(temp.left);

                if (temp.right != null)
                    queue.add(temp.right);
            }

            list.addAll(levelNodes);
            leftToRight = !leftToRight; // Reverse the direction for the next level
        }

        return list;
    }
}
