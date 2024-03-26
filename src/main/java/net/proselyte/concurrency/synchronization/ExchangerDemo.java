package net.proselyte.concurrency.synchronization;

import java.util.concurrent.Exchanger;
import java.util.concurrent.atomic.AtomicInteger;

public class ExchangerDemo {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger();

        Exchanger<AtomicInteger> exchanger = new Exchanger<>();
        PingWorker pingWorker = new PingWorker(counter, exchanger);
        PongWorker pongWorker = new PongWorker(counter, exchanger);

        Thread t1 = new Thread(pingWorker);
        Thread t2 = new Thread(pongWorker);

        t1.start();
        t2.start();

    }
}
