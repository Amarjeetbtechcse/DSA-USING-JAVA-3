public class AddPrint_linkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        } 
    }

    public Node head;
    public Node tail;

    public void addFirst(int data) {
        Node newNode = new Node(data); // Moved up to define newNode before use

        if (head == null) {
            head = tail = newNode; // Now uses the initialized newNode
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void addMiddle(int index,int data){
        if(index == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;

        while (i < index -1){
            temp = temp.next;
            i++;
        }

        //i = index-1 ; temp -> previous
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void print() {
        if (head == null) {
            System.out.println("LL is empty.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AddPrint_linkedList ll = new AddPrint_linkedList(); // Fixed instantiation of Add_linkedList

        ll.print();

        ll.addFirst(2);
        ll.print();

        ll.addFirst(1);
        ll.print();

        ll.addLast(3);
        ll.print();

        ll.addLast(4);
        ll.print();

        ll.addMiddle(2, 10);
        ll.print();
    }
}

