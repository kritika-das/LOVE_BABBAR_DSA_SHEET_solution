package linked_list;
// 9
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class add1 {
    public static Node addOne(Node head) {
        Node reversedHead = reverseList(head);
        Node curr = reversedHead;
        Node prev = null;

        int carry = 1;
        while (curr != null) {
            int sum = curr.data + carry;
            curr.data = sum % 10;
            carry = sum / 10;
            prev = curr;
            curr = curr.next;
        }

        if (carry != 0) {
            prev.next = new Node(carry);
        }

        return reverseList(reversedHead);
    }

    public static Node reverseList(Node head) {
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}

public class Main {
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(9);

        System.out.println("Original List: ");
        printList(head);

        Node newHead = Solution.addOne(head);

        System.out.println("Modified List: ");
        printList(newHead);
    }
}

