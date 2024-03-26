package net.proselyte.concurrency.threadsintro;

public class ThreadWithSleepCounterWorker extends Thread {
    private final String name;
    private final Integer range;

    public ThreadWithSleepCounterWorker(String name, Integer range) {
        this.name = name;
        this.range = range;
    }

    @Override
    public void run() {
        int counter = 0;
        while (counter <= range) {
            System.out.println(name + ": " + counter++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
