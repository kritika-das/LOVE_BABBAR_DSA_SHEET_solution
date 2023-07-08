package linked_list;
// 7
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class removeunsorteddup {
    Node removeDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head; // No duplicates to remove
        }

        // Create a HashSet to store the unique elements
        HashSet<Integer> set = new HashSet<>();

        Node current = head;
        Node prev = null;

        while (current != null) {
            int value = current.data;

            // Check if the value is already in the set
            if (set.contains(value)) {
                // Duplicate element found, remove the node
                prev.next = current.next;
            } else {
                // Add the value to the set and move to the next node
                set.add(value);
                prev = current;
            }

            current = current.next;
        }

        return head;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create the linked list
        Node head = new Node(5);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);

        // Print the original linked list
        System.out.println("Original Linked List:");
        printLinkedList(head);

        // Remove duplicates
        Solution solution = new Solution();
        Node modifiedHead = solution.removeDuplicates(head);

        // Print the modified linked list
        System.out.println("Modified Linked List:");
        printLinkedList(modifiedHead);
    }

    // Helper function to print the linked list
    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
