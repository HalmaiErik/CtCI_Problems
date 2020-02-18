package StackAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackOfPlates {
    ArrayList<MyStack<Integer>> stacks = new ArrayList<MyStack<Integer>>();
    private int capacity;

    public StackOfPlates(int capacity) {
        this.capacity = capacity;
    }

    public MyStack getLastStack() {
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

    public Integer pop() {
        MyStack<Integer> last = getLastStack();

        if(last == null) throw new EmptyStackException();
        Integer x = last.pop();
        if(last.getSize() == 0)
            stacks.remove(stacks.size() - 1);
        return x;
    }
}
