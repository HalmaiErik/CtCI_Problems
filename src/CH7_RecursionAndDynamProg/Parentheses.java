package CH7_RecursionAndDynamProg;

import java.util.Stack;

public class Parentheses {
    private static boolean checkParanthesis(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.add(str.charAt(i));
            }
            else if (str.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkParanthesis(")(())"));
        System.out.println(checkParanthesis("((()))("));
        System.out.println(checkParanthesis("()(((())))()())"));
        System.out.println(checkParanthesis("()(((())))()()"));
    }
}
