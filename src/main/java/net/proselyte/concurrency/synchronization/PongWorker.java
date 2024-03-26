package net.proselyte.concurrency.synchronization;

import java.util.concurrent.Exchanger;
import java.util.concurrent.atomic.AtomicInteger;

public class PongWorker implements Runnable {
    private final AtomicInteger counter;
    private final Exchanger<AtomicInteger> exchanger;

    public PongWorker(AtomicInteger counter, Exchanger<AtomicInteger> exchanger) {
        this.counter = counter;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true) {
            try {
                AtomicInteger exchangedCounter = exchanger.exchange(counter);
                System.out.println("PONG: " + exchangedCounter.getAndIncrement());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
