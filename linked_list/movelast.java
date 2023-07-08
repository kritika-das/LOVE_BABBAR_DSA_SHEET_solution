// 8

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class movelast {
    public static Node moveToFront(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        Node last = head;
        Node secondLast = null;
        
        while (last.next != null) {
            secondLast = last;
            last = last.next;
        }
        
        secondLast.next = null;
        last.next = head;
        head = last;
        
        return head;
    }
}

public class Main {
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        
        System.out.println("Original List: ");
        printList(head);

        Node newHead = Solution.moveToFront(head);

        System.out.println("Modified List: ");
        printList(newHead);
    }
}
