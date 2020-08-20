package CH4_StackAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackOfPlates {
    ArrayList<MyStack<Integer>> stacks = new ArrayList<MyStack<Integer>>();
    private int capacity;

    public StackOfPlates(int capacity) {
        this.capacity = capacity;
    }

    public MyStack<Integer> getLastStack() {
        if(stacks.size() == 0) {
            return null;
        }
        else return stacks.get(stacks.size() - 1);
    }

    public void push(int x) {
        MyStack<Integer> last = getLastStack();

        if(last != null && last.getSize() < capacity) {
            last.push(x);   // Add to last
        }
        else {
            MyStack<Integer> newStack = new MyStack<Integer>();     // Create new stack
            newStack.push(x);
            stacks.add(newStack);
        }
    }

    public int pop() {
        MyStack<Integer> last = getLastStack();

        if(last == null) throw new EmptyStackException();
        int x = last.pop();
        if(last.getSize() == 0)
            stacks.remove(stacks.size() - 1);
        return x;
    }

    private void shift(int index) {
        int val = getLastStack().pop();
        stacks.get(index).push(val);
    }

    public int popAt(int index) {
        if (index == stacks.size() - 1) {
            return pop();
        }
        else {
            MyStack<Integer> stack = stacks.get(index);
            int x = stack.pop();
            shift(index);
            return x;
        }
    }

    public void showStacks() {
        for (MyStack<Integer> stack : stacks) {
            stack.showStack();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        StackOfPlates test = new StackOfPlates(3);
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        test.push(6);
        test.push(7);
        test.push(8);
        test.push(9);
        test.push(10);

        test.pop();
        test.pop();
        test.showStacks();
        System.out.println();
        System.out.println();

        test.popAt(0);
        test.showStacks();
    }
}
