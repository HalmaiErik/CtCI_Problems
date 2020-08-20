package CH3_LinkedLists;

import java.util.Stack;

public class Palindrome {
    private static boolean isPalindrome(LinkedList_ list) {
        LinkedList_.LLNode head = list.head;
        Stack<LinkedList_.LLNode> stack = new Stack<>();

        LinkedList_.LLNode iter = head;
        LinkedList_.LLNode fastIter = head;

        while (fastIter != null && fastIter.next != null) {
            stack.push(iter);
            iter = iter.next;
            fastIter = fastIter.next.next;
        }

        if (fastIter != null) {
            iter = iter.next;
        }

        while (iter != null) {
            LinkedList_.LLNode top = stack.pop();

            if (top.value != iter.value) {
                return false;
            }
            iter = iter.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arrPal1 = {1, 2, 3, 3, 2, 1};
        LinkedList_ pal1 = new LinkedList_(arrPal1);
        int[] arrPal2 = {1, 2, 3, 2, 1};
        LinkedList_ pal2 = new LinkedList_(arrPal2);
        int[] arr1 = {1, 2, 3, 2, 2};
        LinkedList_ l1 = new LinkedList_(arr1);
        int[] arr2 = {1, 2, 3, 3, 1, 1};
        LinkedList_ l2 = new LinkedList_(arr2);

        System.out.println(isPalindrome(pal1));
        System.out.println(isPalindrome(pal2));
        System.out.println(isPalindrome(l1));
        System.out.println(isPalindrome(l2));
    }
}
