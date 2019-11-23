package BigO;

/**
 * returns powers of 2 in [1, n]
 * O(log n) - n / 2 until reaches 1 = log n
 */

public class PowersOf2 {
    static int powersOf2(int n) {
        if (n < 1) {
            return 0;
        }
        else if (n == 1) {
            System.out.println(1);
            return 1;
        }
        else {
            int prev = powersOf2(n / 2);
            int curr = prev * 2;
            System.out.println(curr);
            return curr;
        }
    }

    public static void main(String[] args) {
        powersOf2(10);
    }
}
