package CH2_LinkedLists;

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
            iter = iter.next;
        }

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

    public static void partitionLL(LinkedList_ list, int x) {
        LinkedList_.LLNode iter = list.head;
        LinkedList_.LLNode prev = iter;

        while (iter != null) {
            if (iter != list.head && iter.value < x) {
                prev.next = iter.next;
                iter.next = list.head;
                list.head = iter;

                iter = prev.next;
            }
            else {
                prev = iter;
                iter = iter.next;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 5, 10, 2, 1};
        DLList dll = new DLList(arr);
        dll.printDLL();
        dll.printDLLBw();
        dll.printInfo();
        System.out.println();

        DLList result = new DLList();
        result = partition(dll, 5);
        result.printDLL();

        System.out.println();

        LinkedList_ list = new LinkedList_(arr);
        partitionLL(list, 5);
        list.showList();
    }
}
