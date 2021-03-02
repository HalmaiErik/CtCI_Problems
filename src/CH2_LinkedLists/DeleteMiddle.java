package CH2_LinkedLists;

public class DeleteMiddle {
    static void delete(DLLNode node, DLList dll) {
        if(node.data == dll.head.data || node.data == dll.tail.data) {
            System.out.println("Tail or head can't be deleted");
        }

        DLLNode iter = dll.head;
        while(iter != null && iter.data != node.data) {
            iter = iter.next;
        }

        if(iter == null) {
            System.out.println("Node not found");
            return;
        }

        iter.prev.next = iter.next;
        iter.next.prev = iter.prev;
        dll.count--;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 1 ,5, 7, 8, 7};
        DLList dll = new DLList(arr);
        dll.printDLL();
        dll.printDLLBw();
        dll.printInfo();
        System.out.println();

        DLLNode node = new DLLNode(5);
        delete(node, dll);
        dll.printDLL();
    }
}
