package CH3_LinkedLists;

public class DLLNode {
    public DLLNode next;
    public DLLNode prev;
    public int data;

    public DLLNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
