package LinkedLists;

public class Partition {
    static DLList partition(DLList dll, int x) {
        DLLNode iter = dll.head;
        while(iter != null) {
            if(iter.data < x) {
                DLLNode temp = iter;
                if (iter != dll.head) {
                    if (temp != dll.tail) {
                        temp.next.prev = temp.prev;
                        temp.prev.next = temp.next;
                    } else {
                        dll.tail = temp.prev;
                        temp.prev.next = null;
                    }

                    temp.next = dll.head;
                    dll.head.prev = temp;
                    dll.head = temp;
                    dll.head.prev = null;
                }
            }

            else if (iter != dll.tail) {
                DLLNode temp = iter;
                if(temp != dll.head) {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                else {
                    dll.head = temp.next;
                    temp.next.prev = null;
                }

                temp.prev = dll.tail;
                dll.tail.next = temp;
                dll.tail = temp;
                dll.tail.next = null;
            }
            iter = iter.next;
        }
        return dll;
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 7, 4, 6, 5};
        DLList dll = new DLList(arr);
        dll.printDLL();
        dll.printDLLBw();
        dll.printHead();
        System.out.println();

        dll = partition(dll, 5);
        dll.printDLL();
    }
}
