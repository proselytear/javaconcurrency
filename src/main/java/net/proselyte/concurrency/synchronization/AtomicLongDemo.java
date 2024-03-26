package net.proselyte.concurrency.synchronization;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongDemo {
    private static final AtomicLong atomicLongCounter = new AtomicLong(0);
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                incrementAtomicLong();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                incrementAtomicLong();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("atomicLongCounter: " + atomicLongCounter.get());
    }

    private static void incrementAtomicLong() {
        atomicLongCounter.incrementAndGet();
    }
}
