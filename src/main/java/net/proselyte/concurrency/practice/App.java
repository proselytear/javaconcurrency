package net.proselyte.concurrency.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        List<Machine> machines = new ArrayList<>();
        List<Job> jobs = new ArrayList<>();
        try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {
            jobs.add(new Job(1));
            jobs.add(new Job(2));
            jobs.add(new Job(3));
            jobs.add(new Job(4));
            jobs.add(new Job(5));
            jobs.add(new Job(6));


            machines.add(new Machine(1, jobs));
            machines.add(new Machine(2, jobs));
            machines.add(new Machine(3, jobs));

            for(Machine s: machines) {
                executorService.execute(s);
            }
        }


    }
}
