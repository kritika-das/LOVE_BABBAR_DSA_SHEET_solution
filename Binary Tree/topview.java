import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        class Info {
            Node node;
            int hd;

            Info(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;

        q.add(new Info(root, 0));

        while (!q.isEmpty()) {
            Info curr = q.poll();
            Node currNode = curr.node;
            int currHd = curr.hd;

            if (!map.containsKey(currHd)) {
                map.put(currHd, currNode);
            }

            if (currNode.left != null) {
                q.add(new Info(currNode.left, currHd - 1));
                min = Math.min(min, currHd - 1);
            }

            if (currNode.right != null) {
                q.add(new Info(currNode.right, currHd + 1));
                max = Math.max(max, currHd + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            list.add(map.get(i).data);
        }

        return list;
    }
}
