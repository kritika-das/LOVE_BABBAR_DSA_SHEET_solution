package linked_list;
//3
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Detectloop {
    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a linked list with a loop
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create a loop in the linked list
        head.next.next.next.next.next = head.next;

        boolean hasLoop = Detectloop.detectLoop(head);

        if (hasLoop) {
            System.out.println("Linked list has a loop.");
        } else {
            System.out.println("Linked list does not have a loop.");
        }
    }
}

