// 15

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    int getMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}

public class findmiddle {
    public static void main(String[] args) {
        // Create a sample linked list
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Create an instance of Solution
        Solution solution = new Solution();

        // Call the getMiddle method
        int middle = solution.getMiddle(head);

        // Print the middle value
        System.out.println("Middle value: " + middle);
    }
}
