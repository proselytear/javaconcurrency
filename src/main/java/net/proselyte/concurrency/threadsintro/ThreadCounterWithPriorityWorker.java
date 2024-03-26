package net.proselyte.concurrency.threadsintro;

public class ThreadCounterWithPriorityWorker extends Thread {
    private final String name;
    private final Integer range;

    public ThreadCounterWithPriorityWorker(String name, Integer range, Integer priority) {
        this.name = name;
        this.range = range;
        super.setPriority(priority);
    }

    @Override
    public void run() {
        int counter = 0;
        while (counter <= range) {
            System.out.println(name + ": " + counter++);
        }
    }
}
