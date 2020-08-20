package CH2_ArraysAndStrings;


public class StringRotation {
    //check if s2 substring of s1
    public static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }

    //originalStr rotation of rotStr => if take newStr = originalStr + originalStr we get every possible rotation of
    //originalStr in newStr => we can check isSubstring(newStr, rotStr)
    public static boolean isRotation(String originalStr, String rotStr) {
        if(originalStr.length() == rotStr.length()) {
            String newStr = originalStr + originalStr;
            return isSubstring(newStr, rotStr);
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] examples = {{"waterbottle", "erbottlewat"}, {"erik", "keri"}, {"abcd", "bcad"}};
        for (String[] example: examples) {
            String w1 = example[0];
            String w2 = example[1];
            System.out.println(w1 + " " + w2 + ": " + isRotation(w1, w2));
        }
    }
}
