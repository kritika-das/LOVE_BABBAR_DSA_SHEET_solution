// 11
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class intersectionofll {
    public static Node findIntersection(Node head1, Node head2) {
        Node head = null;
        Node curr = null;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                head1 = head1.next;
            } else if (head1.data > head2.data) {
                head2 = head2.next;
            } else {
                Node newNode = new Node(head1.data);
                if (head == null) {
                    head = newNode;
                    curr = newNode;
                } else {
                    curr.next = newNode;
                    curr = curr.next;
                }

                head1 = head1.next;
                head2 = head2.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        // Create the first linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        // Create the second linked list: 2 -> 4 -> 6 -> 8 -> 10
        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);
        head2.next.next.next.next = new Node(10);

        // Find the intersection of the two linked lists
        Node intersection = findIntersection(head1, head2);

        // Print the values of the intersection nodes
        while (intersection != null) {
            System.out.print(intersection.data + " ");
            intersection = intersection.next;
        }
    }
}

