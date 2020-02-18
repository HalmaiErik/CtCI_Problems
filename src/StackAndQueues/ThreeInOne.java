package StackAndQueues;

// Flexible splitting of arrays with shifts to avoid wasted memory

public class ThreeInOne {
    private class StackInfo {
        public int start, size, capacity;
        public StackInfo(int start, int capacity) {
            this.start = start;
            this.capacity = capacity;
        }

        public boolean isWithinStackCapacity(int ind) {
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

}
