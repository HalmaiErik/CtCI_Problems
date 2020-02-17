package LinkedLists;

// Because I use a dll, the code would be almost the same for the follow up

public class SumList {
    static DLList createLL(int x) {
        DLList result = new DLList();
        while(x != 0) {
            result.insertEnd(x%10);
            x = x/10;
        }
        return result;
    }

    static DLList sumLL(DLList x, DLList y) {
        DLList result = new DLList();
        DLLNode xIter = x.head;
        DLLNode yIter = y.head;
        

        while(xIter != null)
    }

    public static void main(String[] args) {
        int x = 617, y = 295;
        DLList xList = createLL(x);
        DLList yList = createLL(y);
        xList.printDLL();
        yList.printDLL();


    }
}
