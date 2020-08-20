package CH1_BigO;

/**
 * O(2^n)
 * (actually smaller than that because at the bottom there is sometimes 1 call)
 */

public class NthFib {
    static int fib(int n) {
        if(n <= 0) return 0;
        else if(n == 1) return 1;
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fib(6));
    }
}
