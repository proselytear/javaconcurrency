package net.proselyte.concurrency.practice;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Job {
    private final Integer id;
    private final Lock lock;

    public Job(Integer id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public void read (Machine machine) throws  InterruptedException {
        lock.tryLock(10, TimeUnit.SECONDS);
        System.out.println(machine + " executing: " + this);
        Thread.sleep(2000);
        lock.unlock();
        System.out.println(machine + " finished job execution: " + this);
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                '}';
    }
}
