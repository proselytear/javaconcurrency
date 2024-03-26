package net.proselyte.concurrency.threadsintro;

public class ThreadCounterWithDaemonFlagWorker extends Thread {
    private final String name;
    private final Integer range;

    public ThreadCounterWithDaemonFlagWorker(String name, Integer range, boolean isDaemon) {
        this.name = name;
        this.range = range;
        super.setDaemon(isDaemon);
    }

    @Override
    public void run() {
        int counter = 0;
        while (counter <= range) {
            System.out.println(name + ": " + counter++);
        }
        System.out.println(name + " COUNTER FINISHED THE WORK");
    }
}
