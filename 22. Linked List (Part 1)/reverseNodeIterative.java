class Node {
    int data;
    Node next;

    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class reverseNodeIterative {
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

    // Method to reverse the linked list iteratively
    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
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
        reverseNodeIterative list = new reverseNodeIterative();

        // Adding elements to the list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // Print the original list
        System.out.println("Original list:");
        list.print();

        // Reverse the list
        list.reverse();

        // Print the reversed list
        System.out.println("Reversed list:");
        list.print();
    }
}
