package ArraysAndStrings;

import java.util.Arrays;

public class checkPerm {
    //sort: O(n * log n)
    //equals: O(n)
    //toCharArr: O(n)
    //total: O(n * log n + n)
    static boolean checkPerm(String s, String t) {
        if(s.length() != t.length())
            return false;

        char[] arrS = s.toCharArray();
        java.util.Arrays.sort(arrS);

        char[] arrT = t.toCharArray();
        java.util.Arrays.sort(arrT);

        return Arrays.equals(arrS, arrT);
    }

    static boolean checkPerm2(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] letters = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            letters[val]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int val = t.charAt(i);
            letters[val]--;
            if(letters[val] < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"erik", "rike"}, {"elephant", "aleephnnt"}};
        System.out.println("v1.0:");
        for(String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            System.out.println(word1 + " " + word2 + ": " + checkPerm(word1, word2));

        }
        System.out.println("v2.0:");
        for(String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            System.out.println(word1 + " " + word2 + ": " + checkPerm2(word1, word2));
        }
    }
}
