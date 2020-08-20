package CH4_StackAndQueues;

public class QueueViaStack {
    MyStack<Integer> queueFront;
    MyStack<Integer> queueBack;

    public QueueViaStack() {
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

public static void main(String[] args) {
    QueueViaStack q = new QueueViaStack();

    q.add(1);
    q.add(2);
    q.add(3);

    System.out.println(q.remove());
    System.out.println(q.remove());
    System.out.println(q.remove());
}
}
