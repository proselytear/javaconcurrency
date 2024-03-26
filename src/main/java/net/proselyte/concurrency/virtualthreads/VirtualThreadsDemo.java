package net.proselyte.concurrency.virtualthreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadsDemo {
    public static void main(String[] args) {
        List<GenerateRandomNumberTask> tasks = generateTasks();
        long start = System.currentTimeMillis();
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            tasks.forEach(executorService::submit);
        }

        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println("Processed in: " + duration + " ms");
    }

    private static List<GenerateRandomNumberTask> generateTasks () {
        List<GenerateRandomNumberTask> tasks = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            tasks.add(new GenerateRandomNumberTask());
        }
        return tasks;
    }
}
