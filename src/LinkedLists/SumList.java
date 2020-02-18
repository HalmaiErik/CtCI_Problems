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
        int ten = 0;

        while(xIter != null) {
            result.insertEnd((xIter.data + yIter.data + ten) % 10);

            if(xIter.data + yIter.data + ten >= 10)
                ten = 1;
            else ten = 0;

            xIter = xIter.next;
            yIter = yIter.next;
        }

        if(yIter != null) {
            result.insertEnd(xIter.data + yIter.data + ten);
            while(yIter != null) {
                result.insertEnd(yIter.data);
                yIter = yIter.next;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int x = 617, y = 295;
        DLList xList = createLL(x);
        DLList yList = createLL(y);
        xList.printDLL();
        yList.printDLL();

        DLList result = sumLL(xList, yList);
        result.printDLL();
    }
}
