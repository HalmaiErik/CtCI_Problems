package CH3_StackAndQueues;

/***
 * Sort a stack using only ONE temporary stack.
 *
 * Can't use merge or quick sort, because we would need 2 additional stacks
 * for them (for the division).
 *
 * Other solution: pop top, put it in the right place in temp. stack by moving
 * the bigger elements  O(n^2)
 */

public class SortStack {
    public static void sort(MyStack<Integer> s) {
        MyStack<Integer> tempStack = new MyStack<Integer>();
        while(!s.isEmpty()) {
            int tempInt = s.pop();
            while(!tempStack.isEmpty() && tempStack.peek() > tempInt) {
                s.push(tempStack.pop());
            }
            tempStack.push(tempInt);
        }

        // Copy back
        while (!tempStack.isEmpty()) {
            s.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<Integer>();
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);

        sort(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
