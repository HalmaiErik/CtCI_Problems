package StackAndQueues;

import java.util.NoSuchElementException;

public class QueueViaStack {
    private static class MyQueue {
        MyStack<Integer> queueFront;
        MyStack<Integer> queueBack;

        public MyQueue() {
            queueBack = new MyStack<Integer>();
            queueFront = new MyStack<Integer>();
        }

        public void add(int x) {
            queueBack.push(x);
        }

        public int remove() {
            if(queueFront.isEmpty()) {
                while(!queueBack.isEmpty()) {
                    queueFront.push(queueBack.pop());
                }
            }

            return queueFront.pop();
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
