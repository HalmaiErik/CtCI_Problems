package CH1_ArraysAndStrings;

//O(n)
//constant additional memory

public class OneAway {
    static boolean oneA(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1)
            return false;
        int[] characters = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            int val = s1.charAt(i);
            characters[val]++;
        }

        boolean oneOther = false;   // true if one char diff between s1 & s2
        for (int i = 0; i < s2.length(); i++) {
            int val = s2.charAt(i);
            characters[val]--;
            if(characters[val] < 0) {
                if(oneOther)
                    return false;
                oneOther = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"pale", "ple"}, {"pales", "pale"}, {"pale", "bale"}, {"pale", "bake"}};
        for(String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            System.out.println(word1 + " " + word2 + ": " + oneA(word1, word2));
        }
    }
}
