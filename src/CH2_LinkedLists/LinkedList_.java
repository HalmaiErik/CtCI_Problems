package CH2_LinkedLists;

import java.util.Objects;

public class LinkedList_ {
    static class LLNode {
        public int value;
        public LLNode next;

        public LLNode(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof LLNode)) return false;
            LLNode llNode = (LLNode) o;
            return value == llNode.value &&
                    Objects.equals(next, llNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next);
        }
    }

    LLNode head;

    public LinkedList_(int[] array) {
        this.head = new LLNode(array[0]);
        LLNode iter = this.head;

        for (int i = 1; i < array.length; i++) {
            iter.next = new LLNode(array[i]);
            iter = iter.next;
        }
    }

    public void showList() {
        LLNode iter = this.head;

        while (iter != null) {
            System.out.print(iter.value + " ");
            iter = iter.next;
        }
    }

    public static void main(String[] args) {
        LinkedList_ test = new LinkedList_(new int[] {1, 2, 3, 4, 5, 6, 99, 12, 13});
        test.showList();
    }
}
