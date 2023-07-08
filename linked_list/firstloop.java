package linked_list;
// 5
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class firstloop {
    public static Node detectAndReturnFirstLoopNode(Node head) {
        if (head == null || head.next == null) {
            return null; // No loop present in the list
        }

        Node slow = head;
        Node fast = head;

        // Detect the loop using Floyd's cycle-finding algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break; // Loop detected
            }
        }

        if (slow != fast) {
            return null; // No loop found
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // Return the first node of the loop
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next; // Creating a loop

        Solution solution = new Solution();
        Node firstLoopNode = solution.detectAndReturnFirstLoopNode(head);

        if (firstLoopNode != null) {
            System.out.println("First node of the loop: " + firstLoopNode.data);
        } else {
            System.out.println("No loop found");
        }
    }
}

