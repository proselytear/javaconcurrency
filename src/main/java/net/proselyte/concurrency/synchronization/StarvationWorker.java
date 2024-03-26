package net.proselyte.concurrency.synchronization;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class StarvationWorker extends Thread {
    private final AtomicInteger threadCount;

    public StarvationWorker(AtomicInteger threadCount, String name) {
        this.threadCount = threadCount;
        this.setName(name);
    }


    @Override
    public void run() {
        threadCount.incrementAndGet();
        System.out.println("Thread: " + this.getName() + ", counter " + threadCount + " thread execution starts");
        System.out.println("Thread:" + this.getName() + " thread execution completes");
    }
}
