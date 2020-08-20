package CH3_LinkedLists;

public class Intersection {
    private static boolean doesIntersect(LinkedList_ list1, LinkedList_ list2) {
        LinkedList_.LLNode head1 = list1.head;
        LinkedList_.LLNode head2 = list2.head;

        while (head1.next != null && head2.next != null) {
            head1 = head1.next;
            head2 = head2.next;
        }

        while (head1.next != null) {
            head1 = head1.next;
        }
        while (head2.next != null) {
            head2 = head2.next;
        }

        return head1.equals(head2);
    }
}
