package CH7_RecursionAndDynamProg;

public class PowerSet {
    private static void printPowerSet(char[] set, int setSize) {
        long powerSetSize = (long) Math.pow(2, setSize);

        // counter from 000...0 to 111...1
        for (int counter = 0; counter < powerSetSize; counter++) {
            for (int j = 0; j < setSize; j++) {
                // check jth bit in the counter and print if set
                if ((counter & (1 << j)) > 0) {
                    System.out.print(set[j]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPowerSet(new char[] {'a', 'b', 'c', 'd'}, 4);
    }
}
