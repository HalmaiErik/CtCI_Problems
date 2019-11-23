package LinkedLists;

import java.util.HashSet;

public class RemoveDups {
    // additional memory: HashSet
    // O(1) check if is duplicate
    // O(n)
    static void removeV1(DoublyLinkedList dll) {
        HashSet<Integer> set = new HashSet<Integer>();
        DLLNode iter = dll.head;
        while(iter != null) {
            if(set.contains(iter.data)) {
                iter.prev.next = iter.next;
                iter.next.prev = iter.prev;
            }
            else {
                set.add(iter.data);
            }
            iter = iter.next;
        }
    }

    // no additional memory
    static void removeV2(DoublyLinkedList dll) {
        DLLNode iter = dll.head;
        while(iter != null) {
            DLLNode runner = iter;
            while(runner != null) {
                if()
            }
        }
    }
}
