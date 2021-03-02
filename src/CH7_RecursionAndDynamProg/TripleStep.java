package CH7_RecursionAndDynamProg;

import java.util.Arrays;
import java.util.List;

public class TripleStep {
    // Recursion
    private static int countStepsNoMem(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return countStepsNoMem(n-1) + countStepsNoMem(n-2) + countStepsNoMem(n-3);
    }

    // Memoization
    private static int countStepsMem(int n) {
        int[] mem = new int[n + 1];
        Arrays.fill(mem, -1);
        return countStepsMem(n, mem);
    }

    private static int countStepsMem(int n, int[] mem) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (mem[n] > -1) {
            return mem[n];
        }
        else {
            mem[n] = countStepsMem(n - 1, mem) + countStepsMem(n - 2, mem) + countStepsMem(n - 3, mem);
            return mem[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(countStepsNoMem(10));
        System.out.println(countStepsMem(10));
    }
}
