package HW12.exercise122;

import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable{
    private LinkedBlockingQueue<String> queue;

    public Consumer(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            while(!queue.isEmpty()){
                System.out.println(queue.poll());
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
