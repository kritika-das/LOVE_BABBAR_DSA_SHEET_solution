package linked_list;
// 6
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class remove_duplicates {
    // Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(4);

        GfG gfg = new GfG();
        Node result = gfg.removeDuplicates(head);

        // Printing the linked list after removing duplicates
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}

