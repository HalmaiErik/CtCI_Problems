package CH7_RecursionAndDynamProg;

import java.util.HashSet;

public class MagicIndex {
    private static int findOneMagicIndex(int[] sortedArray) {
        return findOneMagicIndex(sortedArray, 0, sortedArray.length - 1);
    }

    private static int findOneMagicIndex(int[] sortedArray, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (sortedArray[mid] == mid) {
            return mid;
        }
        else if (sortedArray[mid] < mid) {
            return findOneMagicIndex(sortedArray, mid + 1, right);
        }
        else {
            return findOneMagicIndex(sortedArray, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(findOneMagicIndex(new int[] {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13}));
    }
}
