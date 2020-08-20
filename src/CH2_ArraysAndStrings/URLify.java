package CH2_ArraysAndStrings;

public class URLify {
    static String urlify(String str, int tLength) {
        char[] arr = str.toCharArray();
        int spaceCount = 0;
        for (int i = 0; i < tLength ; i++) {
            if(arr[i] == ' ')
                spaceCount++;
        }
        int index = tLength + spaceCount * 2;
        if(tLength < arr.length)
            arr[tLength] = '\0';
        for (int i = tLength - 1; i >= 0; i--) {
            if(arr[i] == ' ') {
                arr[index - 1] = '0';
                arr[index - 2] = '2';
                arr[index - 3] = '%';
                index = index - 3;
            }
            else {
                arr[index - 1] = arr[i];
                index--;
            }

            int step = tLength - i;
            String temp = String.valueOf(arr);
            System.out.println("Step " + step + " -> " + temp);
        }
        str = String.valueOf(arr);
        return str;
    }

    public static int findLastCharacter(String str) {
        char[] arr = str.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != ' ')
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        int tLength = findLastCharacter(str) + 1;
        System.out.println(urlify(str, tLength));
    }
}
