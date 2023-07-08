// 13
package linked_list;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class mergesort {

    static Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        Node ans = new Node(-1);
        Node temp = ans;
        while (left != null && right != null) {
            if (left.data < right.data) {
                temp.next = left;
                temp = left;
                left = left.next;
            } else {
                temp.next = right;
                temp = right;
                right = right.next;
            }
        }
        while (left != null) {
            temp.next = left;
            temp = left;
            left = left.next;
        }
        while (right != null) {
            temp.next = right;
            temp = right;
            right = right.next;
        }

        return ans.next;
    }

    static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = findMid(head);
        Node left = head;
        Node right = mid.next;
        mid.next = null;
        left = mergeSort(left);
        right = mergeSort(right);

        Node result = merge(left, right);
        return result;
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a sample linked list
        Node head = new Node(5);
        head.next = new Node(3);
        head.next.next = new Node(8);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);

        System.out.println("Original Linked List:");
        printList(head);

        // Sorting the linked list using merge sort
        head = mergeSort(head);

        System.out.println("Sorted Linked List:");
        printList(head);
    }
}

