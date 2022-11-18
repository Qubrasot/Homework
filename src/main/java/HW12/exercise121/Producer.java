package HW12.exercise121;

import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable{
    private final LinkedBlockingQueue<String> queue;
    int currentValue;

    public Producer(LinkedBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put("Notification №" + currentValue);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        currentValue++;
        System.out.println(currentValue + " second passed...");
    }
}
