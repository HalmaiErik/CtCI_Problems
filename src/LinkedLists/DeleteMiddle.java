package LinkedLists;

public class DeleteMiddle {
    static void delete(DLLNode node, DLList dll) {
        DLLNode iter = dll.head;
        while(iter != null && iter != node) {
            iter = iter.next;
        }

        if(iter == null) {
            System.out.println("Node not found");
            return;
        }

        if(iter != dll.head)
            iter.prev.next = iter.next;
        else {
            dll.head = iter.next;
            iter.next.prev = null;
        }
        if(iter != dll.tail)
            iter.next.prev = iter.prev
    }
}
