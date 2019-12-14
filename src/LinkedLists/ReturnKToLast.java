package LinkedLists;

public class ReturnKToLast {
    static DLLNode kToLast(DLList dll, int k) {
        DLLNode iter = dll.tail;
        for (int i = 0; i < k; i++)
            iter = iter.prev;
        return iter;
    }

    static void kthLast(DLList dll) {
        for(int i = 0; i < dll.count; i++) {
            DLLNode iter = kToLast(dll, i);
            System.out.println(i + ". to last:" + iter.data);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 1 ,5, 7, 8, 7};
        DLList dll = new DLList(arr);
        dll.printDLL();
        dll.printDLLBw();
        dll.printHead();

        kthLast(dll);
    }
}
