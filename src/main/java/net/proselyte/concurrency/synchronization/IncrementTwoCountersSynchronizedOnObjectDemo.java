package net.proselyte.concurrency.synchronization;

public class IncrementTwoCountersSynchronizedOnObjectDemo {
    static Integer counter = 0;
    static Integer anotherCounter = 0;

    private static final Object counterLock = new Object();
    private static final Object anotherCounterLock = new Object();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                incrementCounter();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                incrementAnotherCounter();
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
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println("Counter: " + counter);
        System.out.println("Time elapsed: " + duration);
    }

    private static void incrementCounter() {
        synchronized (counterLock) {
            counter++;
        }
    }

    private static void incrementAnotherCounter() {
        synchronized (anotherCounterLock) {
            anotherCounter++;
        }
    }
}
