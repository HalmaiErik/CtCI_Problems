package CH2_LinkedLists;

import java.util.HashSet;

public class RemoveDups {
    // additional memory: HashSet
    // O(1) check if is duplicate
    // O(n)
    static void removeV1(DLList dll) {
        HashSet<Integer> set = new HashSet<Integer>();
        DLLNode iter = dll.head;
        while(iter != null) {
            if(set.contains(iter.data)) {
                if(iter != dll.head)
                    iter.prev.next = iter.next;
                if(iter != dll.tail)
                    iter.next.prev = iter.prev;
                else {
                    dll.tail = iter.prev;
                    iter.prev.next = null;
                }
                dll.count--;
            }
            else {
                set.add(iter.data);
            }
            iter = iter.next;
        }
    }

    // no additional memory
    static void removeV2(DLList dll) {
        DLLNode iter = dll.head;
        while(iter != null) {
            DLLNode runner = dll.head;
            while (runner != iter) {
                if (runner.data == iter.data) {
                    if(iter != dll.head)
                        iter.prev.next = iter.next;
                    if(iter != dll.tail)
                        iter.next.prev = iter.prev;
                    else {
                        dll.tail = iter.prev;
                        iter.prev.next = null;
                    }
                    dll.count--;
                    break;
                }
                runner = runner.next;
            }
                iter = iter.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 1 ,5, 7, 8, 7};
        DLList dll = new DLList(arr);
        dll.printDLL();
        dll.printDLLBw();
        dll.printInfo();

        System.out.println("After removal v1:");
        removeV1(dll);
        dll.printDLL();

        dll = new DLList(arr);
        System.out.println("After removal v2:");
        removeV2(dll);
        dll.printDLL();

    }
}
