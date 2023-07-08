class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class palindromesll {
    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true; // An empty list or a list with a single node is considered a palindrome
        }

        Node slow = head;
        Node fast = head;

        // Find the middle node of the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        Node secondHalf = reverse(slow);
        Node firstHalf = head;

        // Compare the first half with the reversed second half
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false; // Nodes don't match, not a palindrome
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true; // All nodes matched, it's a palindrome
    }

    // Helper function to reverse a linked list
    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a sample linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        Solution solution = new Solution();
        boolean isPalindrome = solution.isPalindrome(head);

        if (isPalindrome) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
