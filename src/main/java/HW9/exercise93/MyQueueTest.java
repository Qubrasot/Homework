package HW9.exercise93;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue <Double> queue = new MyQueue<>();

        // add, size, poll, peek test
        queue.add(1.0);
        queue.add(2.0);
        queue.add(3.0);
        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.peek());

        // clear test
        queue.clear();
        queue.size();
    }

}
