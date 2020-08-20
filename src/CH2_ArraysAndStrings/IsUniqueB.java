package CH2_ArraysAndStrings;

// doesn't use additional memory but checks only for lowercase letters

public class IsUniqueB {
    // O(n)
    static boolean isUnique(String word) {
        if(word.length() > 26)
            return false;
        int checker = 0;
        for (int i = 0; i < word.length(); i++) {
            int letterInt = word.charAt(i) - 'a';
            if((checker & (1 << letterInt)) > 0)
                return false;
            checker = checker | (1 << letterInt);
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "alma", "eper", "letma"};
        for(String word : words) {
            System.out.println(word + ": " + isUnique(word));
        }
    }

}
