package linked_list;
// 4
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Remeoveloop{
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        if (head == null || head.next == null) {
            return; // No loop present in the list
        }

        Node slow = head;
        Node fast = head;

        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break; // Loop detected
            }
        }

        if (slow != fast) {
            return; // No loop found
        }

        // Find the starting point of the loop
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        // Set the next pointer of the last node in the loop to null, thus breaking the loop
        fast.next = null;
    }

    public static void main(String[] args) {
        // Create a linked list with a loop
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2; 
        removeLoop(head);

        // Print the linked list after removing the loop
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

