
class Node {
    int data;
    Node next;

    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class recursive_search {
   
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
    public int helper(Node head, int key) {
        if(head == null){
            return -1;//BASE CASE
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }

        return idx+1;
    }
    
    public int recSearch(int key) {
        return helper(head, key);
    }
    public static void main(String[] args) {
        recursive_search list = new recursive_search();

        // Adding elements to the list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // Searching for a key
        int key = 30;
        int index = list.recSearch(key);

        // Printing the result
        if (index != -1) {
            System.out.println("Key " + key + " found at index: " + index);
        } else {
            System.out.println("Key " + key + " not found in the list.");
        }
    }
}
