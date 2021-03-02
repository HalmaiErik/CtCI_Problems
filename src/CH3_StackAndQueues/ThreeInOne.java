package CH3_StackAndQueues;

// Flexible splitting of arrays with shifts to avoid wasted memory
// Inspired by https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2003.%20Stacks%20and%20Queues/Q3_01_Three_in_One/MultiStack.java

import java.util.EmptyStackException;

public class ThreeInOne {
    private class FullStackException extends Exception {
        public FullStackException() {
            super();
        }

        public FullStackException(String msg) {
            super(msg);
        }
    }

    private class StackInfo {
        public int start, size, capacity;
        public StackInfo(int start, int capacity) {
            this.start = start;
            this.capacity = capacity;
        }

        private boolean isWithinStackCapacity(int ind) {
            // outside of bounds
            if(ind < 0 || ind >= values.length)
                return false;

            // index wraps around => adjust it
            int contInd = ind < start ? ind + values.length : ind;
            int end = start + capacity;
            return start <= contInd && contInd < end;
        }

        public int  lastCapacityInd() {
            return adjustInd(start + capacity - 1);
        }

        public int lastElementInd() {
            return adjustInd(start + size - 1);
        }

        public boolean isFull() {
            return size == capacity;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    private StackInfo[] info;
    private int[] values;

    public ThreeInOne(int numberOfStacks, int defaultSize) {
        info = new StackInfo[numberOfStacks];
        for (int i = 0; i < numberOfStacks; i++) {
            info[i] = new StackInfo(defaultSize * i, defaultSize);
        }
        values = new int[numberOfStacks * defaultSize];
    }

    /**
     * Checks number of items in the stack.
     * @return number of items in the stack
     */
    public int numberOfElements() {
        int size = 0;
        for(StackInfo sI : info)  {
            size += sI.size;
        }
        return size;
    }

    /**
     * Checks if all the stacks are full.
     * @return true if all stacks are full, false otherwise
     */
    public boolean allStackAreFull() {
        return numberOfElements() == values.length;
    }

    /**
     * Adjusts index to be within range 0 -> length - 1
     * @param ind Index to be adjusted
     * @return The adjusted index
     */
    private int adjustInd(int ind) {
        int max = values.length;
        return ((ind % max) + max) % max;
    }

    private int nextInd(int ind) {
        return adjustInd(ind + 1);
    }

    private int prevInd(int ind) {
        return adjustInd(ind - 1);
    }

    /**
     * Shifts items in stack over by one element.
     * If there is available capacity => shrink the stack by one element.
     * If no available capacity => shift the next stack over too.
     * @param stackNum The stack on which we perform the shift
     */
    private void shift(int stackNum) {
        System.out.println("/// Shifting" + stackNum);
        StackInfo stack = info[stackNum];

        // If this tack is at full capacity => need to
        // move next stack over by one element. This stack
        // can now claim the freed index.
        if(stack.size >= stack.capacity) {
            int nextStack = (stackNum + 1) % info.length;
            shift(nextStack);
            stack.capacity++;
        }

        // Shift all elements in stack over by one.
        int ind = stack.lastCapacityInd();
        while(stack.isWithinStackCapacity(ind)) {
            values[ind] = values[prevInd(ind)];
            ind = prevInd(ind);
        }

        // Adjust stack data
        values[stack.start] = 0; // Clear item
        stack.start = nextInd(stack.start); // Move start
        stack.capacity--; // Shrink capacity
    }

    /**
     * Expands stack by shifting over other stacks.
     * @param stackNum The which we expand
     */
    private void expand(int stackNum) {
        System.out.println("/// Expanding stack" + stackNum);

        shift((stackNum + 1) % info.length);
        info[stackNum].capacity++;
    }

    public void push(int stackNum, int value) throws FullStackException {
        System.out.println("/// Pushing stack " + stackNum + ": " + value);
        if (allStackAreFull()) {
            throw new FullStackException();
        }

        /* If this stack is full, expand it. */
        StackInfo stack = info[stackNum];
        if (stack.isFull()) {
            expand(stackNum);
        }

        /* Find the index of the top element in the array + 1,
         * and increment the stack pointer */
        stack.size++;
        values[stack.lastElementInd()] = value;
    }

    public int pop(int stackNum) throws Exception {
        System.out.println("/// Popping stack " + stackNum);
        StackInfo stack = info[stackNum];
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        /* Remove last element. */
        int value = values[stack.lastElementInd()];
        values[stack.lastElementInd()] = 0; // Clear item
        stack.size--; // Shrink size
        return value;
    }

    public int peek(int stackNum) {
        StackInfo stack = info[stackNum];
        return values[stack.lastElementInd()];
    }

    public int[] getValues() {
        return values;
    }

    public int[] getStackValues(int stackNum) {
        StackInfo stack = info[stackNum];
        int[] items = new int[stack.size];
        for (int i = 0; i < items.length; i++) {
            items[i] = values[adjustInd(stack.start + i)];
        }
        return items;
    }

}
