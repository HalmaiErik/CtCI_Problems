package StackAndQueues;

public class StackMin extends MyStack<Integer> {
    MyStack<Integer> st;

    public StackMin() {
        st = new MyStack<Integer>();
    }

    public int min() {
        if(st.isEmpty())
            return Integer.MAX_VALUE;
        else
            return st.peek();
    }

    public void push(int value) {
        if(value <= min())
            st.push(value); // Add to min stack
        super.push(value);  // Add to main stack
    }

    public Integer pop() {
        int value = super.pop();
        if(value == min())
            st.pop();
        return value;
    }

    public static void main(String[] args) {
        StackMin stack = new StackMin();

        int[] arr = {7, 3, 6, 2, 8, 9};
        for (int value : arr) {
            stack.push(value);
            System.out.print(value + ", ");
        }
        System.out.println("\n");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Popped " + stack.pop());
            System.out.println("New min is: " + stack.min());
        }
    }
}
