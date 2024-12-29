public class RemoveLoopInLL {
    public static boolean detectLoop(Node head) {
        if (head == null) {
            return false;
        }

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // Cycle detected
                return true;
            }
        }
        return false; // No cycle
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head; // Creating a cycle

        System.out.println(detectLoop(head)); // Output: true
    }
}

    public static void main(string[](args)){
        
    }

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
