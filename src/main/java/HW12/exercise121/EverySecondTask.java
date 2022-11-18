package HW12.exercise121;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class EverySecondTask {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleAtFixedRate(producer, 1, 1, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(consumer, 5, 5, TimeUnit.SECONDS);

        Thread.sleep(11000);
        executor.shutdown();
    }
}
