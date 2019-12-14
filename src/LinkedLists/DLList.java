package LinkedLists;

public class DLList {
    public DLLNode head;
    public DLLNode tail;
    public int count;

    public DLList() {
        this.head = null;
    }

    public DLList(int arr[]) {
        DLLNode current = new DLLNode(arr[0]);
        DLLNode next = new DLLNode(arr[1]);
        this.count = arr.length;

        for (int i = 1; i < arr.length; i++) {
            next = new DLLNode(arr[i]);
            current.next = next;
            next.prev = current;

            if(i == 1)
                this.head = current;
            else if(i == arr.length - 1)
                this.tail = next;

            current = next;
        }
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

    public void printHead() {
        System.out.println("Head: " + this.head.data);
        System.out.println("Tail: " + this.tail.data);
        System.out.println("Count: " + this.count);
    }

}
