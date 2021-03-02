package CH3_StackAndQueues;

import java.util.EmptyStackException;

public class MyStack<T> {
    static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;
    private int size;

    public MyStack() {
        top = null;
        size = 0;
    }

    public MyStack(T[] array) {
        top = null;
        size = 0;

        for (T t : array) {
            this.push(t);
        }
    }

    public T pop() {
        if(top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        size--;
        return item;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
        size++;
    }

    public T peek() {
        if(top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }

    public void showStack() {
        StackNode<T> iter = top;

        while (iter != null) {
            System.out.println("| " + iter.data + " |");
            System.out.println("-----");
            iter = iter.next;
        }
    }
}
