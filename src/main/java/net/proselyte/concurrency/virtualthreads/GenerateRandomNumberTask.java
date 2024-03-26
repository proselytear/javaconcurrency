package net.proselyte.concurrency.virtualthreads;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandomNumberTask implements Runnable {


    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().threadId() + " generated: " + ThreadLocalRandom.current().nextInt());
    }
}
