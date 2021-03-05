package CH7_RecursionAndDynamProg;

import java.util.Stack;

public class TowersOfHanoi {
    private static class Tower {
        int index;
        Stack<Integer> contents;

        public Tower(int index) {
            this.index = index;
            contents = new Stack<>();
        }

        public void add(int disk) {
            if (!contents.isEmpty() && disk >= contents.peek()) {
                System.out.println("Can't add");
            }
            else {
                contents.push(disk);
            }
        }

        public int take() {
            if (contents.isEmpty()) {
                System.out.println("Can't take");
                return -1;
            }
            else {
                return contents.pop();
            }
        }
    }

    private static Tower t1 = new Tower(1);
    private static Tower t2 = new Tower(2);
    private static Tower t3 = new Tower(3);

    private static void move(int n, Tower src, Tower buff, Tower dest) {
        if (n <= 0) {
            return;
        }

        move(n - 1, src, dest, buff);
        int diskToMove = src.take();
        if (diskToMove < 0) {
            System.out.println("Fail");
            return;
        }
        dest.add(diskToMove);
        move(n - 1, buff, src, dest);
    }

    public static void main(String[] args) {
        t1.add(3);
        t1.add(2);
        t1.add(1);

        move(3, t1, t2, t3);
        System.out.println(t1.contents);
        System.out.println(t2.contents);
        System.out.println(t3.contents);
    }
}
