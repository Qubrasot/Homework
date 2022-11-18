package HW12.exercise121;

import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable{
    private final LinkedBlockingQueue<String> queue;

    public Consumer(LinkedBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("5 SECONDS");

        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
