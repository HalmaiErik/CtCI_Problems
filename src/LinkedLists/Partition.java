package LinkedLists;

public class Partition {
    static DLList partition(DLList dll, int x) {
        DLLNode iter = dll.head;
        DLList before = new DLList();
        DLList after = new DLList();
        while(iter != null) {
            if(iter.data < x) {
                before.insertEnd(iter.data);
            }
            else after.insertEnd(iter.data);
        }
        before.printDLL();
        after.printDLL();
        if(before.isEmpty())
            return after;
        else {
            before.tail.next = after.head;
            after.head.prev = before.tail;
            before.tail = after.tail;
            before.count += after.count;
        }
        return before;
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 7, 4, 6, 5};
        DLList dll = new DLList(arr);
        dll.printDLL();
        dll.printDLLBw();
        dll.printInfo();
        System.out.println();

        DLList result = new DLList();
        result = partition(dll, 5);
        result.printDLL();
    }
}
