package linked_list;

// 16 CheckCircular.java

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class GfG {
    boolean isCircular(Node head) {
        if (head == null) {
            return false;
        }
        
        Node current = head;
        while (current.next != null && current.next != head) {
            current = current.next;
        }
        
        return current.next == head;
    }
}

public class CheckCircular {
    public static void main(String[] args) {
        // Create a sample circular linked list
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = head; // Make it circular

        // Create an instance of GfG
        GfG gfg = new GfG();

        // Check if the linked list is circular
        boolean isCircular = gfg.isCircular(head);

        // Print the result
        if (isCircular) {
            System.out.println("The linked list is circular.");
        } else {
            System.out.println("The linked list is not circular.");
        }
    }
}

