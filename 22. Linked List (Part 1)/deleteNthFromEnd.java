class Node {
    int data;
    Node next;

    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class deleteNthFromEnd {
    Node head; // Head of the linked list

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

    public void deleteFromEnd(int n) {
        int size = 0;
        Node temp = head;

        // Calculate the size of the list
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // If n is greater than the size, do nothing
        if (n > size) {
            System.out.println("Invalid position: " + n);
            return;
        }

        // If the head needs to be removed
        if (n == size) {
            head = head.next;
            return;
        }

        // Find the previous node of the node to be deleted
        int i = 1;
        int iToFind = size - n; // Corrected logic
        Node prev = head;

        while (i < iToFind) {
            prev = prev.next;
            i++;
        }

        // Remove the nth node from the end
        prev.next = prev.next.next;
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
        deleteNthFromEnd list = new deleteNthFromEnd();

        // Adding elements to the list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // Print the list
        System.out.println("Original List:");
        list.print();

        // Delete the 3rd node from the end
        list.deleteFromEnd(3);
        System.out.println("After deleting 3rd node from the end:");
        list.print();
    }
}
