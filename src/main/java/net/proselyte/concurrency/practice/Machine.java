package net.proselyte.concurrency.practice;

import java.util.List;
import java.util.Random;

public class Machine implements Runnable{
    private final Integer id;
    private final List<Job> jobs;
    private final Random random;

    public Machine(Integer id, List<Job> jobs) {
        this.id = id;
        this.jobs = jobs;
        this.random = new Random();
    }

    @Override
    public void run() {

        while (true) {
            int jobId = random.nextInt(6);
            try {
                jobs.get(jobId).read(this);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return "Machine{" +
                "id=" + id +
                '}';
    }
}
