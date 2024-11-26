class Node {
    int data;
    Node next;

    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class checkPalindrome {
    Node head; // Head of the linked list

    // Method to find the middle of the linked list
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // slow will be the middle node
    }

    // Method to reverse the linked list starting from a given node
    public Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev; // prev will be the new head of the reversed list
    }

    // Method to check if the linked list is a palindrome
    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true; // Empty list or single element list is a palindrome
        }

        // Step 1: Find the middle node
        Node midNode = findMid(head);

        // Step 2: Reverse the second half of the list
        Node secondHalf = reverse(midNode);

        // Step 3: Compare the first half and the reversed second half
        Node firstHalf = head;
        Node secondHalfCopy = secondHalf; // To restore the original list after comparison
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false; // Not a palindrome
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Optional: Restore the original list by reversing the second half back
        reverse(secondHalfCopy);

        return true; // The list is a palindrome
    }

    // Method to add a new node at the end of the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Method to print the linked list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        checkPalindrome list = new checkPalindrome();

        // Adding elements to the list
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(1);

        // Print the list
        System.out.println("Linked List:");
        list.print();

        // Check if the list is a palindrome
        if (list.checkPalindrome()) {
            System.out.println("The list is a palindrome.");
        } else {
            System.out.println("The list is not a palindrome.");
        }
    }
}
