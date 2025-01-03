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
    public int size;

    public void addFirst(int data) {
        Node newNode = new Node(data); // Moved up to define newNode before use

        size++;

        if (head == null) {
            head = tail = newNode; // Now uses the initialized newNode
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
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
        size++;
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

    public int removeFirst() {
        if(size == 0) {
            System.out.println("LL is empty.");
            return Integer.MIN_VALUE;
        }else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head =head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if(size == 0) {
            System.out.println("LL is empty.");
            return Integer.MAX_VALUE;
        }else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // prev : i = size-2
        Node prev = head;
        for(int i =0; i<size-2; i++){
            prev = prev.next;
        }

        int val = prev.next.data; //tail.data
        prev.next = null;
        tail = prev;
         size--;
         return val;
    }

    public int iterativeSearch(int key) {
        Node temp = head;
        int i = 0;

        while (temp != null){
            if(temp.data == key) {
                //key found
                return i;
            }
            temp = temp.next;
            i++;
        }
        //key not found
        return -1;
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

        ll.addMiddle(2, 5);
        ll.print();

        System.out.println("Total size is :"+ll.size);

        ll.removeFirst();
        ll.print();

        ll.removeLast();
        ll.print();
        System.out.println("Total size is :"+ll.size);

        
        System.out.println("Item is found at index:"+ll.iterativeSearch(5));
        System.out.println("Item is found at index:"+ll.iterativeSearch(30));
    }
}