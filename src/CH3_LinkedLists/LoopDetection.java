package CH3_LinkedLists;

public class LoopDetection {
    private static boolean hasLoop(LinkedList_ list) {
        LinkedList_.LLNode iter = list.head;
        LinkedList_.LLNode fast = list.head;

        while (fast != null && fast.next != null) {
            iter = iter.next;
            fast = fast.next.next;

            if (iter == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Make circular list
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        LinkedList_ list = new LinkedList_(array);

        LinkedList_.LLNode node6 = list.head;
        for (int i = 0; i < 5; i++) {
            node6 = node6.next;
        }

        LinkedList_.LLNode node10 = node6;
        while (node10.next != null) {
            node10 = node10.next;
        }
        node10.next = node6;

        System.out.println(hasLoop(list));

        LinkedList_ noLoop = new LinkedList_(array);

        System.out.println(hasLoop(noLoop));
    }
}
