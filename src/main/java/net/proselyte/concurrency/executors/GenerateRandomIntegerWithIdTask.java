package net.proselyte.concurrency.executors;

import java.util.Random;

public class GenerateRandomIntegerWithIdTask implements Runnable {

    private final Random random = new Random();
    private final Integer id;

    public GenerateRandomIntegerWithIdTask(Integer id) {
        this.id = id;
    }

    @Override
    public void run() {
        int randomInt = random.nextInt(1000) + 1;
        System.out.println("SingleThreadPoolTask ID: " + id + ", value: " + randomInt);
    }
}
