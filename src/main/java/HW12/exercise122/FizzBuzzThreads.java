package HW12.exercise122;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzzThreads {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();

        FizzBuzzProducer fizzBuzzProducer = new FizzBuzzProducer(queue);
        FizzProducer fizzProducer = new FizzProducer(queue);
        BuzzProducer buzzProducer = new BuzzProducer(queue);
        NumberProducer numberProducer = new NumberProducer(queue);
        Consumer consumer = new Consumer(queue);

        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(numberProducer);
        executor.execute(fizzProducer);
        executor.execute(fizzBuzzProducer);
        executor.execute(buzzProducer);
        executor.execute(consumer);

        for (int i = 1; i < 25; i++) {
            fizzProducer.setN(i);
            numberProducer.setN(i);
            buzzProducer.setN(i);
            fizzBuzzProducer.setN(i);
            while (fizzProducer.isUpdated() || numberProducer.isUpdated() || fizzBuzzProducer.isUpdated() || buzzProducer.isUpdated()){
                Thread.sleep(10);
            }
        }

        executor.shutdown();
    }
}
