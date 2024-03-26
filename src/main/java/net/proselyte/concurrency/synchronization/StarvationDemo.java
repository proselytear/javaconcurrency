package net.proselyte.concurrency.synchronization;

import java.util.concurrent.atomic.AtomicInteger;

public class StarvationDemo {
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) {
        System.out.println("Main thread execution starts");

        // Thread priorities are set in a way that thread5
        // gets least priority.
        StarvationWorker thread1 = new StarvationWorker(atomicInteger, "T1");
        thread1.setPriority(10);
        StarvationWorker thread2 = new StarvationWorker(atomicInteger, "T2");
        thread2.setPriority(9);
        StarvationWorker thread3 = new StarvationWorker(atomicInteger, "T3");
        thread3.setPriority(8);
        StarvationWorker thread4 = new StarvationWorker(atomicInteger, "T4");
        thread4.setPriority(7);
        StarvationWorker thread5 = new StarvationWorker(atomicInteger, "T5");
        thread5.setPriority(1);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        // Here thread5 have to wait because of the
        // other thread. But after waiting for some
        // interval, thread5 will get the chance of
        // execution. It is known as Starvation

        thread5.start();
        System.out.println("Main thread execution completes");
    }
}
