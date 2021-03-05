package CH7_RecursionAndDynamProg;

public class PrintStringPermutations {
    private static void print(String remainingString, String fixedString) {
        if (remainingString.length() == 0) {
            System.out.println(fixedString);
            return;
        }

        boolean[] alpha = new boolean[26];
        for (int i = 0; i < remainingString.length(); i++) {
            char newFixedChar = remainingString.charAt(i);
            String newRemainingString = remainingString.substring(0, i) + remainingString.substring(i + 1);

            if (checkDistinct(alpha, newFixedChar)) {
                print(newRemainingString, fixedString + newFixedChar);
            }
            alpha[newFixedChar - 'a'] = true;
        }
    }

    private static boolean checkDistinct(boolean[] alphabet, char c) {
        if (alphabet[c - 'a']) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        print("geek", "");
    }
}
