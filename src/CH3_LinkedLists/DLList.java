package CH3_LinkedLists;

public class DLList {
    public DLLNode head;
    public DLLNode tail;
    public int count;

    public DLList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public DLList(int[] arr) {
        DLLNode current = new DLLNode(arr[0]);
        current.prev = null;
        this.head = current;
        DLLNode next = new DLLNode(arr[1]);
        this.count = arr.length;

        for (int i = 1; i < arr.length; i++) {
            next = new DLLNode(arr[i]);
            current.next = next;
            next.prev = current;

            current = next;
        }
        this.tail = next;
        next.next = null;
    }

    public void insertEnd(int x) {
        DLLNode toInsert = new DLLNode(x);
        if(this.head == null) {
            this.head = toInsert;
            this.tail = toInsert;
            this.count++;
            return;
        }
        this.tail.next = toInsert;
        toInsert.prev = this.tail;
        this.tail = toInsert;
        this.count++;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void printDLL() {
        DLLNode iter = head;
        while(iter != null) {
            System.out.print(iter.data);
            if(iter.next != null)
                System.out.print(" <-> ");
            iter = iter.next;
        }
        System.out.println();
    }

    public void printDLLBw() {
        DLLNode iter = tail;
        while(iter != null) {
            System.out.print(iter.data);
            if(iter.prev != null)
                System.out.print(" <-> ");
            iter = iter.prev;
        }
        System.out.println();
    }

    public void printInfo() {
        System.out.println("Head: " + this.head.data);
        System.out.println("Tail: " + this.tail.data);
        System.out.println("Count: " + this.count);
    }

}
