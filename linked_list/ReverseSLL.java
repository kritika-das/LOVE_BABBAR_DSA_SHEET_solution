/*1 
 * linked_list
 */

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseSLL {

    Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node curr = head;
        Node prev = null;
        Node next = null;

        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        ReverseSLL solution = new ReverseSLL();
        Node reversedHead = solution.reverseList(head);

        // Print the reversed linked list
        solution.printList(reversedHead);
    }
}