package CH2_LinkedLists;

public class SumListsLL {
    public static void sumListsBack(LinkedList_.LLNode result, LinkedList_.LLNode list1,
                                    LinkedList_.LLNode list2, int rest) {
        if (list1 == null && list2 == null) {
            if (rest != 0) {
                result.value = rest;
            }
            return;
        }

        int sum = rest;
        if (list1 != null) {
            sum += list1.value;
        }
        if (list2 != null) {
            sum += list2.value;
        }

        if (sum < 10) {
            result.value = sum;
            rest = 0;
        }
        else {
            result.value = sum % 10;
            rest = sum / 10;
        }

        result.next = new LinkedList_.LLNode(0);

        if (list1 == null)
            sumListsBack(result.next, null, list2.next, rest);
        else if (list2 == null) 
            sumListsBack(result.next, list1.next, null, rest);
        else
            sumListsBack(result.next, list1.next, list2.next, rest);

    }

    public static void sumListsForward(LinkedList_ result_list, LinkedList_ list1, LinkedList_ list2) {
        LinkedList_.LLNode result = result_list.head;
        LinkedList_.LLNode prev = result;
        LinkedList_.LLNode iter1 = list1.head;
        LinkedList_.LLNode iter2 = list2.head;

        while (iter1 != null && iter2 != null) {
            int sum = iter1.value + iter2.value;

            if (sum > 10) {
                int rest = sum / 10;

                if (result == result_list.head) {
                    LinkedList_.LLNode newHead = new LinkedList_.LLNode(rest);
                    newHead.next = result;
                    result_list.head = newHead;
                }
                else {
                    prev.value += rest;
                }
                result.value = sum % 10;
            }
            else {
                result.value = sum;
            }

            prev = result;
            result.next = new LinkedList_.LLNode(0);
            result = result.next;
            iter1 = iter1.next;
            iter2 = iter2.next;
        }

        while (iter1 != null) {
            result.next = new LinkedList_.LLNode(iter1.value);
            iter1 = iter1.next;
            result = result.next;
        }

        while (iter2 != null) {
            result.next = new LinkedList_.LLNode(iter2.value);
            iter2 = iter2.next;
            result = result.next;
        }
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 6, 7};
        int[] array2 = {2, 8, 9, 0, 0, 2};

        LinkedList_ list1 = new LinkedList_(array1);
        LinkedList_ list2 = new LinkedList_(array2);
        LinkedList_ result = new LinkedList_(new int[] {0});

        sumListsBack(result.head, list1.head, list2.head, 0);
        result.showList();
        System.out.println();

        int[] arr1 = {7, 6, 9};
        int[] arr2 = {4, 1, 3};
        LinkedList_ l1 = new LinkedList_(arr1);
        LinkedList_ l2 = new LinkedList_(arr2);
        LinkedList_ res = new LinkedList_(new int[] {0});

        sumListsForward(res, l1, l2);
        res.showList();
    }
}
