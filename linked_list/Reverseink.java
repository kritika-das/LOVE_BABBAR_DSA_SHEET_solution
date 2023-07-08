// 2
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Reverseink {
    public static Node reverse(Node head, int k) {
        int count = 0;
        Node next = null;
        Node curr = head;
        Node prev = null;
        
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        
        if (next != null) {
            head.next = reverse(next, k);
        }
        
        return prev;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        int k = 2; // Number of nodes to reverse at a time

        System.out.println("Original linked list:");
        printLinkedList(head);

        head = Solution.reverse(head, k);

        System.out.println("Reversed linked list:");
        printLinkedList(head);
    }

    public static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
