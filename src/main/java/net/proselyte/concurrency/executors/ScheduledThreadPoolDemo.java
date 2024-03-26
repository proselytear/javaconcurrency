package net.proselyte.concurrency.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        long start = System.currentTimeMillis();
        try (ScheduledExecutorService executorService = Executors.newScheduledThreadPool(cores - 1)) {

            GenerateRandomIntegerWithIdTask task1 = new GenerateRandomIntegerWithIdTask(1);
            GenerateRandomIntegerWithIdTask task2 = new GenerateRandomIntegerWithIdTask(2);
            GenerateRandomIntegerWithIdTask task3 = new GenerateRandomIntegerWithIdTask(3);
            GenerateRandomIntegerWithIdTask task4 = new GenerateRandomIntegerWithIdTask(4);
            GenerateRandomIntegerWithIdTask task5 = new GenerateRandomIntegerWithIdTask(5);


            executorService.schedule(task2, 10, TimeUnit.SECONDS);
            executorService.schedule(task1, 3, TimeUnit.SECONDS);
            executorService.schedule(task3, 2, TimeUnit.SECONDS);
            executorService.schedule(task4, 1, TimeUnit.SECONDS);
            executorService.schedule(task5, 0, TimeUnit.SECONDS);

        } finally {
            long end = System.currentTimeMillis();
            long duration = end - start;
            System.out.println("Processed in: " + duration + " ms");
        }
    }
}
