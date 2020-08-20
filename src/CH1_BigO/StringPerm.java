package CH1_BigO;

/**
 * nr possible permutations: n!
 * nr calls of permutation method until print: n (str.length())
 * work in each call O(n) (from print + construction of rem)
 * IN TOTAL: O(n^2 * n!)
 */

public class StringPerm {
    static void permutation(String str) {
        permutation(str, "");
    }

    static void permutation(String str, String prefix) {
        if(str.length() == 0) {
            System.out.println(prefix);
        }
        else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        permutation("erik");
    }
}
