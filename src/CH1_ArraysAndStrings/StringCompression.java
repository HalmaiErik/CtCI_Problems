package CH1_ArraysAndStrings;

public class StringCompression {
    static String compress(String str) {
        String compressedStr = "";
        int nrConsecutiveChars = 0;
        for (int i = 0; i < str.length(); i++) {
            nrConsecutiveChars++;
            if(i + 1 == str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedStr = compressedStr + "" + str.charAt(i) + nrConsecutiveChars;
                nrConsecutiveChars = 0;
            }
        }
        if(str.length() <= compressedStr.length())
            return str;
        return compressedStr;
    }

    public static void main(String[] args) {
        String[] examples = {"aaaabbcc", "abc", "eaaaaabbbbcc"};
        for(String example : examples) {
            System.out.println(example + " " + compress(example));
        }
    }
}
