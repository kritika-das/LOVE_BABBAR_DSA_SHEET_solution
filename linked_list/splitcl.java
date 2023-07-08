// 17
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class circular_LinkedList {
    Node head;
    Node head1;
    Node head2;

    public circular_LinkedList() {
        this.head = null;
        this.head1 = null;
        this.head2 = null;
    }
}

public class splitcl {

    void splitList(circular_LinkedList list) {
        Node head = list.head;
        Node head1 = null;
        Node head2 = null;

        Node slow = head;
        Node fast = head;
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (head == null) {
            return;
        }
        if (fast.next.next == head) {
            fast = fast.next;
        }
        if (head.next != head) {
            head1 = head;
        }

        // Assigning the head2 to the second half of the list
        if (fast.next == head) {
            head2 = slow.next;
        }

        // Making the first half circular
        slow.next = head;

        // Making the second half circular
        fast.next = head2;

        // DO NOT REMOVE THESE 2 LINES
        list.head1 = head1;
        list.head2 = head2;
    }

    public static void main(String[] args) {
        // Creating a circular linked list with 5 nodes: 1 -> 2 -> 3 -> 4 -> 5 -> 1
        circular_LinkedList list = new circular_LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        list.head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node1;

        // Splitting the circular linked list
        splitcl obj = new splitcl();
        obj.splitList(list);

        // Printing the first half of the list
        Node temp1 = list.head1;
        System.out.print("First Half: ");
        while (temp1 != null && temp1.next != list.head1) {
            System.out.print(temp1.data + " -> ");
            temp1 = temp1.next;
        }
        System.out.println(temp1.data); // Printing the last node of the first half

        // Printing the second half of the list
        Node temp2 = list.head2;
        System.out.print("Second Half: ");
        while (temp2 != null && temp2.next != list.head2) {
            System.out.print(temp2.data + " -> ");
            temp2 = temp2.next;
        }
        System.out.println(temp2.data); // Printing the last node of the second half
    }
}
