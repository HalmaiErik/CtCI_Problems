package ArraysAndStrings;

// palindrome => max 1 letter can be present an odd number of times
// if more than 1 => not a palindrome

public class PalindromePerm {
    public static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');

        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    public static int[] buildCharFrequencyTable(String str) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : str.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }


    static boolean checkPal(int[] table) {
        boolean oneOdd = false;
        for (int i = 0; i < table.length; i++) {
            if(table[i] % 2 == 1) {
                if(oneOdd)
                    return false;
                oneOdd = true;
            }
        }
        return true;
    }

    static boolean palPerm(String str) {
        int[] table = buildCharFrequencyTable(str);
        return checkPal(table);
    }

    public static void main(String[] args) {
        String[] examples = {"Tact Coa", "Merge Sort", "Alma Lmb"};
        for (String ex : examples)
            System.out.println(ex + ": " + palPerm(ex));
    }
}
