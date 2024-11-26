class Node {
    int data;
    Node next;

    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class iterativeSearch {
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

    // Iterative search method
    public int iterative_search(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i; // Key found, return index
            }
            temp = temp.next;
            i++;
        }
        return -1; // Key not found
    }

    // Main method to run the program
    public static void main(String[] args) {
        iterativeSearch list = new iterativeSearch();

        // Adding elements to the list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // Searching for a key
        int key = 30;
        int index = list.iterative_search(key);

        // Printing the result
        if (index != -1) {
            System.out.println("Key " + key + " found at index: " + index);
        } else {
            System.out.println("Key " + key + " not found in the list.");
        }
    }
}
