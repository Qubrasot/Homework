package HW12.exercise122;

import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzzProducer implements MyProducer{
    private LinkedBlockingQueue<String> queue;
    private boolean updated = false;
    private int n;

    public FizzBuzzProducer(LinkedBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public boolean isUpdated() {
        return updated;
    }

    @Override
    public void setN(int n) {
        this.n = n;
        updated = true;
    }

    @Override
    public void run() {
        while(true){
            try {
                if (updated) {
                    updated = false;
                    if (n % 3 == 0 && n % 5 == 0) {
                        queue.put("fizzbuzz");
                    }
                }
                Thread.sleep(100);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
