package CH2_ArraysAndStrings;

//uses O(123) additional memory

public class IsUniqueA {
    // O(n)
    static boolean isUnique(String word) {
        if(word.length() > 128)
            return false;
        boolean[] checker = new boolean[128];
        for (int i = 0; i < word.length(); i++) {
            int letterInt = word.charAt(i);
            if(checker[letterInt])
                return false;
            checker[letterInt] = true;
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
